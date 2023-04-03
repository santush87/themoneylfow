package bg.martin_aleksandrov.themoneylfow.domain.entities;

import bg.martin_aleksandrov.themoneylfow.domain.enums.Gender;
import bg.martin_aleksandrov.themoneylfow.domain.enums.UserRoleEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private UserRoleEnum userRole;

    @OneToMany(cascade = CascadeType.MERGE)
    private List<UserRoleEntity> roles;

    @Column
    private LocalDate createdOn;

    @Column
    private LocalDate lastModified;

}