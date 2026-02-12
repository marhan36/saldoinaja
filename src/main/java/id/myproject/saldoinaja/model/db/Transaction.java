package id.myproject.saldoinaja.model.db;

import id.myproject.saldoinaja.model.enums.TransactionType;
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
@Table(name = "category")
public class Transaction {

    public Transaction(TransactionType transactionType, Long amount, Wallet walletFromId, Wallet walletToId, Long categoryId) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.walletFromId = walletFromId;
        this.walletToId = walletToId;
        this.categoryId = categoryId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false)
    private TransactionType transactionType;

    @Column(name = "amount", nullable = false)
    private Long amount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wallet_from_id")
    private Wallet walletFromId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wallet_to_id")
    private Wallet walletToId;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "note")
    private String note;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Date createdAt;
}
