package Utility;

public class FormatDate {
	public static String formatDate(String releasedate) {
		
		String array[] = releasedate.split(" ");
		String date = "";
		for(String a: array) {
			char i= a.charAt(0);
			if(Character.isLetter(i))
			{
				a = a.substring(0, 3);
			}
			if(a.startsWith("(")) {
				break;
			}
			else
				date = date + " " + a;
		}
		date=date.trim();
		return date;
	}
}