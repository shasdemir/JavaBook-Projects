// Represents a collection of DVD movies.

import java.text.NumberFormat;
import java.util.ArrayList;

public class DVDCollection {
//	private final int INITIAL_SIZE = 100;
	private ArrayList<DVD> members;
//	private int count; // really?
	private double totalCost;
	
	public DVDCollection() {
		members = new ArrayList<DVD>();
//		count = 0;
		totalCost = 0.0;
	}
	
	
	public void addDVD(String title, String director, int year, double cost,
			boolean bluray) {
//		if(count == members.length)
//			increaseSize();
		
		members.add(new DVD(title, director, year, cost, bluray));
		totalCost += cost;
//		count++;

        members = (ArrayList<DVD>) YaSort.insertionSort(members);
	}
	
	
//	private void increaseSize() {
//		DVD[] temp = new DVD[members.length * 2];
//
//		for (int k = 0; k < members.length; k++)
//			temp[k] = members[k];
//
//		members = temp;
//	}
	
	
	public String toString() {
        int count = members.size();
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		
		String report = "*******************************************\n";
		report += "My DVD Collection\n\n";
		
		report += "Number of DVDs: " + count + "\n";
		report += "Total cost: " + fmt.format(totalCost) + "\n";
		report += "Average cost: " + fmt.format(totalCost / count);
		
		report += "\n\nDVD List:\n\n";
		
		for (int nDvd = 0; nDvd < count; nDvd++)
			report += members.get(nDvd).toString() + "\n";
		
		return report;
	}
}
