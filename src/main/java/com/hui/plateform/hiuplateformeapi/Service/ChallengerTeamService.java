package com.hui.plateform.hiuplateformeapi.Service;

import com.hui.plateform.hiuplateformeapi.entity.ChallengerTeam;
import com.hui.plateform.hiuplateformeapi.repository.ChallengerTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengerTeamService {
    @Autowired
    private ChallengerTeamRepository challengerTeamRepository;

    public List<ChallengerTeam> getAllTeam(){
        return challengerTeamRepository.findAll();
    }
    public ChallengerTeam getTeamById(String id){
        return challengerTeamRepository.findById(id).orElse(null);
    }
    public ChallengerTeam createUpdateTeam(ChallengerTeam team){
        return challengerTeamRepository.save(team);
    }
    public void deleteTeam(String id){
        challengerTeamRepository.deleteById(id);
    }
}
