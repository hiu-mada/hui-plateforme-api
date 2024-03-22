package com.hui.plateform.hiuplateformeapi.controller;

import com.hui.plateform.hiuplateformeapi.Service.DisciplineService;
import com.hui.plateform.hiuplateformeapi.entity.Discipline;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class DisciplineController {
    private DisciplineService disciplineService;

    @GetMapping("/disciplines")
    public List<Discipline> getAllDisciplines(){
        return disciplineService.getAllDisciplines();
    }

    @PostMapping("/disciplines")
    public Discipline createDiscipline(@RequestBody Discipline discipline){
        return disciplineService.createUpdateDiscipline(discipline);
    }

    @GetMapping("/disciplines/{id}")
    public Discipline getDisciplineById(@PathVariable String id){
        return disciplineService.getDisciplineById(id);
    }

    @PutMapping("/disciplines/{id}")
    public Discipline updateDiscipline(@PathVariable String id, @RequestBody Discipline discipline){
        discipline.setId(id);
        return disciplineService.createUpdateDiscipline(discipline);
    }

    @DeleteMapping("/disciplines/{id}")
    public void deleteDisciplineById(@PathVariable String id){
        disciplineService.deleteDiscipline(id);
    }
}
