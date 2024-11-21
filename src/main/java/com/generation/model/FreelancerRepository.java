package com.generation.model;

import com.generation.helpers.HibernateHelper;
import jakarta.persistence.EntityManager;

import java.util.List;

public class FreelancerRepository
{
	//SINGLETON
	private static FreelancerRepository instance;
	public static FreelancerRepository getInstance()
	{
		if(instance == null)
			instance = new FreelancerRepository();
		return instance;
	}
	private FreelancerRepository(){}
	//FINE SINGLETON

	private EntityManager em  = HibernateHelper.getEntityManager();

	public List<Freelancer> findAllFreelancers()
	{
		return em.createQuery("select u from Freelancer u", Freelancer.class).getResultList();
	}

	public Freelancer findFreelancer(int id)
	{
		return em.find(Freelancer.class, id);
	}

	public void insertFreelancer(Freelancer freelancer)
	{
		em.getTransaction().begin();//qui iniziamo la transazione
		em.persist(freelancer);//persist=save
		em.getTransaction().commit();//qui committiamo, la rendiamo permanente
	}

	public void modifyFreelancer(Freelancer freelancer)
	{
		em.getTransaction().begin();//qui iniziamo la transazione
		em.merge(freelancer);//merge=update
		em.getTransaction().commit();//qui committiamo, la rendiamo permanente
	}

	public void delete(int id)
	{

		Freelancer toDelete = findFreelancer(id);//prima prendiamo lo freelancer con quell'id
		if(toDelete == null)//se non l'abbiamo trovato
			throw new RuntimeException("Freelancer not found");

		em.getTransaction().begin();
		em.remove(toDelete);
		em.getTransaction().commit();
	}
	//FINE METODI CRUD DI BASE


}
