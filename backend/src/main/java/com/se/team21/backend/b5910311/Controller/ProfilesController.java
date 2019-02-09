package com.se.team21.backend.b5910311.controller;
import com.se.team21.backend.b5910311.entity.*;
import com.se.team21.backend.b5910311.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProfilesController {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/profile")
    public List<Profile> showAllProfile() {
        return profileRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/profile/{pid}")
    public Profile ShowProfile(@PathVariable Long pid) {
        Optional<Profile> profile = profileRepository.findById(pid);
        return profile.get();
    }

    @PostMapping(path = "/profile/{firstname}/{lastname}/{addressname}")
    public Profile profile(@PathVariable String firstname,@PathVariable String lastname, @PathVariable Long addressname){

        Profile profile = new Profile();
        profile.setFirstName(firstname);
        profile.setLastName(lastname);
        profile.setAddressname(addressRepository.getOne(addressname));
        return profileRepository.save(profile);

    }
    
    @PutMapping(path = "/profile/update/{pid}/{firstname}/{lastname}/{addressname}")
    public Profile updateprofile(@RequestBody Profile updateprofile,@PathVariable Long pid,@PathVariable String firstname,@PathVariable String lastname, @PathVariable Long addressname){
        Profile updatep = profileRepository.getOne(pid);
        updatep.setFirstName(firstname);
        updatep.setLastName(lastname);
        Address add = addressRepository.getOne(addressname);
        updatep.setAddressname(add);
        return profileRepository.save(updatep);
    }



}