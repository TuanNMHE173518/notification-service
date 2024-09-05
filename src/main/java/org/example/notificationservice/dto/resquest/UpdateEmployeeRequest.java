package org.example.notificationservice.dto.resquest;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateEmployeeRequest {
    String id;
    String firstName;
    String lastName;
    String email;
}
