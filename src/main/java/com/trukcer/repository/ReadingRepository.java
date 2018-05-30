package com.trukcer.repository;

import com.trukcer.entity.Readings;
import org.springframework.data.repository.CrudRepository;

public interface ReadingRepository extends CrudRepository<Readings, String> {
}
