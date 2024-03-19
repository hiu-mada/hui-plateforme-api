package com.hui.plateform.hiuplateformeapi.controller;

import com.hui.plateform.hiuplateformeapi.Service.SubjectService;
import com.hui.plateform.hiuplateformeapi.entity.Subject;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class SubjectController {
    private SubjectService subjectService;

    @GetMapping("/subject")
    public List<Subject> getAllSubject(){
        return subjectService.getAllSubject();
    }

    @GetMapping("/subject/{id}")
    public Subject getSubjectById(@PathVariable String id){
        return  subjectService.getSubjectById(id);
    }

    @PostMapping("/subject/")
    public Subject createSubject(@RequestBody Subject subject){
        return subjectService.createUpdateSubject(subject);
    }

    @PutMapping("/subject/{id}")
    public Subject updateSubject(@PathVariable String id, @RequestBody Subject subject){
        subject.setId(id);
        return  subjectService.createUpdateSubject(subject);
    }

    @DeleteMapping("subject/{id}")
    public void deleSubjectByid(@PathVariable String id){
        subjectService.deleteSubjectById(id);
    }
}
