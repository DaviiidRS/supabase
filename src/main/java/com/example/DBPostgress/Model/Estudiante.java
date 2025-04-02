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
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    private String nombre;
    private String telefono;
    @ManyToMany
    @JoinTable(
            name="inscripciones",
            joinColumns = @JoinColumn(name="codigo"),
            inverseJoinColumns = @JoinColumn(name = "id_curso")
    )
    private List<Curso> cursos;

    @OneToOne(mappedBy = "monitor")
    private Curso curso;
}