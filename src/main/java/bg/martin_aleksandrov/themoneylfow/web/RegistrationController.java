package bg.martin_aleksandrov.themoneylfow.web;

import bg.martin_aleksandrov.themoneylfow.domain.dtos.binding.UserRegisterFormDto;
import bg.martin_aleksandrov.themoneylfow.domain.enums.Gender;
import bg.martin_aleksandrov.themoneylfow.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class RegistrationController {
    private static final String BINDING_RESULT_PATH = "org.springframework.validation.BindingResult.";
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegister() {
        return "auth-register";
    }

    @PostMapping("/register")
    public String postRegister(
            @Valid UserRegisterFormDto userRegisterForm,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userRegisterForm", userRegisterForm)
                    .addFlashAttribute(BINDING_RESULT_PATH + "userRegisterForm", bindingResult);

            return "redirect:/users/register";
        }

        userService.registerUser(userRegisterForm);

        return "redirect:/users/login";
    }



    // Model attributes

    @ModelAttribute(name = "userRegisterForm")
    public UserRegisterFormDto initUserRegisterFormDto() {
        return new UserRegisterFormDto();
    }
}
