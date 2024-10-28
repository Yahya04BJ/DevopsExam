package com.ensa.gestionEmployee.repository;

import com.ensa.gestionEmployee.model.Employ;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployRepository extends JpaRepository<Employ, Long> {
}
