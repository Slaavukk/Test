package com.example.resumeService.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name = "resume")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String name;
    private String lastname;
    private Date birthday;
    private String experience;
    private String contacts;
    private String aboutMe;
    private String movieDescription;


}

