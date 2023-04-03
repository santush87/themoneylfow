package bg.martin_aleksandrov.themoneylfow.domain.entities;

import bg.martin_aleksandrov.themoneylfow.domain.enums.IncomeOrOutcome;
import bg.martin_aleksandrov.themoneylfow.domain.enums.RentTypeEnum;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "rents")
public class RentEntity extends BaseEntity{

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private IncomeOrOutcome incomeOrOutcome;

    @Column
    @Enumerated(EnumType.STRING)
    private RentTypeEnum rentType;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    private UserEntity userEntity;
}
