package bg.martin_aleksandrov.themoneylfow.repositories;

import bg.martin_aleksandrov.themoneylfow.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
        Optional<UserEntity> findByEmail(String email);
}
