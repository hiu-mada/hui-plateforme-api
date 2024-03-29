package com.hui.plateform.hiuplateformeapi.Service;

import com.hui.plateform.hiuplateformeapi.entity.Discipline;
import com.hui.plateform.hiuplateformeapi.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplineService {
    @Autowired
    private DisciplineRepository disciplineRepository;

    public List<Discipline> getAllDisciplines(){
        return disciplineRepository.findAll();
    }
    public Discipline getDisciplineById(String id){
        return disciplineRepository.findById(id).orElse(null);
    }
    public Discipline createUpdateDiscipline(Discipline discipline){
        return disciplineRepository.save(discipline);
    }
    public void deleteDiscipline(String id){
        disciplineRepository.deleteById(id);
    }
}
