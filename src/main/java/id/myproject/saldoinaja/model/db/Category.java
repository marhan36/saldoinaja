package id.myproject.saldoinaja.model.db;

import id.myproject.saldoinaja.model.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author Muamar Hanafi | xsis.muamarh@xlsmart.co.id | 2026-01-26
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "category")
public class Category {

    public Category(String name, TransactionType transactionType) {
        this.name = name;
        this.transactionType = transactionType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false)
    private TransactionType transactionType;
}
