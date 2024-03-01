package com.hui.plateform.hiuplateformeapi.Service;

import com.hui.plateform.hiuplateformeapi.entity.discipline_table;
import com.hui.plateform.hiuplateformeapi.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplineService {
    @Autowired
    private DisciplineRepository disciplineRepository;

    public List<discipline_table> getAllDisciplines(){
        return disciplineRepository.findAll();
    }
    public discipline_table getDisciplineById(String id){
        return disciplineRepository.findById(id).orElse(null);
    }
    public discipline_table createDiscipline(discipline_table discipline){
        return disciplineRepository.save(discipline);
    }
    public discipline_table updateDiscipline(discipline_table discipline){
        return disciplineRepository.save(discipline);
    }
    public void deleteDiscipline(String id){
        disciplineRepository.deleteById(id);
    }
}
