package br.com.amcom.teste.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.amcom.teste.utils.HibernateUtil;

public class DAO<E> {

	
	
	public E salvar(E entidade) throws Exception {
		Transaction transaction = null;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			transaction = session.beginTransaction();
			
			session.save(entidade);
			
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			
			throw new Exception("Error ao salvar.");
		} finally {
			session.flush();
			
			session.close();
		}
		
		return entidade;
		
	}

	public void atualizar(E entidade) throws Exception {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			session.update(entidade);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			throw new Exception("Error ao atualizar.");
		} finally {
			session.flush();
			session.close();
		}
	}

	public void remover(E entidade, int id) throws Exception {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			Object carregada = session.load(entidade.getClass(), id);

			session.delete(carregada);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			throw new Exception("Error ao remover.");
		} finally {
			session.flush();
			session.close();
		}
		
	}

	public List<E> listar(E entidade) {
		List<E> entidades = new ArrayList<E>();

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			entidades = session.createQuery("from " + entidade.getClass().getName()).list();

		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return entidades;
	}

	public E buscar(E entidade, int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			entidade = (E) session.get(entidade.getClass(), id);
		} finally {
			session.flush();
			session.close();
		}

		return entidade;
	}

}
