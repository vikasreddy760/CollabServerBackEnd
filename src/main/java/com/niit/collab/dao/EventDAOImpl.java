package com.niit.collab.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collab.model.Event;
import com.niit.collab.model.Event;

@Repository(value="eventDAO")
public class EventDAOImpl implements EventDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public EventDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean saveOrUpdate(Event event) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(event);
			System.out.println("save");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(Event event) {
		try {
			sessionFactory.getCurrentSession().delete(event);
			System.out.println("save");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	@SuppressWarnings("deprecation")
	public List<Event> list() {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Event.class);
		@SuppressWarnings("unchecked")
		List<Event> list=c.list();
		return list;
	}
@Transactional
	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	public Event getevent(int id) {
		String hql = "from Event where id= "+ "'"+ id+"'" ;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Event>list= query.list();
		
		if(list==null)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}

}
public Event get(int id) {
	// TODO Auto-generated method stub
	return null;
}
}
