package id.myproject.saldoinaja.controller;

import id.myproject.saldoinaja.model.db.Wallet;
import id.myproject.saldoinaja.model.enums.WalletType;
import id.myproject.saldoinaja.service.WalletService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Muamar Hanafi | xsis.muamarh@xlsmart.co.id | 2026-01-27
 */

@Controller
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping("/wallet/add")
    public String addWalletForm(Model model) {
        model.addAttribute("providers", walletService.getAllProviders());
        return "add-wallet";
    }

    @PostMapping("/wallet/add")
    public String addWallet(@RequestParam String name, @RequestParam WalletType walletType,
                            @RequestParam Long providerId, @RequestParam Long balance) {
        walletService.addWallet(name, walletType, providerId, balance);
        return "redirect:/";
    }

    @PostMapping("/wallet/edit/{id}")
    public String editWallet(@PathVariable Long id, @RequestParam String name, 
                            @RequestParam WalletType walletType, @RequestParam Long providerId, 
                            @RequestParam Long balance) {
        Wallet wallet = new Wallet(name, walletType, 
                walletService.getAllProviders().stream()
                        .filter(p -> p.getId().equals(providerId))
                        .findFirst().orElseThrow(), balance, false);
        wallet.setId(id);
        walletService.editWallet(id, wallet);
        return "redirect:/";
    }

    @PostMapping("/wallet/delete/{id}")
    public String deleteWallet(@PathVariable Long id) {
        walletService.deleteWallet(id);
        return "redirect:/";
    }

    @GetMapping("/wallet/details/{id}")
    public String walletDetails(@PathVariable Long id, Model model) {
        Wallet wallet = walletService.getWalletById(id);
        model.addAttribute("wallet", wallet);
        model.addAttribute("providers", walletService.getAllProviders());
        return "wallet-details";
    }
}
