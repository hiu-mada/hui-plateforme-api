package com.hui.plateform.hiuplateformeapi.repository;

import com.hui.plateform.hiuplateformeapi.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, String> {
    @Query("SELECT v.idChallenger, COUNT(v) as voteCount FROM Vote v GROUP BY v.idChallenger")
    List<Object[]> countVotesByIdChallenger();

    @Query("SELECT COUNT(v) FROM Vote v WHERE v.idChallenger = :idChallenger")
    int countVotesByIdChallenger(String idChallenger);
}
