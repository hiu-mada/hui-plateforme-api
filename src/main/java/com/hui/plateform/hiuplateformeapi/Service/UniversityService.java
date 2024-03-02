package com.hui.plateform.hiuplateformeapi.Service;

import com.hui.plateform.hiuplateformeapi.entity.University;
import com.hui.plateform.hiuplateformeapi.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService {
    @Autowired
    private UniversityRepository universityRepository;

    public List<University> getAllUniversity(){
        return universityRepository.findAll();
    }
    public University getById(String id){
        return  universityRepository.findById(id).orElse(null);
    }

    public University createUpdateUniversity(University university){
        return universityRepository.save(university);
    }

    public void  deleteUniversityById(String id){
        universityRepository.deleteById(id);
    }

}
