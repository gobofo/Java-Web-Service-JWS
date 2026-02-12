package fr.epita.assistants.data.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "course_model")
public class CourseModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column
    String name;

    @ElementCollection
    @CollectionTable(name = "course_model_tags", joinColumns = @JoinColumn(name="course_id"))
    List<String> tag;

    @OneToMany
    @JoinColumn(name = "id_course")
    List<StudentModel> course_id;

}
