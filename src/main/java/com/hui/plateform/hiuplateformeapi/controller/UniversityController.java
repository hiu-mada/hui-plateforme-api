package com.hui.plateform.hiuplateformeapi.controller;

import com.hui.plateform.hiuplateformeapi.Service.UniversityService;
import com.hui.plateform.hiuplateformeapi.entity.university_table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityController {
    @Autowired
    UniversityService universityService;

    @GetMapping("/")
    public List<university_table>getAllUniversity(){
        return universityService.getAllUniversity();
    }
    @GetMapping("/{id}")
    public university_table getUniversityById(@PathVariable String id){
        return universityService.getById(id);
    }
    @PostMapping("/")
    public university_table createUniversity(@RequestBody university_table university){
        return universityService.createUniversity(university);
    }

    @PutMapping("/{id}")
    public university_table updateUniversity(@PathVariable String id, @RequestBody university_table university){
        university.setId(id);
        return  universityService.updateUniversity(university);
    }

    @DeleteMapping("/{id}")
    public void deleUniversityByid(@PathVariable String id){
        universityService.deleteUniversityById(id);
    }
}
