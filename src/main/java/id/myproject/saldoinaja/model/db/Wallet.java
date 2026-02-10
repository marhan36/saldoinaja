package id.myproject.saldoinaja.model.db;

import id.myproject.saldoinaja.model.enums.WalletType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

/**
 * @author Muamar Hanafi | xsis.muamarh@xlsmart.co.id | 2026-01-26
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "wallet")
public class Wallet {

    public Wallet(String name, WalletType walletType, Long providerId, Long balance, boolean preset) {
        this.name = name;
        this.walletType = walletType;
        this.providerId = providerId;
        this.balance = balance != null ? balance : 0L;
        this.preset = preset;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "preset", nullable = false)
    private boolean preset;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "wallet_type", nullable = false)
    private WalletType walletType;

    @Column(name = "provider_id", nullable = false)
    private Long providerId;

    @Column(name = "balance", nullable = false)
    private Long balance;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Date createdAt;
}
