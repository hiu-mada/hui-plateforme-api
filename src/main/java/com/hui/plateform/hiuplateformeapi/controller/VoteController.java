package com.hui.plateform.hiuplateformeapi.controller;

import com.hui.plateform.hiuplateformeapi.Service.VoteService;
import com.hui.plateform.hiuplateformeapi.entity.Vote;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vote")
@AllArgsConstructor
public class VoteController {
    private VoteService voteService;

    @GetMapping("/")
    public List<Vote> getAllVote(){
        return voteService.getAllVote();
    }
    @PostMapping("/")
    public Vote createVote(@RequestBody Vote vote){
        return voteService.createVote(vote);
    }
    @GetMapping("/{id}")
    public Vote getVoteById(@PathVariable String id){
        return voteService.getVoteById(id);
    }
    @DeleteMapping("/{id}")
    public void  deleteVoteById(@PathVariable String id){
        voteService.deleteVoteById(id);
    }
    @GetMapping("/count-by-team")
    public List<Object[]> countVotesByIdTeam() {
        return voteService.getVotePerTeam();
    }
    @GetMapping("/count-by-team/{id}")
    public int countVoteOfTeam(@PathVariable String id){
        return voteService.getVoteOfTeam(id);
    }
}
