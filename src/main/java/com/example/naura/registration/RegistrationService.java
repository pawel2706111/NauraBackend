package com.example.naura.registration;

import com.example.naura.appuser.AppUser;
import com.example.naura.appuser.AppUserRole;
import com.example.naura.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail){
            throw new IllegalStateException("email nie poprawny");
        }
        return appUserService.singUpUser(new AppUser(
                request.getName(),
                request.getEmail(),
                request.getPassword(),
                AppUserRole.WLASCICIEL
                ));
    }
}
