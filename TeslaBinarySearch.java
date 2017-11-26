package CSC3610_Group_Project;

import javafx.collections.ObservableList;

public class TeslaBinarySearch {
	public static TransactionTable binarySearch(ObservableList<TransactionTable> list, Double key){
		int low = 0;
		int high = list.size() - 1;
		return binarySearch(list,  key, low, high);
	}
	
	private static TransactionTable binarySearch(ObservableList<TransactionTable> list, Double key, int low, int high){
		if(low > high){
			System.out.println("Returning null");
			return null;
		}
		
		int mid = (low + high) / 2;
		System.out.println(list.get(mid).getPrice());
		
		if(key < list.get(mid).getPrice()){
			System.out.println("key is less than middle");
			return binarySearch(list, key, low, mid - 1);
		}
		else if(key > list.get(mid).getPrice()){
			System.out.println("key is greater than middle");
			return binarySearch(list, key, mid + 1, high);

		}
		else{
			System.out.println("key is found at middle");
			return list.get(mid);
		}
	}
}
