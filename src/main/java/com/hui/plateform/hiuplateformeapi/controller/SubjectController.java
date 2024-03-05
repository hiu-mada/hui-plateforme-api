package com.hui.plateform.hiuplateformeapi.controller;

import com.hui.plateform.hiuplateformeapi.Service.SubjectService;
import com.hui.plateform.hiuplateformeapi.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/")
    public List<Subject> getAllSubject(){
        return subjectService.getAllSubject();
    }

    @GetMapping("/{id}")
    public Subject getSubjectById(@PathVariable String id){
        return  subjectService.getSubjectById(id);
    }

    @PostMapping("/")
    public Subject createSubject(@RequestBody Subject subject){
        return subjectService.createUpdateSubject(subject);
    }

    @PutMapping("/{id}")
    public Subject updateSubject(@PathVariable String id, @RequestBody Subject subject){
        subject.setId(id);
        return  subjectService.createUpdateSubject(subject);
    }

    @DeleteMapping("/{id}")
    public void deleSubjectByid(@PathVariable String id){
        subjectService.deleteSubjectById(id);
    }
}
