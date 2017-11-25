package CSC3610_Group_Project;

import javafx.collections.ObservableList;

public class TeslaQuickSort {
	public static void quickSort(ObservableList<TransactionTable> list){
		quickSort(list, 0, list.size() - 1);
	}
	
	public static void quickSort(ObservableList<TransactionTable> list, int firstIndex, int lastIndex){
		if( lastIndex > firstIndex){
			int pivotIndex = partition(list, firstIndex, lastIndex);
			quickSort(list, firstIndex, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, lastIndex);
		}
	}
	
	public static int partition(ObservableList<TransactionTable> list, int firstIndex, int lastIndex){
		TransactionTable pivot = list.get(firstIndex);
		int low = firstIndex + 1;
		int high = lastIndex;
		
		while(high > low){
			while(low <= high && list.get(low).getPrice() <= pivot.getPrice())
				low++;
			
			while(low <= high && list.get(high).getPrice() > pivot.getPrice())
				high--;
			
			if(high > low){
				TransactionTable temp = list.get(high);
				list.set(high, list.get(low));
				list.set(low, temp);
			}
		}
		
		while(high > firstIndex && list.get(high).getPrice() >= pivot.getPrice())
			high--;
		
		if(pivot.getPrice() > list.get(high).getPrice()){
			list.set(firstIndex, list.get(high));
			list.set(high, pivot);
			return high;
		}
		else{
			return firstIndex;
		}
	}
}
