package id.myproject.saldoinaja.init;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Muamar Hanafi | xsis.muamarh@xlsmart.co.id | 2026-01-26
 */
@Entity
@Table(name = "app_init")
@AllArgsConstructor
@NoArgsConstructor
public class AppInit {

    @Id
    private String name;
    private LocalDateTime executedAt;
}
