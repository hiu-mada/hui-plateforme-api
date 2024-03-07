package com.hui.plateform.hiuplateformeapi.repository;

import com.hui.plateform.hiuplateformeapi.entity.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, String> {
}
