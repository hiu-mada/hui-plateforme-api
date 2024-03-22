package com.hui.plateform.hiuplateformeapi.controller;

import com.hui.plateform.hiuplateformeapi.Service.VoteService;
import com.hui.plateform.hiuplateformeapi.entity.Vote;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class VoteController {
    private VoteService voteService;

    @GetMapping("/vote")
    public List<Vote> getAllVote(){
        return voteService.getAllVote();
    }
    @PostMapping("/vote")
    public Vote createVote(@RequestBody Vote vote){
        return voteService.createVote(vote);
    }
    @GetMapping("/vote/{id}")
    public Vote getVoteById(@PathVariable String id){
        return voteService.getVoteById(id);
    }
    @DeleteMapping("/vote/{id}")
    public void  deleteVoteById(@PathVariable String id){
        voteService.deleteVoteById(id);
    }
    @GetMapping("/vote/count-by-team")
    public List<Object[]> countVotesByIdTeam() {
        return voteService.getVotePerTeam();
    }
    @GetMapping("/vote/count-by-team/{id}")
    public int countVoteOfTeam(@PathVariable String id){
        return voteService.getVoteOfTeam(id);
    }
}
