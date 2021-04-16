package com.example.laba2.reporitory;

import com.example.laba2.entity.Needy;
import com.example.laba2.entity.Option;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;

public interface NeedyRepository extends CrudRepository<Needy, Integer> {
    Set<Needy> findAll();

    Optional<Needy> findByNameOfNeedy(@Param("nameOfNeedy") String nameOfNeedy);

}
