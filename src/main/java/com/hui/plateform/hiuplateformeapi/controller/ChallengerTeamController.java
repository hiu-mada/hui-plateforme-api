package com.hui.plateform.hiuplateformeapi.controller;

import com.hui.plateform.hiuplateformeapi.Service.ChallengerTeamService;
import com.hui.plateform.hiuplateformeapi.entity.ChallengerTeam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class ChallengerTeamController {
    private ChallengerTeamService challengerTeamService;

    @GetMapping("/team")
    public List<ChallengerTeam> getAllTeam(){
        return challengerTeamService.getAllTeam();
    }
    @PostMapping("/team")
    public ChallengerTeam createTeam(@RequestBody ChallengerTeam team){
        return challengerTeamService.createUpdateTeam(team);
    }
    @GetMapping("/team/{id}")
    public ChallengerTeam getTeamById(@PathVariable String id){
        return challengerTeamService.getTeamById(id);
    }
    @PutMapping("/team/{id}")
    public ChallengerTeam updateTeam(@PathVariable String id, @RequestBody ChallengerTeam team){
        team.setId(id);
        return challengerTeamService.createUpdateTeam(team);
    }
    @DeleteMapping("/team/{id}")
    public void deleteTeamById(@PathVariable String id){
        challengerTeamService.deleteTeam(id);
    }
}
