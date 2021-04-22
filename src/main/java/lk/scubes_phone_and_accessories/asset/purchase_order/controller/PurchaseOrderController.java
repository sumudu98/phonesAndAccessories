package lk.scubes_phone_and_accessories.asset.purchase_order.controller;


import lk.scubes_phone_and_accessories.asset.common_asset.service.CommonService;
import lk.scubes_phone_and_accessories.asset.item.entity.Item;
import lk.scubes_phone_and_accessories.asset.item.service.ItemService;
import lk.scubes_phone_and_accessories.asset.purchase_order.entity.PurchaseOrder;
import lk.scubes_phone_and_accessories.asset.purchase_order.entity.enums.PurchaseOrderPriority;
import lk.scubes_phone_and_accessories.asset.purchase_order.entity.enums.PurchaseOrderStatus;
import lk.scubes_phone_and_accessories.asset.purchase_order.service.PurchaseOrderService;
import lk.scubes_phone_and_accessories.asset.purchase_order_item.entity.PurchaseOrderItem;
import lk.scubes_phone_and_accessories.asset.supplier.entity.Supplier;
import lk.scubes_phone_and_accessories.asset.supplier.service.SupplierService;
import lk.scubes_phone_and_accessories.asset.supplier_item.controller.SupplierItemController;
import lk.scubes_phone_and_accessories.asset.supplier_item.entity.SupplierItem;
import lk.scubes_phone_and_accessories.asset.supplier_item.service.SupplierItemService;
import lk.scubes_phone_and_accessories.util.service.EmailService;
import lk.scubes_phone_and_accessories.util.service.MakeAutoGenerateNumberService;
import lk.scubes_phone_and_accessories.util.service.OperatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping( "/purchaseOrder" )
public class PurchaseOrderController {
    private final PurchaseOrderService purchaseOrderService;
    private final SupplierService supplierService;
    private final CommonService commonService;
    private final MakeAutoGenerateNumberService makeAutoGenerateNumberService;
    private final OperatorService operatorService;
    private final EmailService emailService;
    private final ItemService itemService;
    private final SupplierItemService supplierItemService;

    public PurchaseOrderController(PurchaseOrderService purchaseOrderService,
                                   SupplierService supplierService
            , CommonService commonService, MakeAutoGenerateNumberService makeAutoGenerateNumberService,
                                   OperatorService operatorService, EmailService emailService, ItemService itemService, SupplierItemService supplierItemService) {
        this.purchaseOrderService = purchaseOrderService;
        this.supplierService = supplierService;
        this.commonService = commonService;
        this.makeAutoGenerateNumberService = makeAutoGenerateNumberService;
        this.operatorService = operatorService;
        this.emailService = emailService;
        this.itemService = itemService;
        this.supplierItemService = supplierItemService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("purchaseOrders", purchaseOrderService.findAll());
        model.addAttribute("heading", "All Purchase Order");
        model.addAttribute("grnStatus",false);
        return "purchaseOrder/purchaseOrder";
    }

    @GetMapping( "/add" )
    public String addForm(Model model) {
        model.addAttribute("purchaseOrder", new Supplier());
        model.addAttribute("searchAreaShow", true);
        return "purchaseOrder/addPurchaseOrder";
    }

    @PostMapping( "/find" )
    public String search(@Valid @ModelAttribute Supplier supplier, Model model) {
        return commonService.purchaseOrder(supplier, model, "purchaseOrder/addPurchaseOrder");
    }


