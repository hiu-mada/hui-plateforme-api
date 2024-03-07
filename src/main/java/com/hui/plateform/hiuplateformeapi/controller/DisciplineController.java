package com.hui.plateform.hiuplateformeapi.controller;

import com.hui.plateform.hiuplateformeapi.Service.DisciplineService;
import com.hui.plateform.hiuplateformeapi.entity.Discipline;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplines")
@AllArgsConstructor
public class DisciplineController {
    private DisciplineService disciplineService;

    @GetMapping("/")
    public List<Discipline> getAllDisciplines(){
        return disciplineService.getAllDisciplines();
    }

    @PostMapping("/")
    public Discipline createDiscipline(@RequestBody Discipline discipline){
        return disciplineService.createUpdateDiscipline(discipline);
    }

    @GetMapping("/{id}")
    public Discipline getDisciplineById(@PathVariable String id){
        return disciplineService.getDisciplineById(id);
    }

    @PutMapping("/{id}")
    public Discipline updateDiscipline(@PathVariable String id, @RequestBody Discipline discipline){
        discipline.setId(id);
        return disciplineService.createUpdateDiscipline(discipline);
    }

    @DeleteMapping("/{id}")
    public void deleteDisciplineById(@PathVariable String id){
        disciplineService.deleteDiscipline(id);
    }
}
