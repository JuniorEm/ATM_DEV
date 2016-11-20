package br.umc.data;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@RequestScoped
public class EntityManagerProducer implements Serializable {
	
	@Produces 
	@ApplicationScoped 
	public EntityManagerFactory createFactory() {
		return Persistence.createEntityManagerFactory("default");
	}
	
	@Produces
	@RequestScoped
	public EntityManager createManager(EntityManagerFactory factory) {
		return factory.createEntityManager();
	}
	
	public void close(@Disposes EntityManager manager) {
		if (manager.isOpen())
			manager.close();
	}
	
}
