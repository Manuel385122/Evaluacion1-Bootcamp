package com.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.Curso;
import com.respositories.CursoRepository;



@Service
public class CursoService implements BaseService<Curso> {

	CursoRepository cursoRepository;

	public CursoService(CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}

	@Override
	@Transactional
	public List<Curso> findAll() throws Exception {
		try {

			List<Curso> entities = cursoRepository.findAll();
			return entities;

		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Curso findById(Long id) throws Exception {
		try {

			Optional<Curso> entityOptional = cursoRepository.findById(id);
			// System.out.println(entityOptional.get());
			return entityOptional.get();
		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Curso save(Curso entity) throws Exception {
		try {

			entity = cursoRepository.save(entity);
			return entity;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Curso update(Long id, Curso entity) throws Exception {
		try {

			Optional<Curso> entityOptional = cursoRepository.findById(id);

			Curso curso = entityOptional.get();
			curso = cursoRepository.save(entity);
			return curso;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public boolean delete(Long id) throws Exception {
		try {

			if (cursoRepository.existsById(id)) {
				cursoRepository.deleteById(id);
				return true;
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}