package com.example.resumeService.service;

import com.example.resumeService.Controller.RegistrationRequest;
import com.example.resumeService.Controller.ResumeDto;
import com.example.resumeService.Entity.Resume;
import com.example.resumeService.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private TmbdIntegrationService tmbdIntegrationService;

    public Resume findById(Long id) {
        return resumeRepository.findById(id).get();
    }

    public List<Resume> findAll() {
        return resumeRepository.findAll();
    }

    public  Resume saveResume (RegistrationRequest registrationRequest) {
        Resume resume = new Resume();
        resume.setName(registrationRequest.getName());
        resume.setLastname(registrationRequest.getLastname());
        resume.setBirthday(registrationRequest.getBirthday());
        resume.setExperience(registrationRequest.getExperience());
        resume.setContacts(registrationRequest.getContacts());
        resume.setAboutMe(registrationRequest.getAboutMe());

        String movieDescription = tmbdIntegrationService.getMovieDescription(registrationRequest.getMovieName());
        resume.setMovieDescription(movieDescription);
        return resumeRepository.save(resume);
    }

    public void deleteById(Long id) {
        resumeRepository.deleteById(id);
    }

    public ResponseEntity<ResumeDto> updateResume (ResumeDto resumeDto) {
        Resume existingResume = findById(resumeDto.getId());
        if(existingResume == null) {
            return  new ResponseEntity<ResumeDto>(HttpStatus.NOT_FOUND);
        }
        existingResume.setName(resumeDto.getName());
        existingResume.setLastname(resumeDto.getLastname());
        existingResume.setBirthday(resumeDto.getBirthday());
        existingResume.setExperience(resumeDto.getExperience());
        existingResume.setContacts(resumeDto.getContacts());
        existingResume.setAboutMe(resumeDto.getAboutMe());
        existingResume.setMovieDescription(resumeDto.getMovieDescription());
        resumeRepository.save(existingResume);
        return new ResponseEntity<ResumeDto>(resumeDto,HttpStatus.OK);
    }
}
