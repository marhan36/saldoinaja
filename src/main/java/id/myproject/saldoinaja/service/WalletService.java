package id.myproject.saldoinaja.service;

import id.myproject.saldoinaja.model.db.Wallet;
import id.myproject.saldoinaja.model.db.WalletProvider;
import id.myproject.saldoinaja.model.enums.WalletType;
import id.myproject.saldoinaja.repository.WalletProviderRepository;
import id.myproject.saldoinaja.repository.WalletRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Muamar Hanafi | xsis.muamarh@xlsmart.co.id | 2026-02-06
 */

@Service
public class WalletService {
    
    private final WalletRepository walletRepository;
    private final WalletProviderRepository walletProviderRepository;

    public WalletService(WalletRepository walletRepository, WalletProviderRepository walletProviderRepository) {
        this.walletRepository = walletRepository;
        this.walletProviderRepository = walletProviderRepository;
    }

    public Wallet addWallet(String name, WalletType walletType, Long providerId, Long balance) {
        WalletProvider provider = walletProviderRepository.findById(providerId)
                .orElseThrow(() -> new RuntimeException("Provider not found"));
        return walletRepository.save(new Wallet(name, walletType, provider, balance, false));
    }

    public Wallet editWallet(Long id, Wallet wallet) {
        Wallet existingWallet = walletRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));
        if (existingWallet.isPreset()) {
            throw new RuntimeException("Cannot edit preset wallet");
        }
        return walletRepository.save(wallet);
    }

    public void deleteWallet(Long id) {
        Wallet existingWallet = walletRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));
        if (existingWallet.isPreset()) {
            throw new RuntimeException("Cannot delete preset wallet");
        }
        walletRepository.deleteById(id);
    }

    public WalletProvider addWalletProvider(WalletProvider provider) {
        provider.setPreset(false);
        return walletProviderRepository.save(provider);
    }

    public WalletProvider editWalletProvider(Long id, WalletProvider provider) {
        WalletProvider existingProvider = walletProviderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Provider not found"));
        if (existingProvider.isPreset()) {
            throw new RuntimeException("Cannot edit preset provider");
        }
        return walletProviderRepository.save(provider);
    }

    public void deleteWalletProvider(Long id) {
        WalletProvider existingProvider = walletProviderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Provider not found"));
        if (existingProvider.isPreset()) {
            throw new RuntimeException("Cannot delete preset provider");
        }
        walletProviderRepository.deleteById(id);
    }

    public List<Wallet> getAllWallets() {
        return walletRepository.findAll();
    }

    public List<WalletProvider> getAllProviders() {
        return walletProviderRepository.findAll();
    }
}
