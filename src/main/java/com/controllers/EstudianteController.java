package com.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Estudiante;
import com.services.EstudianteService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/evaluacion/estudiante")
public class EstudianteController {

	private EstudianteService estudianteService;

	public EstudianteController(EstudianteService estudianteService) {

		this.estudianteService = estudianteService;

	}

	@GetMapping("")
	public ResponseEntity<?> getAll() {
		try {

			return ResponseEntity.status(HttpStatus.OK).body(estudianteService.findAll());

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable Long id) {
		try {
			System.out.println("id:" + id);
			return ResponseEntity.status(HttpStatus.OK).body(estudianteService.findById(id));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}
	}

	@PostMapping("")
	public ResponseEntity<?> save(@RequestBody Estudiante entity) {
		try {

			System.out.println(entity.toString());

			return ResponseEntity.status(HttpStatus.OK).body(estudianteService.save(entity));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Estudiante entity) {
		try {

			return ResponseEntity.status(HttpStatus.OK).body(estudianteService.update(id, entity));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {

			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(estudianteService.delete(id));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}
	}

}
