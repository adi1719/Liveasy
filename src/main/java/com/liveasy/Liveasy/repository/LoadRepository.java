package com.liveasy.Liveasy.repository;

import com.liveasy.Liveasy.model.Load;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface LoadRepository extends MongoRepository<Load, String> {
    List<Load> findByShipperId(String shipperId);

    Optional<Load> findById(String loadId);
}
