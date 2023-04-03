package bg.martin_aleksandrov.themoneylfow.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Household_expenses")
public class HouseholdExpensesEntity extends BaseEntity{

    @Column
    private BigDecimal food;
    @Column
    private BigDecimal electric;
    @Column
    private BigDecimal phone;
    @Column
    private BigDecimal water;
    @Column
    private BigDecimal clothes;
    @Column(columnDefinition = "TEXT")
    private String description;
    @ManyToOne
    private UserEntity userEntity;
}
