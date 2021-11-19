import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CountriesDataRepository {

	public void save(CountryData countryData) {
		SessionFactory sessionFactory = new Configuration()
				.addClass(CountryData.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();

		try {
			Transaction transaction = session.beginTransaction();
			session.save(countryData);
			transaction.commit();
		} finally {
			sessionFactory.close();
		}
	}

	public List<Double> findAllFields() {
		List<Double> result = new ArrayList<>();
		SessionFactory sessionFactory = new Configuration()
				.addClass(CountryData.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();

		try {
			Transaction transaction = session.beginTransaction();
			String sql = "SELECT countryData.happinessScore from CountryData countryData";
			Query query = session.createQuery(sql);
			List queryResult = query.list();

			queryResult.forEach(res -> result.add((Double) res));
			transaction.commit();
		} catch (HibernateException e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			sessionFactory.close();
		}

		return result;
	}
}
