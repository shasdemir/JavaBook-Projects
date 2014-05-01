// Represents a collection of DVD movies.

import java.text.NumberFormat;
import java.util.ArrayList;

public class DVDCollection {
	private ArrayList<DVD> members;
	private double totalCost;
	
	public DVDCollection() {
		members = new ArrayList<DVD>();
		totalCost = 0.0;
	}
	
	
	public void addDVD(String title, String director, int year, double cost,
			boolean bluray) {
		members.add(new DVD(title, director, year, cost, bluray));
		totalCost += cost;

        members = YaSort.insertionSort(members);
	}

	
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
