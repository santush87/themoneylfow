package bg.martin_aleksandrov.themoneylfow.domain.entities;

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
@Table(name = "salaries")
public class SalaryEntity extends BaseEntity{

    @Column(nullable = false)
    private BigDecimal salary;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private IncomeOrOutcome incomeOrOutcome;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    private UserEntity userEntity;
}
