package com.SpringBootDataJpa.SpringBootDataJpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="tbl_Student",
uniqueConstraints = @UniqueConstraint(
        name="emailid_unique",
        columnNames = "email_address"
)
)
public class Student {
    @Id
    @SequenceGenerator(
            name="Student_sequence",
            sequenceName = "Studnet_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy =GenerationType.SEQUENCE,
            generator="student_sequence"
    )
    private Long studentId;
    private String firstName;
    private  String lastName;
    @Column(name="email_address"
    ,nullable = false
    )
    private String emailId;

    @Embedded
    private  Guradian guradian;
}
