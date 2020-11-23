package com.mcenterprise.tipt.data;

import com.mcenterprise.tipt.models.ShiptMate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiptMateRepository extends CrudRepository<ShiptMate, Integer> {

    ShiptMate findByUsername(String username);
}
