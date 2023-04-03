package bg.martin_aleksandrov.themoneylfow.domain.entities;

import bg.martin_aleksandrov.themoneylfow.domain.enums.CreditType;
import bg.martin_aleksandrov.themoneylfow.domain.enums.IncomeOrOutcome;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "credits")
public class CreditEntity extends BaseEntity{
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private IncomeOrOutcome incomeOrOutcome;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CreditType creditType;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(columnDefinition = "TEXT")
    private String description;
}
