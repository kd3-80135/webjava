package com.app.tester;

import org.hibernate.SessionFactory;

import com.app.dao.IplTeamDao;
import com.app.dao.IplTeamDaoImpl;
import com.app.pojos.IplTeam;

import static com.app.utils.HibernateUtill.getFactory;

import java.util.Scanner;

public class AddNewTeam {
	
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);
				SessionFactory sf = getFactory()){
			IplTeamDao it = new IplTeamDaoImpl();
			System.out.println("Enter team details : id , name, \r\n"
					+ "abbrevation,owner,max_age,batting_avg,wickets_taken");
			IplTeam newTeam = new IplTeam(sc.next(), sc.next(), sc.next(),sc.nextInt(), sc.nextDouble(), sc.nextInt());
			it.addIplTeam(newTeam);
			System.out.println("Hibernate up and running...");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
