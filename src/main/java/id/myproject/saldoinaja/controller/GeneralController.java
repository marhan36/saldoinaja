package id.myproject.saldoinaja.controller;

import id.myproject.saldoinaja.model.db.Wallet;
import id.myproject.saldoinaja.model.enums.WalletType;
import id.myproject.saldoinaja.service.WalletService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Muamar Hanafi | xsis.muamarh@xlsmart.co.id | 2026-02-10
 */

@Controller
public class GeneralController {

    private final WalletService walletService;

    public GeneralController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("wallets", walletService.getAllWallets());
        return "index";
    }
}
