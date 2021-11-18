package com.example.resumeService.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "resume")
@Document(collection = "resume")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private String id;
    @Indexed
    private String name;
    private String lastname;
    private Date birthday;
    private String experience;
    private String contacts;
    private String aboutMe;
    private String movieDescription;


}

