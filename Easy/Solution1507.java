package Easy;

import java.util.HashMap;

//https://leetcode.com/problems/reformat-date/
public class Solution1507 {
    public String reformatDate(String date) {
        var arr = date.split(" ");
        String year = arr[2];
        String month = getMonths().get(arr[1]);
        String day = arr[0].substring(0, arr[0].length() - 2);
        return year + "-" + month + "-" + (day.length() == 1 ? "0" + day : day);
    }

    public HashMap<String, String> getMonths() {
        HashMap<String, String> hm = new HashMap<>();
        hm.put("Jan", "01");
        hm.put("Feb", "02");
        hm.put("Mar", "03");
        hm.put("Apr", "04");
        hm.put("May", "05");
        hm.put("Jun", "06");
        hm.put("Jul", "07");
        hm.put("Aug", "08");
        hm.put("Sep", "09");
        hm.put("Oct", "10");
        hm.put("Nov", "11");
        hm.put("Dec", "12");
        return hm;
    }
}