package com.example.resumeService.dto;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data

public class RegistrationRequest {

    @NotEmpty
    private String name;

    @NotEmpty
    private String lastname;

    @NotNull
    private Date birthday;

    @NotEmpty
    private String experience;

    @NotEmpty
    private String contacts;

    @NotEmpty
    private String aboutMe;

    @NotEmpty
    private String movieName;
}
