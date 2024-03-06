package com.hui.plateform.hiuplateformeapi.controller;

import com.hui.plateform.hiuplateformeapi.Service.ChallengerTeamService;
import com.hui.plateform.hiuplateformeapi.entity.ChallengerTeam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
@AllArgsConstructor
public class ChallengerTeamController {
    private ChallengerTeamService challengerTeamService;

    @GetMapping("/")
    public List<ChallengerTeam> getAllTeam(){
        return challengerTeamService.getAllTeam();
    }
    @PostMapping("/")
    public ChallengerTeam createTeam(@RequestBody ChallengerTeam team){
        return challengerTeamService.createUpdateTeam(team);
    }
    @GetMapping("/{id}")
    public ChallengerTeam getTeamById(@PathVariable String id){
        return challengerTeamService.getTeamById(id);
    }
    @PutMapping("/{id}")
    public ChallengerTeam updateTeam(@PathVariable String id, @RequestBody ChallengerTeam team){
        team.setId(id);
        return challengerTeamService.createUpdateTeam(team);
    }
    @DeleteMapping("/{id}")
    public void deleteTeamById(@PathVariable String id){
        challengerTeamService.deleteTeam(id);
    }
}
