// A single DVD.

import java.text.NumberFormat;

public class DVD implements Comparable {
	private String title, director;
	private int year;
	private double cost;
	private boolean bluray;
	
	public DVD(String title, String director, int year, double cost,
			boolean bluray) {
		this.title = title;
		this.director = director;
		this.year = year;
		this.cost = cost;
		this.bluray = bluray;
	}
	
	
	public String toString() {
		NumberFormat myFormat = NumberFormat.getCurrencyInstance();
		
		String description = myFormat.format(cost) + "\t" + year + "\t" +
				title + "\t" + director;
		if (bluray)
			description += "\t" + "Blu-ray";
		
		return description;
	}


    public String getTitle() {
        return title;
    }


    public int compareTo(Object input) {
        return title.compareTo(((DVD)input).getTitle());
    }


    public boolean equals(Object input) {
        return title.equals(((DVD)input).getTitle());
    }
}
