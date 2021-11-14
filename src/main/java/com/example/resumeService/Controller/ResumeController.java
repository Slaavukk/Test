package com.example.resumeService.Controller;


import com.example.resumeService.Entity.Resume;
import com.example.resumeService.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @GetMapping("/resume")
    public List<Resume> findAll() {
        return resumeService.findAll();
    }

    @PostMapping("/create")
    public String saveResume(@RequestBody RegistrationRequest registrationRequest ) {

        resumeService.saveResume(registrationRequest);
        return "registered";
    }

    @GetMapping("/resume/{id}")
    public Resume findById(@PathVariable Long id) {
        return resumeService.findById(id);

    }

    @PutMapping("/change")
    public ResponseEntity<ResumeDto> updateResume(@RequestBody ResumeDto resumeDto) {

       return resumeService.updateResume(resumeDto);
    }

    @DeleteMapping("/resumeDelete/{id}")
    public ResponseEntity<Resume> deleteById(@PathVariable Long id) {
        Resume resume = resumeService.findById(id);
        if (resume == null) {
            return new ResponseEntity<Resume>(HttpStatus.FOUND);
        }
        resumeService.deleteById(id);
        return new ResponseEntity<Resume>(HttpStatus.NO_CONTENT);
    }


}
