package com.datum.mapping.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.datum.mapping.model.Master;

@Service
public class MasterDaoImpl implements MasterDao{

	@Override
	public List<Master> find() {
		Session session = com.datum.mapping.util.MasterSchema.getSession();
		Transaction tr=session.beginTransaction();
		String sql="select m from Master m";
		return session.createQuery(sql,Master.class).getResultList();
	}
	

}
