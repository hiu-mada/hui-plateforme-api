package com.hui.plateform.hiuplateformeapi.controller;

import com.hui.plateform.hiuplateformeapi.Service.DisciplineService;
import com.hui.plateform.hiuplateformeapi.entity.discipline_table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplines")
public class DisciplineController {
    @Autowired
    private DisciplineService disciplineService;

    @GetMapping("/")
    public List<discipline_table> getAllDisciplines(){
        return disciplineService.getAllDisciplines();
    }

    @PostMapping("/")
    public discipline_table createDiscipline(@RequestBody discipline_table discipline){
        return disciplineService.createDiscipline(discipline);
    }

    @GetMapping("/{id}")
    public discipline_table getDisciplineById(@PathVariable String id){
        return disciplineService.getDisciplineById(id);
    }

    @PutMapping("/{id}")
    public discipline_table updateDiscipline(@PathVariable String id, @RequestBody discipline_table discipline){
        discipline.setId(id);
        return disciplineService.updateDiscipline(discipline);
    }

    @DeleteMapping("/{id}")
    public void deleteDisciplineById(@PathVariable String id){
        disciplineService.deleteDiscipline(id);
    }
}
