package com.RestfulApi.TeacherInformationSystem.model;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "teachers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID", nullable = false, updatable = false, length = 36)
    private String id;

    @NotBlank
    @Size(min = 3, max = 50)
    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name = "Surname", nullable = false, length = 50)
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

    @Size(min = 2, max = 50)
    @Column(name = "Department", length = 50)
    private String department;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Student> students;
 
}
