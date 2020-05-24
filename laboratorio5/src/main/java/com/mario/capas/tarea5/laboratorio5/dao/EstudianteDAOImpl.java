package com.mario.capas.tarea5.laboratorio5.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mario.capas.tarea5.laboratorio5.domain.Estudiante;

@Repository
public class EstudianteDAOImpl implements EstudianteDAO {

	@PersistenceContext(unitName = "capas")
	private EntityManager entityManager;

	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.estudiante");
		Query query = entityManager.createNativeQuery(sb.toString(), Estudiante.class);
		List<Estudiante> resultset = query.getResultList();

		return resultset;
	}

	@Override
	public Estudiante findOne(Integer code) throws DataAccessException {
		Estudiante estudiante = entityManager.find(Estudiante.class, code);

		return estudiante;
	}

	@Transactional
	public void save(Estudiante e) throws DataAccessException {

		if (e.getCusuario() == null) { // Si la propiedad de la llave primaria viene vacío, entonces es un INSERT
			entityManager.persist(e); // Utilizamos persist ya que es un INSERT
		} else { // Caso contrario, se busco al cliente, por lo que la propiedad ccliente viene
					// llena (el input hidden del formulario)
			entityManager.merge(e); // Utilizamos merge ya que es un UPDATE
		}

	}

	@Transactional
	public void delete(Integer code) throws DataAccessException {
		Estudiante estudiante = findOne(code);
		entityManager.remove(estudiante);
	}

}
