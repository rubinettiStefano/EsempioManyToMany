package com.generation.model;

import com.generation.helpers.HibernateHelper;
import jakarta.persistence.EntityManager;

import java.util.List;

public class EmployerRepository
{
	//SINGLETON
	private static EmployerRepository instance;
	public static EmployerRepository getInstance()
	{
		if(instance == null)
			instance = new EmployerRepository();
		return instance;
	}
	private EmployerRepository(){}
	//FINE SINGLETON

	private EntityManager em  = HibernateHelper.getEntityManager();

	public List<Employer> findAllEmployers()
	{
		return em.createQuery("select u from Employer u", Employer.class).getResultList();
	}

	public Employer findEmployer(int id)
	{
		return em.find(Employer.class, id);
	}

	public void insertEmployer(Employer employer)
	{
		em.getTransaction().begin();//qui iniziamo la transazione
		em.persist(employer);//persist=save
		em.getTransaction().commit();//qui committiamo, la rendiamo permanente
	}

	public void modifyEmployer(Employer employer)
	{
		em.getTransaction().begin();//qui iniziamo la transazione
		em.merge(employer);//merge=update
		em.getTransaction().commit();//qui committiamo, la rendiamo permanente
	}

	public void delete(int id)
	{

		Employer toDelete = findEmployer(id);//prima prendiamo lo employer con quell'id
		if(toDelete == null)//se non l'abbiamo trovato
			throw new RuntimeException("Employer not found");

		em.getTransaction().begin();
		em.remove(toDelete);
		em.getTransaction().commit();
	}
	//FINE METODI CRUD DI BASE


}
