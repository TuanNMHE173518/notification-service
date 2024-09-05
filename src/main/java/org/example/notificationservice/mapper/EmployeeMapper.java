package org.example.notificationservice.mapper;

import org.example.notificationservice.dto.resquest.UpdateEmployeeRequest;
import org.example.notificationservice.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee toEmployee(UpdateEmployeeRequest updateEmployeeRequest);

}
