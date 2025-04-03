package com.Cancer.ColonCancerCapstone.Service;


import com.Cancer.ColonCancerCapstone.DTO.RequestDTO.LoginDTO;
import com.Cancer.ColonCancerCapstone.DTO.RequestDTO.RegisterDTO;
import com.Cancer.ColonCancerCapstone.DTO.RequestDTO.ResponseDTO.LoginResponseDTO;
import com.Cancer.ColonCancerCapstone.Model.Register;
import com.Cancer.ColonCancerCapstone.Repository.LoginRepository;
import com.Cancer.ColonCancerCapstone.Repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterLoginService {
    @Autowired
    private RegisterRepository registerRepository;
    @Autowired
    private LoginRepository loginRepository;
    public void register(RegisterDTO registerDTO){
        Register reg=new Register(registerDTO.getFisrtName(), registerDTO.getLastName(), registerDTO.getEmail(), registerDTO.getUserName(), registerDTO.getPassword());
        registerRepository.save(reg);
    }
    public LoginResponseDTO login(LoginDTO loginDTO){
        LoginResponseDTO loginResponseDTO;
        String username=loginDTO.getUserName();
        String password=loginDTO.getPassword();
        Integer bool=registerRepository.findDetails(username, password);
        if(bool==null){
            loginResponseDTO = new LoginResponseDTO();
            loginResponseDTO.setStatus(404);
            loginResponseDTO.setMessage("Not found");
        }
        else if(bool==1){
            loginResponseDTO=new LoginResponseDTO();
            loginResponseDTO.setStatus(100);
            loginResponseDTO.setMessage("ok");
        }
        else {
            loginResponseDTO = new LoginResponseDTO();
            loginResponseDTO.setStatus(404);
            loginResponseDTO.setMessage("Not found");
        }
        return loginResponseDTO;
    }
}

