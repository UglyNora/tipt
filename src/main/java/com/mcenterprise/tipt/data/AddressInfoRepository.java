package com.mcenterprise.tipt.data;

import com.mcenterprise.tipt.models.AddressInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressInfoRepository extends CrudRepository<AddressInfo, Integer> {
}
