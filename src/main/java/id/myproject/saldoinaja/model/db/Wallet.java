package id.myproject.saldoinaja.model.db;

import id.myproject.saldoinaja.model.enums.WalletType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author Muamar Hanafi | xsis.muamarh@xlsmart.co.id | 2026-01-26
 */
@Data
@Entity
@Table(name = "wallet")
@Accessors(chain = true)
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "wallet_type", nullable = false)
    private WalletType walletType;

    @Column(name = "provider_id", nullable = false)
    private String providerId;

    @Column(name = "balance", nullable = false)
    private Long balance;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;
}
