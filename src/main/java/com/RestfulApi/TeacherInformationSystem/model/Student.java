package com.RestfulApi.TeacherInformationSystem.model;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID", nullable = false, updatable = false, length = 36)
    private String id;

    @NotBlank
    @Size(min = 1, max = 20)
    @Column(name = "StudentNumber", nullable = false, length = 20, unique = true)
    @Pattern(regexp = "^[0-9]{8}$", message = "Student Number must be exactly 8 digits")
    private String studentNumber;

    @NotBlank
    @Size(min = 3, max = 50)
    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name = "Surname", nullable = false, length = 50)
    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Surname must contain only letters and spaces")
    private String surname;

    @NotBlank
    @Email
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.com$", 
             message = "Email must be a valid email address ending with .com")
    @Column(name = "Email", unique = true, nullable = false, length = 100)
    private String email;

    @Column(name = "PhoneNumber", length = 15)
    @Pattern(regexp = "^[0-9\\-+]{7,15}$", message = "Phone Number invalid")
    private String phoneNumber;

    @ManyToMany(mappedBy = "students")
    private List<SchoolClass> enrolledClasses;
}
