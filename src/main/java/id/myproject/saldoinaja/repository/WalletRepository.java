package id.myproject.saldoinaja.repository;

import id.myproject.saldoinaja.model.db.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Muamar Hanafi | xsis.muamarh@xlsmart.co.id | 2026-01-26
 */
public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
