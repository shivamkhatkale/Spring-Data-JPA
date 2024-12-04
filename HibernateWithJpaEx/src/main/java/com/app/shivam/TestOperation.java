package com.app.shivam;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TestOperation {

	public static void main(String[] args) {
		EntityTransaction tx = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			// 1. (Loads Driver, Creates DB Connections, Prepare stmt)
			emf = Persistence.createEntityManagerFactory("AppDB");
			System.out.println(emf.getClass().getName());

			// 2. (TODO Operations--insert, update,....)
			em = emf.createEntityManager();
			System.out.println(em.getClass().getName());

			// 3. create Transaction
			tx = em.getTransaction();
			System.out.println(tx.getClass().getName());
			// 4. Start Transaction
			tx.begin();

			// 5. Perform operation
			// save data into DB
			Employee emp = new Employee();
			emp.setEmpId(10);
			emp.setEmpName("ABC");
			emp.setEmpSal(500.0);

			em.persist(emp); // SQL: INSERT INTO ...

			// 6. commit
			tx.commit();

		} catch (Exception e) {
			// rollback if any problem
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			// 7. close
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}
	}
}