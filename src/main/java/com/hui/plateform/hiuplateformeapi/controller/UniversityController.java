package com.hui.plateform.hiuplateformeapi.controller;

import com.hui.plateform.hiuplateformeapi.Service.UniversityService;
import com.hui.plateform.hiuplateformeapi.entity.University;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UniversityController {
    private UniversityService universityService;

    @GetMapping("/university")
    public List<University> getAllUniversity(){
        return universityService.getAllUniversity();
    }
    @GetMapping("/university/{id}")
    public University getUniversityById(@PathVariable String id){
        return universityService.getUniversityById(id);
    }
    @PostMapping("/university")
    public University createUniversity(@RequestBody University university){
        return universityService.createUpdateUniversity(university);
    }

    @PutMapping("/university/{id}")
    public University updateUniversity(@PathVariable String id, @RequestBody University university){
        university.setId(id);
        return  universityService.createUpdateUniversity(university);
    }

    @DeleteMapping("/university/{id}")
    public void deleUniversityByid(@PathVariable String id){
        universityService.deleteUniversityById(id);
    }
}
