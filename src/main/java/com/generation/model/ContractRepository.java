package com.generation.model;

import com.generation.helpers.HibernateHelper;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ContractRepository
{
	//SINGLETON
	private static ContractRepository instance;
	public static ContractRepository getInstance()
	{
		if(instance == null)
			instance = new ContractRepository();
		return instance;
	}
	private ContractRepository(){}
	//FINE SINGLETON

	private EntityManager em  = HibernateHelper.getEntityManager();

	public List<Contract> findAllContracts()
	{
		return em.createQuery("select u from Contract u", Contract.class).getResultList();
	}

	public Contract findContract(int id)
	{
		return em.find(Contract.class, id);
	}

	public void insertContract(Contract contract)
	{
		em.getTransaction().begin();//qui iniziamo la transazione
		em.persist(contract);//persist=save
		em.getTransaction().commit();//qui committiamo, la rendiamo permanente
	}

	public void modifyContract(Contract contract)
	{
		em.getTransaction().begin();//qui iniziamo la transazione
		em.merge(contract);//merge=update
		em.getTransaction().commit();//qui committiamo, la rendiamo permanente
	}

	public void delete(int id)
	{

		Contract toDelete = findContract(id);//prima prendiamo lo contract con quell'id
		if(toDelete == null)//se non l'abbiamo trovato
			throw new RuntimeException("Contract not found");

		em.getTransaction().begin();
		em.remove(toDelete);
		em.getTransaction().commit();
	}
	//FINE METODI CRUD DI BASE


}
