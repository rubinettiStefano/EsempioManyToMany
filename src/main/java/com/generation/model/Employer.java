package com.generation.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Employer
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name,address;

	@OneToMany(mappedBy = "employer")
	private List<Contract> contracts = new ArrayList<>();

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public List<Contract> getContracts()
	{
		return contracts;
	}

	public void setContracts(List<Contract> contracts)
	{
		this.contracts = contracts;
	}

	public Set<Freelancer> getAllFreelancer()
	{
		Set<Freelancer> res = new HashSet<>();

		for(Contract contract : contracts)
			res.add(contract.getFreelancer());

		return res;
	}
}
