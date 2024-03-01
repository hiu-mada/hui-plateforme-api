package com.hui.plateform.hiuplateformeapi.Service;

import com.hui.plateform.hiuplateformeapi.entity.university_table;
import com.hui.plateform.hiuplateformeapi.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService {
    @Autowired
    private UniversityRepository universityRepository;

    public List<university_table> getAllUniversity(){
        return universityRepository.findAll();
    }
    public university_table getById(String id){
        return  universityRepository.findById(id).orElse(null);
    }

    public university_table createUniversity(university_table university){
        return universityRepository.save(university);
    }

    public university_table updateUniversity(university_table university){
        return  universityRepository.save(university);
    }

    public void  deleteUniversityById(String id){
        universityRepository.deleteById(id);
    }

}
