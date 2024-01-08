package com.app.tester;
import static com.app.utils.HibernateUtill.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.IplTeamDao;
import com.app.dao.IplTeamDaoImpl;


public class DisplayTeamByAgeWickets {

	public static void main(String[] args) {
		try(SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in)){
			IplTeamDao dao = new IplTeamDaoImpl();
			dao.DisplayTeamsByAgeWickets(sc.nextInt(), sc.nextInt()).forEach(System.out::println);;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
