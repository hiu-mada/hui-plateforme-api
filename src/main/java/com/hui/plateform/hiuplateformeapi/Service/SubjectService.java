package com.hui.plateform.hiuplateformeapi.Service;

import com.hui.plateform.hiuplateformeapi.entity.subject_table;
import com.hui.plateform.hiuplateformeapi.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public List<subject_table> getAllSubject(){
        return subjectRepository.findAll();
    }

    public subject_table getSubjectById(String id){
        return  subjectRepository.findById(id).orElse(null);
    }

    public subject_table createSubject(subject_table subject){
        return subjectRepository.save(subject);
    }

    public subject_table updateSubject(subject_table subject){
        return subjectRepository.save(subject);
    }

    public void deleteSubjectById(String id){
        subjectRepository.deleteById(id);
    }
}
