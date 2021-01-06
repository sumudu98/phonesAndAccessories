package scubes.phonesAndAccessories.asset.invoice.entity;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import scubes.phonesAndAccessories.asset.customer.entity.Customer;
import scubes.phonesAndAccessories.asset.discountRatio.entity.DiscountRatio;
import scubes.phonesAndAccessories.asset.invoice.entity.Enum.InvoicePrintOrNot;
import scubes.phonesAndAccessories.asset.invoice.entity.Enum.InvoiceValidOrNot;
import scubes.phonesAndAccessories.asset.invoice.entity.Enum.PaymentMethod;
import scubes.phonesAndAccessories.util.audit.AuditEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("Invoice")
@JsonIgnoreProperties(value = {"balance", "discountAmount", "bankName", "cardNumber"}, allowGetters = true)
public class Invoice extends AuditEntity {

    private String bankName;

    private String cardNumber;

    private String remarks;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @Column(precision = 10, scale = 2)
    private BigDecimal discountAmount;

    @Column(precision = 10, scale = 2)
    private BigDecimal amountTendered;

    @Column(precision = 10, scale = 2)
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private InvoicePrintOrNot invoicePrintOrNot;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private InvoiceValidOrNot invoiceValidOrNot;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private DiscountRatio discountRatio;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "invoice")
    private List< InvoiceItem > invoiceItemQuantities;


}