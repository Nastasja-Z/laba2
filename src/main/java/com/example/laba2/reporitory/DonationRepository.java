package com.example.laba2.reporitory;

import com.example.laba2.entity.Donation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface DonationRepository extends CrudRepository<Donation, Integer> {

    Set<Donation> findAll();

}
