package id.myproject.saldoinaja.init;

import id.myproject.saldoinaja.model.db.Wallet;
import id.myproject.saldoinaja.model.db.WalletProvider;
import id.myproject.saldoinaja.model.enums.WalletType;
import id.myproject.saldoinaja.repository.WalletProviderRepository;
import id.myproject.saldoinaja.repository.WalletRepository;
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
    private final WalletRepository walletRepository;
    private final WalletProviderRepository walletProviderRepository;

    public DataInitializer(AppInitRepository initRepo, WalletRepository walletRepository, WalletProviderRepository walletProviderRepository) {
        this.initRepo = initRepo;
        this.walletRepository = walletRepository;
        this.walletProviderRepository = walletProviderRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        if (initRepo.existsById("INITIAL_DATA")) {
            return;
        }

        walletProviderRepository.save(new WalletProvider("Cash", WalletType.CASH, true));
        walletProviderRepository.save(new WalletProvider("BCA", WalletType.BANK, true));
        walletProviderRepository.save(new WalletProvider("BRI", WalletType.BANK, true));
        walletProviderRepository.save(new WalletProvider("Dana", WalletType.EWALLET, true));
        walletProviderRepository.save(new WalletProvider("GoPay", WalletType.EWALLET, true));

        walletRepository.save(new Wallet("Cash", WalletType.CASH, 1L, 0L, true));

        initRepo.save(new AppInit("INITIAL_DATA", LocalDateTime.now()));
    }
}
