package com.generation.model.entities;

import jakarta.persistence.*;

@Entity
public class Contract extends BaseEntity
{

	private String commission;
	private int payment;

	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;

	@ManyToOne
	@JoinColumn(name = "freelancer_id")
	private Freelancer freelancer;

	public Employer getEmployer()
	{
		return employer;
	}

	public void setEmployer(Employer employer)
	{
		this.employer = employer;
	}

	public Freelancer getFreelancer()
	{
		return freelancer;
	}

	public void setFreelancer(Freelancer freelancer)
	{
		this.freelancer = freelancer;
	}


	public String getCommission()
	{
		return commission;
	}

	public void setCommission(String commission)
	{
		this.commission = commission;
	}

	public int getPayment()
	{
		return payment;
	}

	public void setPayment(int payment)
	{
		this.payment = payment;
	}
}
