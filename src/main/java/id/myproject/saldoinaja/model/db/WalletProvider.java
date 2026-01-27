package id.myproject.saldoinaja.model.db;

import id.myproject.saldoinaja.model.enums.WalletType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Muamar Hanafi | xsis.muamarh@xlsmart.co.id | 2026-01-26
 */
@Data
@Entity
@Table(name = "wallet_provider")
@Accessors(chain = true)
public class WalletProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "wallet_type", nullable = false)
    private WalletType walletType;

    @Column(name = "icon")
    private String icon;
}