    @GetMapping( "/{id}" )
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("purchaseOrderDetail", purchaseOrderService.findById(id));
        return "purchaseOrder/purchaseOrder-detail";

    }

    @PostMapping( "/save" )
    public String purchaseOrderPersist(@Valid @ModelAttribute PurchaseOrder purchaseOrder,
                                       BindingResult bindingResult) {
        if ( bindingResult.hasErrors() ) {
            return "redirect:/purchaseOrder/" + purchaseOrder.getId();
        }
        purchaseOrder.setPurchaseOrderStatus(PurchaseOrderStatus.NOT_COMPLETED);
        if ( purchaseOrder.getId() == null ) {
            if ( purchaseOrderService.lastPurchaseOrder() == null ) {
                //need to generate new one
                purchaseOrder.setCode("SPPO" + makeAutoGenerateNumberService.numberAutoGen(null).toString());
            } else {
                System.out.println("last customer not null");
                //if there is customer in db need to get that customer's code and increase its value
                String previousCode = purchaseOrderService.lastPurchaseOrder().getCode().substring(4);
                purchaseOrder.setCode("SPPO" + makeAutoGenerateNumberService.numberAutoGen(previousCode).toString());
            }
        }
        List< PurchaseOrderItem > purchaseOrderItemList = new ArrayList<>();
        for ( PurchaseOrderItem purchaseOrderItem : purchaseOrder.getPurchaseOrderItems() ) {
            if ( purchaseOrderItem.getItem() != null ) {
                purchaseOrderItem.setPurchaseOrder(purchaseOrder);
                purchaseOrderItemList.add(purchaseOrderItem);
            }
        }
        purchaseOrder.setPurchaseOrderItems(purchaseOrderItemList);
        PurchaseOrder purchaseOrderSaved = purchaseOrderService.persist(purchaseOrder);

        if (purchaseOrderSaved.getSupplier().getEmail() != null) {
            StringBuilder message = new StringBuilder("Item Name\t\t\t\t\tQuantity\t\t\tItem Price\t\t\tTotal(Rs)\n");
            for (int i = 0; i < purchaseOrder.getPurchaseOrderItems().size(); i++) {
                Item item = itemService.findById(purchaseOrder.getPurchaseOrderItems().get(i).getItem().getId());
                SupplierItem supplierItem = supplierItemService.findBySupplierAndItem(purchaseOrderSaved
                .getSupplier(), item);
                message
                        .append(item.getName())
                        .append("\t\t\t\t\t")
                        .append(purchaseOrderSaved.getPurchaseOrderItems().get(i).getQuantity())
                        .append("\t\t\t")
                        .append(supplierItem.getPrice())
                        .append("\t\t\t")
                        .append(purchaseOrderSaved.getPurchaseOrderItems().get(i).getLineTotal()).append("\n");
            }
            emailService.sendEmail(purchaseOrderSaved.getSupplier().getEmail(), "Requesting Items According To PO Code " + purchaseOrder.getCode(), message.toString());
        }
        return "redirect:/purchaseOrder/all";
    }

    @GetMapping( "/all" )
    public String findAll(Model model) {
        model.addAttribute("purchaseOrders", purchaseOrderService.findAll()
                .stream()
                .filter(x -> x.getPurchaseOrderStatus().equals(PurchaseOrderStatus.NOT_COMPLETED))
                .collect(Collectors.toList()));
        model.addAttribute("heading", "Pending Purchase Order");
        model.addAttribute("grnStatus",true);
        return "purchaseOrder/purchaseOrder";
    }

    @GetMapping( "view/{id}" )
    public String viewPurchaseOrderDetail(@PathVariable Integer id, Model model) {
        model.addAttribute("purchaseOrderDetail", purchaseOrderService.findById(id));
        return "purchaseOrder/purchaseOrder-detail";
    }

    @GetMapping( "delete/{id}" )
    public String deletePurchaseOrderDetail(@PathVariable Integer id) {
        PurchaseOrder purchaseOrder = purchaseOrderService.findById(id);
        purchaseOrder.setPurchaseOrderStatus(PurchaseOrderStatus.NOT_PROCEED);
        purchaseOrderService.persist(purchaseOrder);
        return "redirect:/purchaseOrder/all";
    }


    @GetMapping( "/supplier/{id}" )
    public String addPriceToSupplierItem(@PathVariable int id, Model model) {
        Supplier supplier = supplierService.findById(id);
        // supplier.setSupplierItems(purchaseOrders);
        model.addAttribute("supplierDetail", supplier);
        model.addAttribute("supplierDetailShow", false);
        model.addAttribute("purchaseOrderItemEdit", false);
        model.addAttribute("purchaseOrder", new PurchaseOrder());
        model.addAttribute("purchaseOrderPriorities", PurchaseOrderPriority.values());
        //send all active item belongs to supplier
        model.addAttribute("items", commonService.activeItemsFromSupplier(supplier));
        Object[] argument = {"", ""};
        model.addAttribute("purchaseOrderItemUrl", MvcUriComponentsBuilder
                .fromMethodName(SupplierItemController.class, "purchaseOrderSupplierItem", argument)
                .build()
                .toString());

        return "purchaseOrder/addPurchaseOrder";
    }


}
