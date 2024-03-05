package com.hui.plateform.hiuplateformeapi.controller;

import com.hui.plateform.hiuplateformeapi.Service.VoteService;
import com.hui.plateform.hiuplateformeapi.entity.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vote")
public class VoteController {
    @Autowired
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
}
