package com.app.tester;

import org.hibernate.SessionFactory;

import com.app.dao.IplTeamDao;
import com.app.dao.IplTeamDaoImpl;
import com.app.pojos.IplTeam;

import static com.app.utils.HibernateUtill.getFactory;

import java.util.Scanner;

public class DisplayIdAbbreviation {
	
	public static void main(String[] args) {
		try(SessionFactory sf = getFactory()){
			IplTeamDao dao = new IplTeamDaoImpl();
			dao.DisplayIdAbb().
				forEach(i -> System.out.println(i.getTeamId() + " " + i.getAbbreviation()));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
