package com.trukcer.repository;

import com.trukcer.entity.Readings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingRepository extends CrudRepository<Readings, String> {
}
