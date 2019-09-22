package com.tyss.demoone;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number...");
		System.out.println("Press 1 to Login!");
		System.out.println("Press 2 to Register!");
		int a = sc.nextInt();
		EntityTransaction et = null;
		EntityManager em = null;
		EntityManagerFactory emf = null;
		Account account = null;
		try {
			emf = Persistence.createEntityManagerFactory("TestPersistence");
			em = emf.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
		switch (a) {
		case 1:
			System.out.println("Press A to Compose");
			System.out.println("Press B to show inbox");
			char c = sc.next().charAt(0);
			if (c == 'A') {
				// Composing Mail...
				et.begin();
				String str1 = "update account set Message=:msg where Message_Id=:mi";
				Query q2 = em.createQuery(str1);
				q2.setParameter("mi", 11);
				q2.setParameter("msg", "hi...");
				q2.executeUpdate();
				et.commit();
				System.out.println("Store the compose mail..");
			} else if (c == 'B') {
				String str = "from inbox where Message_Id=:msi";
				Query q = em.createQuery(str);
				q.setParameter("msi", 11);
				int exec = q.executeUpdate();
				List<Integer> resultList = q.getResultList();
				for (Integer s : resultList) {
					System.out.println(s);
				}
			}
			break;
		case 2:
			System.out.println("To create an Account");
			account = new Account();
			account.setUser_Id(3);
			account.setUser_Name("ishu");
			account.setEmail("ishu@gmail.com");
			account.setPassword("5458");

			et = em.getTransaction();
			et.begin();
			em.persist(account);
			et.commit();
			System.out.println("Account Created...");
		}
	}
}
