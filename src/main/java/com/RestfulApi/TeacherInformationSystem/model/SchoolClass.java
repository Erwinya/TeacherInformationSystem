package com.RestfulApi.TeacherInformationSystem.model;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "classes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID", nullable = false, updatable = false, length = 36)
    private String id;

    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @ManyToOne
    @Column(name = "TeacherId", nullable = false)
    private String teacherId;

    private List<Student> students;
}
