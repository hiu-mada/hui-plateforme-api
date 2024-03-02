package com.hui.plateform.hiuplateformeapi.controller;

import com.hui.plateform.hiuplateformeapi.Service.UniversityService;
import com.hui.plateform.hiuplateformeapi.entity.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityController {
    @Autowired
    UniversityService universityService;

    @GetMapping("/")
    public List<University>getAllUniversity(){
        return universityService.getAllUniversity();
    }
    @GetMapping("/{id}")
    public University getUniversityById(@PathVariable String id){
        return universityService.getById(id);
    }
    @PostMapping("/")
    public University createUniversity(@RequestBody University university){
        return universityService.createUpdateUniversity(university);
    }

    @PutMapping("/{id}")
    public University updateUniversity(@PathVariable String id, @RequestBody University university){
        university.setId(id);
        return  universityService.createUpdateUniversity(university);
    }

    @DeleteMapping("/{id}")
    public void deleUniversityByid(@PathVariable String id){
        universityService.deleteUniversityById(id);
    }
}
