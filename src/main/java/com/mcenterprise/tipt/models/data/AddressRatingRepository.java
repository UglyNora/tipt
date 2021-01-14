package com.mcenterprise.tipt.models.data;

import com.mcenterprise.tipt.models.AddressRating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRatingRepository extends CrudRepository<AddressRating, Integer> {
}
