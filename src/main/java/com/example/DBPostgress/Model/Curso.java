package com.example.DBPostgress.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_curso;

    private String nombre;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name="id")
    private Profesor profesor;

    @ManyToMany(mappedBy = "cursos")
    private List<Estudiante> estudiantes;

    @OneToOne
    @JoinColumn(name = "codigo")
    private Estudiante monitor;
}
