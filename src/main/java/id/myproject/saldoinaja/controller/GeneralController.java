package id.myproject.saldoinaja.controller;

import id.myproject.saldoinaja.repository.WalletRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Muamar Hanafi | xsis.muamarh@xlsmart.co.id | 2026-02-10
 */
@Controller
public class GeneralController {

    private final WalletRepository walletRepository;

    public GeneralController(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("wallets", walletRepository.findAll());
        return "index";
    }
}
