package lk.scubes.phonesAndAccessories.asset.ledger.controller;


import lk.scubes.phonesAndAccessories.asset.ledger.entity.Ledger;
import lk.scubes.phonesAndAccessories.asset.ledger.service.LedgerService;
import lk.scubes.phonesAndAccessories.util.interfaces.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/ledger")
public  class LedgerController implements AbstractController<Ledger,Integer> {
    private final LedgerService ledgerService;

@Autowired
public LedgerController(LedgerService ledgerService) {
    this.ledgerService = ledgerService;
   /* this.makeAutoGenerateNumberService = makeAutoGenerateNumberService;
    this.emailService = emailService;
    this.twilioMessageService = twilioMessageService;*/
}

    public String findAll(Model model) {
        return null;
    }

    public String findById(Integer id, Model model) {
        return null;
    }

    public String edit(Integer id, Model model) {
        return null;
    }

    public String persist(@Valid Ledger ledger, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        return null;
    }

    public String delete(Integer id, Model model) {
        return null;
    }

    public String form(Model model) {
        return null;
    }
}
