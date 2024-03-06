package com.hui.plateform.hiuplateformeapi.repository;

import com.hui.plateform.hiuplateformeapi.entity.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepository extends JpaRepository<Response, String> {
}
