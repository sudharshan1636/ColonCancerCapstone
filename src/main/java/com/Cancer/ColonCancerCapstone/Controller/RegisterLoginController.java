package com.Cancer.ColonCancerCapstone.Controller;


import com.Cancer.ColonCancerCapstone.DTO.RequestDTO.LoginDTO;
import com.Cancer.ColonCancerCapstone.DTO.RequestDTO.RegisterDTO;
import com.Cancer.ColonCancerCapstone.DTO.RequestDTO.ResponseDTO.LoginResponseDTO;
import com.Cancer.ColonCancerCapstone.Service.RegisterLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin (origins="*")
@RequestMapping ("/user")
public class RegisterLoginController {
    @Autowired
    private RegisterLoginService registerLoginService;
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerDetails(@RequestBody RegisterDTO registerDTO){
        registerLoginService.register(registerDTO);
    }
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public LoginResponseDTO loginDetails(@RequestBody LoginDTO loginDTO){
        return registerLoginService.login(loginDTO);
    }
}
