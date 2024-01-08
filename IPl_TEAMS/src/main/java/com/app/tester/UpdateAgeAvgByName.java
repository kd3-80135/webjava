package com.app.tester;
import static com.app.utils.HibernateUtill.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.IplTeamDao;
import com.app.dao.IplTeamDaoImpl;


public class UpdateAgeAvgByName {

	public static void main(String[] args) {
		try(SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in)){
			IplTeamDao dao = new IplTeamDaoImpl();
			int count = dao.UpdateAgeBattingAvg(sc.next(), sc.nextInt(), sc.nextDouble());
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		
	}

}
