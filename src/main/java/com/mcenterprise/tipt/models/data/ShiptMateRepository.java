package com.mcenterprise.tipt.models.data;

import com.mcenterprise.tipt.models.ShiptMate;
import org.springframework.data.repository.CrudRepository;

public interface ShiptMateRepository extends CrudRepository<ShiptMate, Integer> {

    ShiptMate findByUsername(String username);

}
