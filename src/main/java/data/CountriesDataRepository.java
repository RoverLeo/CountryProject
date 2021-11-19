package data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

public class CountriesDataRepository {

	private SessionFactory sessionFactory;

	public CountriesDataRepository() {
		sessionFactory = HibernateUtils.getSessionFactory();
	}

	public void save(CountryData countryData) {
		Session session = sessionFactory.openSession();

		try {
			Transaction transaction = session.beginTransaction();
			session.save(countryData);
			transaction.commit();
		} catch (HibernateException e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			sessionFactory.close();
		}
	}

	public List<Double> findAllHappinessScore() {
		String sql = "SELECT countryData.happinessScore from CountryData countryData";

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(sql);
		List<Double> queryResult = query.list();

		List<Double> result = new ArrayList<>(queryResult);

		return result;
	}

	public List<Double> findAllStandardError() {
		String sql = "SELECT countryData.standardError from CountryData countryData";

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(sql);
		List<Double> queryResult = query.list();

		List<Double> result = new ArrayList<>(queryResult);

		return result;
	}

	public List<Double> findAllFreedom() {
		String sql = "SELECT countryData.freedom from CountryData countryData";

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(sql);
		List<Double> queryResult = query.list();

		List<Double> result = new ArrayList<>(queryResult);

		return result;
	}
}
