package com.niit.collab.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collab.model.Forum;
import com.niit.collab.model.Job;

@Repository(value="jobDAO")
public class JobDAOImpl implements JobDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public JobDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean saveOrUpdate(Job job) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(job);
			System.out.println("save");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(Job job) {
		try {
			sessionFactory.getCurrentSession().delete(job);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	@SuppressWarnings("deprecation")
	public List<Job> list() {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Job.class);
		@SuppressWarnings("unchecked")
		List<Job> list=c.list();
		return list;
	}
@Transactional
	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	public Job getjob(int id) {
		String hql = "from Forum where id= "+ "'"+ id+"'" ;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Job>list= query.list();
		
		if(list==null)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}

    }
public Job get(int id) {
	// TODO Auto-generated method stub
	return null;
}
}
