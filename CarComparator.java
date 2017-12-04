package CSC3610_Group_Project;

import java.util.Comparator;

public class CarComparator implements Comparator<Car> {

	@Override
	public int compare(Car o1, Car o2) {
		if (o1.price < o2.price)
			return -1;
		else if (o1.price > o2.price)
			return 1;
		else
			return 0;
	}

}
