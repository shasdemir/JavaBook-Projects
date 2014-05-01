// A class to test Season enum

public class SeasonTester {
	public static void main(String[] args) {
		for (Season time : Season.values())
			System.out.println(time + "\t" + time.getSpan());
		
		System.out.println();
		Season time1, time2;
		time1 = Season.winter;
		time2 = Season.summer;
		System.out.println(time1);
		System.out.println(time2.name());
		System.out.println(time1.ordinal());
		System.out.println(time2.getSpan());
	}
}
