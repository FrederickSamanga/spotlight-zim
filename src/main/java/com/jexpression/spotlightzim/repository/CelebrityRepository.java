package com.jexpression.spotlightzim.repository;

import com.jexpression.spotlightzim.model.Celebrity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CelebrityRepository extends JpaRepository<Celebrity, Long> {

    void deleteByName(String celebrityName);

    Optional<Celebrity> findByName(String name);

}
