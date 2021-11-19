package data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CountryData {

	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = AUTO)
	private long id;

	@Column
	private String name;

	@Column
	private String region;

	@Column
	private double happinessRank;

	@Column
	private double happinessScore;

	@Column
	private double standardError;

	@Column
	private double economy;

	@Column
	private double family;

	@Column
	private double health;

	@Column
	private double freedom;

	@Column
	private double trust;

	@Column
	private double generosity;

	@Column
	private double dystopiaResidual;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		CountryData that = (CountryData) o;

		if (id != that.id) return false;
		if (Double.compare(that.happinessRank, happinessRank) != 0) return false;
		if (Double.compare(that.happinessScore, happinessScore) != 0) return false;
		if (Double.compare(that.standardError, standardError) != 0) return false;
		if (Double.compare(that.economy, economy) != 0) return false;
		if (Double.compare(that.family, family) != 0) return false;
		if (Double.compare(that.health, health) != 0) return false;
		if (Double.compare(that.freedom, freedom) != 0) return false;
		if (Double.compare(that.trust, trust) != 0) return false;
		if (Double.compare(that.generosity, generosity) != 0) return false;
		if (Double.compare(that.dystopiaResidual, dystopiaResidual) != 0) return false;
		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		return region != null ? region.equals(that.region) : that.region == null;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = (int) (id ^ (id >>> 32));
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (region != null ? region.hashCode() : 0);
		temp = Double.doubleToLongBits(happinessRank);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(happinessScore);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(standardError);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(economy);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(family);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(health);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(freedom);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(trust);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(generosity);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(dystopiaResidual);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
}
