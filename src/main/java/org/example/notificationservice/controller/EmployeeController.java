package org.example.notificationservice.controller;


import lombok.RequiredArgsConstructor;
import org.example.notificationservice.dto.response.ApiResponse;
import org.example.notificationservice.dto.resquest.UpdateEmployeeRequest;
import org.example.notificationservice.entity.Employee;
import org.example.notificationservice.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public ApiResponse<Page<Employee>> getEmployees(@RequestParam(value = "page", defaultValue = "0")int page,
                                                    @RequestParam(value = "size", defaultValue = "10")int size,
                                                    @RequestParam(value = "search", defaultValue = "")String search) {


        Page<Employee> employees = employeeService.listAllEmployeesAndSearch(page, size, search);
        return ApiResponse.<Page<Employee>>builder()
                .data(employees)
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<Employee> getEmployeeById(@PathVariable String id){

        Employee employee = employeeService.findById(id);
        return ApiResponse.<Employee>builder()
                .data(employee)
                .build();
    }


    @PostMapping("/create")
    public ApiResponse<Employee> createEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.createNewEmployee(employee);
        return ApiResponse.<Employee>builder()
                .data(newEmployee)
                .message("Create successfully")
                .build();


    }

    @PutMapping("/update")
    public ApiResponse<Employee> updateEmployee(@RequestBody UpdateEmployeeRequest updateEmployeeRequest){

        Employee employee = employeeService.updateEmployee(updateEmployeeRequest);
        return ApiResponse.<Employee>builder()
                .data(employee)
                .message("Update Successfully")
                .build();
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<String> deleteEmployee(@PathVariable()String id){
        employeeService.deleteEmployee(id);
        return ApiResponse.<String>builder()
                .data("Delete Successfully")
                .build();
    }
}
