package org.example.notificationservice.repository;

import org.example.notificationservice.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    Page<Employee> findAllByFirstNameLike(String search,Pageable pageable);
}
