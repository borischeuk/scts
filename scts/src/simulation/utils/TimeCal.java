package simulation.utils;

import java.util.Date;

/**
 * 
 * This class is responsible for calculating the values related to time.
 * E.g.: Convertion between mins and sec
 *
 */
public class TimeCal {

	public static long minusSecond(Date date1, Date date2) {
		return ( date1.getTime() - date2.getTime() ) / 1000;
	}
	
	public static Date plusSecond(Date date, int second) {
		return new Date(date.getTime() + (second * 1000));
	}
	
}
