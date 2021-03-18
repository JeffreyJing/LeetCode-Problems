class Solution {
    public int dayOfYear(String date) {
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = 0;
        int month = 0;
        int day = 0;
        for (int i = 0; i < date.length(); i++) {
            if (i >= 0 && i < 4) { // year
                year = year * 10 + (date.charAt(i) - 48); // 0 * 10 + 1 -> 1 * 10 + 9 -> 19 * 10 + 9 -> 199 * 10 + 7 = 1997
            } else if (i >= 5 && i < 7) { // month
                month = month * 10 + (date.charAt(i) - 48); // 0 * 10 + 1 -> 1 * 10 + 1 = 11
            } else if (i >= 8 && i < 10) { // day
                day = day * 10 + (date.charAt(i) - 48); // 0 * 10 + 0 -> 0 * 10 + 4 = 4
            }
        }
        
        for (int i = 0; i < month - 1; i++) {
            day += months[i];
        }
        
        if ((year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) && month > 2) {
            day++;
        } 
        
        return day;
    }
}
