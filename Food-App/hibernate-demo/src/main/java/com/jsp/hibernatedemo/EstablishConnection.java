package com.jsp.hibernatedemo;


public class EstablishConnection {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistance.createEntityManager("madhu");

	}

}
