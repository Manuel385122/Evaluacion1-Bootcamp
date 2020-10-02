package com.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
	



}
