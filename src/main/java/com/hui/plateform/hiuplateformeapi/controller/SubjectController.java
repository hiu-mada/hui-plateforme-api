package com.hui.plateform.hiuplateformeapi.controller;

import com.hui.plateform.hiuplateformeapi.Service.SubjectService;
import com.hui.plateform.hiuplateformeapi.entity.subject_table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/")
    public List<subject_table> getAllSubject(){
        return subjectService.getAllSubject();
    }

    @GetMapping("/{id}")
    public subject_table getSubjectById(@PathVariable String id){
        return  subjectService.getSubjectById(id);
    }

    @PostMapping("/")
    public subject_table createSubject(@RequestBody subject_table subject){
        return subjectService.createSubject(subject);
    }

    @PutMapping("/{id}")
    public subject_table updateSubject(@PathVariable String id, @RequestBody subject_table subject){
        subject.setId(id);
        return  subjectService.updateSubject(subject);
    }

    @DeleteMapping("/{id}")
    public void deleSubjectByid(@PathVariable String id){
        subjectService.deleteSubjectById(id);
    }
}
