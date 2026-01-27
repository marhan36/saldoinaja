package id.myproject.saldoinaja.model.db;

import id.myproject.saldoinaja.model.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

/**
 * @author Muamar Hanafi | xsis.muamarh@xlsmart.co.id | 2026-01-26
 */
@Data
@Entity
@Table(name = "category")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transaction_type", nullable = false)
    private TransactionType transactionType;

    @Column(name = "amount", nullable = false)
    private Long amount;

    @Column(name = "wallet_from_id")
    private String walletFromId;

    @Column(name = "wallet_to_id")
    private String walletToId;

    @Column(name = "category_id")
    private String categoryId;

    @Column(name = "note")
    private String note;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;
}
