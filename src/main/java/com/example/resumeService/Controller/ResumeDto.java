package com.example.resumeService.Controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data

public class ResumeDto {

    @NotEmpty
    private Long id;

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
    private String movieDescription;
}
