package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/distilleries")
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepo;

    @GetMapping(value = "/region/{name}")
    public List<Distillery> findDistilleriesByRegion(@PathVariable String name) {
        return distilleryRepo.findDistilleryByRegion(name);
    }

    @GetMapping(value = "/whiskies/{age}")
    public List<Distillery> findDistilleriesWith12YearWhiskey(@PathVariable int age) {
        return distilleryRepo.getDistilleriesWith12YearWhiskeys(age);
    }


}
