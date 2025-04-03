package com.Cancer.ColonCancerCapstone.DTO.RequestDTO.ResponseDTO;

import lombok.Data;

@Data
public class LoginResponseDTO {
    private Integer status;
    private String message;

    public void setStatus(Integer status) {
        this.status=status;
    }

    public void setMessage(String message) {
        this.message=message;

    }
}
