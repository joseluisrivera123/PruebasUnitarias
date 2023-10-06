package com.example.MsAttorney.repository;

import com.example.MsAttorney.domain.model.Attorney;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttorneyRepository extends ReactiveCrudRepository<Attorney,Integer> {
}
