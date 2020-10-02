package com.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.Estudiante;
import com.respositories.EstudianteRepository;

@Service
public class EstudianteService implements BaseService<Estudiante> {

	// @Autowired
	private EstudianteRepository estudianteRepository;

	public EstudianteService(EstudianteRepository estudianteRepository) {
		this.estudianteRepository = estudianteRepository;
	}

	@Override
	@Transactional
	public List<Estudiante> findAll() throws Exception {
		try {

			List<Estudiante> entities = estudianteRepository.findAll();
			return entities;

		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Estudiante findById(Long id) throws Exception {
		try {

			Optional<Estudiante> entityOptional = estudianteRepository.findById(id);
			// System.out.println(entityOptional.get());
			return entityOptional.get();
		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Estudiante save(Estudiante entity) throws Exception {
		try {

			entity = estudianteRepository.save(entity);
			return entity;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Estudiante update(Long id, Estudiante entity) throws Exception {
		try {

			Optional<Estudiante> entityOptional = estudianteRepository.findById(id);

			Estudiante estudiante = entityOptional.get();
			estudiante = estudianteRepository.save(entity);
			return estudiante;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public boolean delete(Long id) throws Exception {
		try {

			if (estudianteRepository.existsById(id)) {
				estudianteRepository.deleteById(id);
				return true;
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
