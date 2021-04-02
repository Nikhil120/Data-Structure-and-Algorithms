
public class DaysOld {
	
	public int getDaysTillMonth(int m) {
		int[] prefixDaysSumToMonth = {31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
		
		if (m < 2) {
			return 0;
		}
		
		return prefixDaysSumToMonth[m-2];
	}
	
	int calculateNumberOfDays(int y, int m, int d) {
		int numberOfDays = 0;
		int numberOfLeapYears = 0;
		
		numberOfDays += 365 * (y-1) + getDaysTillMonth(m) + d;
		
		if (m > 2) {
			numberOfLeapYears = (y / 4) - (y / 100) + (y/400);
		}
		else {
			numberOfLeapYears = (y / 4) - (y / 100) + (y/400);
		}
		
		return numberOfDays + numberOfLeapYears;
	}
	
	public boolean checkIfValidInput(int y1, int m1, int d1, int y2, int m2, int d2) {
		boolean isInputValid = false;
		
		if (y2 > y1) {
			isInputValid = true;
		}
		else if (y2 == y1 && m2 > m1) {
			isInputValid = true;
		}
		else if (y2 == y1 && m2 == m1 && d2 >= d1) {
			isInputValid = true;
		}
		
		return isInputValid;
	}
	
	public int getAgeInDays(int y1, int m1, int d1, int y2, int m2, int d2) {
		
		boolean isInputvalid = checkIfValidInput(y1, m1, d1, y2, m2, d2);
		
		if (!isInputvalid) {
			return -1;
		}
		
		int ageInDays = 0;
		
		int numberOfDays1 = calculateNumberOfDays(y1, m1, d1);
		int numberOfDays2 = calculateNumberOfDays(y2, m2, d2);
			
		ageInDays = numberOfDays2 - numberOfDays1 + 1;
		
		return ageInDays;
	}
	
	public static void main(String args[]) {
		DaysOld daysOld = new DaysOld();
		int ageInDays = daysOld.getAgeInDays(1996, 1, 9, 2114, 9, 16);
		System.out.print(ageInDays);
	}
}
