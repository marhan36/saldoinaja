package id.myproject.saldoinaja.model.db;

import id.myproject.saldoinaja.model.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Muamar Hanafi | xsis.muamarh@xlsmart.co.id | 2026-01-26
 */
@Data
@Entity
@Table(name = "category")
@Accessors(chain = true)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "transaction_type", nullable = false)
    private TransactionType transactionType;
}
