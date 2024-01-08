package com.app.dao;
import org.hibernate.*;
import static com.app.utils.HibernateUtill.getFactory;

import java.io.Serializable;
import java.util.List;
import com.app.pojos.IplTeam;

public class IplTeamDaoImpl implements IplTeamDao{
	@Override
	public String addIplTeam(IplTeam newTeam) {
		String msg = "Addind IplTeam Failed";
		//Get a session from SF
		Session session = getFactory().getCurrentSession();
		
		//Begin a transaction
		Transaction tx = session.beginTransaction();
		
		//try-save team details,commit.
		try{
			Serializable teamId = session.save(newTeam);
			System.out.println(teamId);
			tx.commit();
			msg = "Added IplTeam" + newTeam;
		}//catch: runtime exception: rollback tx, throw e.
		catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
				throw e;
			}
		}
		return msg;
	}

	@Override
	public List<IplTeam> DisplayIdAbb() {
		List<IplTeam> list;
		String jpql = "select new com.app.pojos.IplTeam(teamId,abbreviation) from IplTeam i order by team_id asc";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try{
			list = session.createQuery(jpql, IplTeam.class).getResultList();
			tx.commit();
			
		}catch (RuntimeException e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			throw e;
		}
		return list;
	}
	
	public IplTeam DisplayIplTeam (Integer teamId) {
		IplTeam it = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			it = session.get(IplTeam.class, teamId);
		}catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			throw e;
		}
		
		return it;
	}
	
	public List<IplTeam> DisplayTeamsByAgeWickets (int age, int wickets){
		List<IplTeam> list = null;
		String jpql = "select i from IplTeam i where i.maxAge < :age and i.wicketsTaken > : wickets";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			list = session.createQuery(jpql, IplTeam.class)
					.setParameter("age", age)
					.setParameter("wickets", wickets)
					.getResultList();
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			throw e;
		}
		return list;
	}	
	
	
	public int UpdateAgeBattingAvg (String name, int age, double avg) {
		int count = 0;
		String jpql = "select i from IplTeam i where i.name = :name";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			IplTeam it =  session.createQuery(jpql, IplTeam.class)
							.setParameter("name", name).getSingleResult();
			it.setMaxAge(age);
			it.setBattingAvg(avg);
			tx.commit();
		}
		catch (RuntimeException e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			throw e;
		}
		
		return count;
	}
	
	public String DeleteTeam (int teamId) {
		String msg = "Deletion failed.";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String jpql = "select i from IplTeam i where i.teamId = :teamId";
		
		try {
			IplTeam it = session.get(IplTeam.class, teamId);
			if (it != null) {
				session.delete(it);
			}
			msg = "Team details of "+it.getName() + " is deleted."; 
			tx.commit();
		}
		catch (RuntimeException e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			throw e;
		}
		
		return msg;
	}
	
	
	
}
