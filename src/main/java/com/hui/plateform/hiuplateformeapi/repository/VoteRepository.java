package com.hui.plateform.hiuplateformeapi.repository;

import com.hui.plateform.hiuplateformeapi.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, String> {
}
