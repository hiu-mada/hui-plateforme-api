package com.hui.plateform.hiuplateformeapi.Service;

import com.hui.plateform.hiuplateformeapi.entity.Subject;
import com.hui.plateform.hiuplateformeapi.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubject(){
        return subjectRepository.findAll();
    }

    public Subject getSubjectById(String id){
        return  subjectRepository.findById(id).orElse(null);
    }

    public Subject createUpdateSubject(Subject subject){
        return subjectRepository.save(subject);
    }
    public void deleteSubjectById(String id){
        subjectRepository.deleteById(id);
    }
}
