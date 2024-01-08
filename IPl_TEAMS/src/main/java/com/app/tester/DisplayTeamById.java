package com.app.tester;

import org.hibernate.SessionFactory;

import com.app.dao.IplTeamDao;
import com.app.dao.IplTeamDaoImpl;
import com.app.pojos.IplTeam;

import static com.app.utils.HibernateUtill.getFactory;

import java.util.Scanner;

public class DisplayTeamById {
	
	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in)){
			IplTeamDao dao = new IplTeamDaoImpl();
			System.out.println(dao.DisplayIplTeam(sc.nextInt()));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
