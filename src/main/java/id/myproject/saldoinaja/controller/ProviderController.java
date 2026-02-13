package id.myproject.saldoinaja.controller;

import id.myproject.saldoinaja.model.db.WalletProvider;
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
public class ProviderController {

    private final WalletService walletService;

    public ProviderController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping("/providers")
    public String listProviders(@RequestParam(required = false) WalletType type, Model model) {
        if (type != null) {
            model.addAttribute("providers", walletService.getAllProviders().stream()
                    .filter(p -> p.getWalletType() == type).toList());
            model.addAttribute("selectedType", type);
        } else {
            model.addAttribute("providers", walletService.getAllProviders());
        }
        return "providers";
    }

    @GetMapping("/provider/add")
    public String addProviderForm() {
        return "add-provider";
    }

    @PostMapping("/provider/add")
    public String addProvider(@RequestParam String name, @RequestParam WalletType walletType) {
        WalletProvider provider = new WalletProvider(name, walletType, false);
        walletService.addWalletProvider(provider);
        return "redirect:/providers?success=provider_added";
    }

    @GetMapping("/provider/details/{id}")
    public String providerDetails(@PathVariable Long id, Model model) {
        WalletProvider provider = walletService.getAllProviders().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Provider not found"));
        model.addAttribute("provider", provider);
        return "provider-details";
    }

    @PostMapping("/provider/edit/{id}")
    public String editProvider(@PathVariable Long id, @RequestParam String name, 
                              @RequestParam WalletType walletType) {
        WalletProvider provider = new WalletProvider(name, walletType, false);
        provider.setId(id);
        walletService.editWalletProvider(id, provider);
        return "redirect:/providers?success=provider_updated";
    }

    @PostMapping("/provider/delete/{id}")
    public String deleteProvider(@PathVariable Long id) {
        walletService.deleteWalletProvider(id);
        return "redirect:/providers?success=provider_deleted";
    }
}