import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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

}
