package com.example.profile.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.profile.exception.ResourceNotFound;
import com.example.profile.model.Profile;

import com.example.profile.repository.ProfileRepository;

@CrossOrigin("*")
@ResponseBody
@RestController
@RequestMapping("/api/v1/profile")
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping
    public List<Profile> getAllProfile(){
        return profileRepository.findAll();
    }

    @PostMapping
    public Profile createProfile(@RequestBody Profile profile){
    return profileRepository.save(profile);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable long id){
        Profile profile = profileRepository.findById(id).
        orElseThrow(()-> new ResourceNotFound("Profile not exist with id:" + id));
        return ResponseEntity.ok(profile);
    }

    @PutMapping("{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable long id, @RequestBody Profile profileDetails){
        Profile updatProfile = profileRepository.findById(id).
        orElseThrow(()-> new ResourceNotFound("Profile not exist with id:" + id));

        updatProfile.setUserName(profileDetails.getUserName());
        updatProfile.setEmail(profileDetails.getEmail());
        updatProfile.setPass(profileDetails.getPass());

        profileRepository.save(updatProfile);
        return ResponseEntity.ok(updatProfile);
    }
}
