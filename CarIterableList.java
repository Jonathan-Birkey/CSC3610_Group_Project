package CSC3610_Group_Project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarIterableList implements Iterable<Car>{
	public List<Car> carList = new ArrayList<Car>();

	@Override
	public Iterator<Car> iterator() {
		return carList.iterator();
	}

}
