package bg.martin_aleksandrov.themoneylfow.services;

import bg.martin_aleksandrov.themoneylfow.domain.dtos.binding.UserRegisterFormDto;
import bg.martin_aleksandrov.themoneylfow.domain.entities.UserEntity;
import bg.martin_aleksandrov.themoneylfow.domain.enums.UserRoleEnum;
import bg.martin_aleksandrov.themoneylfow.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    public void findUserByEmail(String email){
        Optional<UserEntity> user = this.userRepository.findByEmail(email);
    }

    public void registerUser(UserRegisterFormDto registrationDTO) {

        UserEntity userEntity = this.modelMapper.map(registrationDTO, UserEntity.class);

        userEntity.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        userEntity.setCreatedOn(LocalDate.now());
        userEntity.setLastModified(LocalDate.now());
        if (this.userRepository.count()==0){
            userEntity.setUserRole(UserRoleEnum.ADMIN);
        } else {
            userEntity.setUserRole(UserRoleEnum.USER);
        }

        userRepository.save(userEntity);
    }
}
