package org.example.notificationservice.service;

import lombok.RequiredArgsConstructor;
import org.example.notificationservice.dto.resquest.UpdateEmployeeRequest;
import org.example.notificationservice.entity.Employee;
import org.example.notificationservice.mapper.EmployeeMapper;
import org.example.notificationservice.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public  Employee findById(String id) {
        return employeeRepository.findById(id).orElse(null);

    }

    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }

    public Employee createNewEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional
    public void deleteEmployee(String employeeId){
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        employeeRepository.delete(employee);
    }

    @Transactional
    public Employee updateEmployee(UpdateEmployeeRequest updateEmployeeRequest){
        Employee employee = employeeMapper.toEmployee(updateEmployeeRequest);
        return employeeRepository.save(employee);
    }


    public Page<Employee> listAllEmployeesAndSearch(int page, int size, String search){
        Pageable pageable= PageRequest.of(page, size);
        return employeeRepository.findAllByFirstNameLike('%'+search+'%', pageable);

    }
}
