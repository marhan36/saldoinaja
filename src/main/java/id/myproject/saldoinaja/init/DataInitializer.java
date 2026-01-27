package id.myproject.saldoinaja.init;

import id.myproject.saldoinaja.model.db.WalletProvider;
import id.myproject.saldoinaja.model.enums.WalletType;
import id.myproject.saldoinaja.repository.WalletProviderRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Muamar Hanafi | xsis.muamarh@xlsmart.co.id | 2026-01-26
 */
@Component
public class DataInitializer implements CommandLineRunner {

    private final AppInitRepository initRepo;
    private final WalletProviderRepository walletProviderRepository;

    public DataInitializer(AppInitRepository initRepo, WalletProviderRepository walletProviderRepository) {
        this.initRepo = initRepo;
        this.walletProviderRepository = walletProviderRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        if (initRepo.existsById("INITIAL_DATA")) {
            return;
        }

        walletProviderRepository.save(new WalletProvider().setWalletType(WalletType.CASH).setName("Cash"));
        walletProviderRepository.save(new WalletProvider().setWalletType(WalletType.BANK).setName("BCA"));
        walletProviderRepository.save(new WalletProvider().setWalletType(WalletType.BANK).setName("BRI"));
        walletProviderRepository.save(new WalletProvider().setWalletType(WalletType.EWALLET).setName("Dana"));
        walletProviderRepository.save(new WalletProvider().setWalletType(WalletType.EWALLET).setName("GoPay"));

        initRepo.save(new AppInit("INITIAL_DATA", LocalDateTime.now()));
    }
}
