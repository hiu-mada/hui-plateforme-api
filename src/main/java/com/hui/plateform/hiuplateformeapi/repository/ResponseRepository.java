package com.hui.plateform.hiuplateformeapi.repository;

import com.hui.plateform.hiuplateformeapi.entity.Response;
import com.hui.plateform.hiuplateformeapi.entity.dto.TeamListGroupBySubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponseRepository extends JpaRepository<Response, String> {
    @Query("select r.idSubject, r.idChallengerTeam as idTeam from Response r group by r.idSubject")
    List<TeamListGroupBySubject> getTeamListGroupBySubject();
}
