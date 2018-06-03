package com.trukcer.repository;

import com.trukcer.entity.Alert;
import org.springframework.data.repository.CrudRepository;

public interface AlertRespository extends CrudRepository<Alert, String> {
}
