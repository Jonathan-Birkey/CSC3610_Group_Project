package CSC3610_Group_Project;

import java.util.Iterator;

public class IteratorAndComparatorTest {

	public static void main(String[] args) {
		// Comparator
		CarComparator comp = new CarComparator();
		Car car1 = new Car();
		Car car2 = new Car("Blue","Model S",2018,"22\"","Black",90000.00,"P100D","sunroof");
		Car car3 = new Car("Red","Model S",2018,"22\"","White",75000.00,"P100D","sunroof");
		
		System.out.println("Comparing car1 and car2 is: " + comp.compare(car1, car2));
		System.out.println("Comparing car2 and car3 is: " + comp.compare(car2, car3));
		System.out.println("Comparing car1 and car3 is: " + comp.compare(car1, car3));
		
		// Iterator
		CarIterableList iterable = new CarIterableList();
		iterable.carList.add(car1);
		iterable.carList.add(car2);
		iterable.carList.add(car3);
		iterable.carList.add(car2);
		
		Iterator<Car> iter = iterable.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
