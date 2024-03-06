package com.hui.plateform.hiuplateformeapi.Service;

import com.hui.plateform.hiuplateformeapi.entity.ChallengerTeam;
import com.hui.plateform.hiuplateformeapi.entity.Vote;
import com.hui.plateform.hiuplateformeapi.repository.VoteRepository;
import lombok.AllArgsConstructor;
import org.hibernate.mapping.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VoteService {
    private VoteRepository voteRepository;

    public List<Vote> getAllVote(){
        return voteRepository.findAll();
    }
    public Vote getVoteById(String id){
        return voteRepository.findById(id).orElse(null);
    }
    public Vote createVote(Vote vote){
        return voteRepository.save(vote);
    }
    public void deleteVoteById(String id){
        voteRepository.deleteById(id);
    }
    public List<Object[]> getVotePerTeam(){
        return voteRepository.countVotesByIdChallenger();
    }
    public int getVoteOfTeam(String id){
        return voteRepository.countVotesByIdChallenger(id);
    }
}
