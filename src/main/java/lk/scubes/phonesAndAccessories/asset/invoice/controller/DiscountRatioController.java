package lk.scubes.phonesAndAccessories.asset.invoice.controller;


import lk.scubes.phonesAndAccessories.asset.invoice.entity.DiscountRatio;
import lk.scubes.phonesAndAccessories.asset.invoice.service.DiscountRatioService;
import lk.scubes.phonesAndAccessories.util.interfaces.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/discountRatio")
public class DiscountRatioController implements AbstractController<DiscountRatio,Integer> {
    private final DiscountRatioService discountRatioService;
@Autowired
    public DiscountRatioController(DiscountRatioService discountRatioService) {
        this.discountRatioService = discountRatioService;
    }
@GetMapping
    public String findAll(Model model) {
        model.addAttribute("discountRatios",discountRatioService.findAll());
        return "discountRatio/discountRatio";
    }

    public String findById(Integer id, Model model) {
        return null;
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("addStatus", false);
        model.addAttribute("discountRatio", discountRatioService.findById(id));
        return "discountRatio/addDiscountRatio";
    }

    @PostMapping(value = {"/save", "/update"})
    public String persist(@Valid @ModelAttribute DiscountRatio discountRatio, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("addStatus", true);
            model.addAttribute("discountRatio", bindingResult);
            return "discountRatio/addDiscountRatio";
        }
        discountRatioService.persist(discountRatio);
        return "redirect:/discountRatio";
    }

    @GetMapping( "/delete/{id}" )
    public String delete(@PathVariable Integer id, Model model) {
        discountRatioService.delete(id);
        return "redirect:/discountRatio";
    }
    @GetMapping("/add")
    public String form(Model model) {
        model.addAttribute("addStatus", true);
        model.addAttribute("discountRatio", new DiscountRatio());
        return "discountRatio/addDiscountRatio";
    }
    @GetMapping( "/{id}" )
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("discountRatioDetail", discountRatioService.findById(id));
        return "discountRatio/discountRatio-detail";
    }

}
