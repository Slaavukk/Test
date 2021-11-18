package com.example.resumeService.controller;


import com.example.resumeService.dto.RegistrationRequest;
import com.example.resumeService.dto.ResumeDto;
import com.example.resumeService.entity.Resume;
import com.example.resumeService.service.Resume_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResumeController {

    @Autowired
    private Resume_service resumeService;

    @GetMapping("/resume")
    public List<Resume> findAll() {
        return resumeService.findAll();
    }

    @PostMapping("/create")
    public String saveResume(@RequestBody RegistrationRequest registrationRequest) {
        resumeService.saveResume(registrationRequest);
        return "registered";
    }

    @GetMapping("/resume/{id}")
    public Resume findById(@PathVariable String id) {
        return resumeService.findById(id);
    }

    @PutMapping("/change")
    public ResponseEntity<ResumeDto> updateResume(@RequestBody ResumeDto resumeDto) {
        return resumeService.updateResume(resumeDto);
    }

    @DeleteMapping("/resumeDelete/{id}")
    public ResponseEntity<Resume> deleteById(@PathVariable String id) {
        Resume resume = resumeService.findById(id);
        if (resume == null) {
            return new ResponseEntity<Resume>(HttpStatus.NO_CONTENT);
        }
        resumeService.deleteById(id);
        return new ResponseEntity<Resume>(HttpStatus.FOUND);
    }


}
