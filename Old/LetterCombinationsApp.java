import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsApp {

    public static void main(String[] args) {
        String digits="";
        display(letterCombinations(digits));
    }

    public static void display(List<String> lst){
        for(int i=0;i<lst.size();i++){
            System.out.println(lst.get(i));
        }
    }

    public static List<String> letterCombinations(String digits) {
        if(digits.length()==0) return new ArrayList<String>();
        if(digits.length()==1)return Arrays.asList(getLetters(digits));
        else {
            return multiply(digits.substring(0, 1), letterCombinations(digits.substring(1)));
        }
    }

    public static List<String> multiply(String a, List<String> arr){
        if(a.equals("1"))return arr;
        if(arr.size()==0)return Arrays.asList(getLetters(a));
        List<String> lst = new ArrayList<String>();
        String[] letters = getLetters(a);
        for(int i=0;i<letters.length;i++){
            for(int j=0;j<arr.size();j++){
                lst.add(letters[i]+arr.get(j));
            }
        }
        return lst;
    }

    public static String[] getLetters(String digit){
        switch(digit){
            case "1":return new String[]{};
            case "2":return new String[]{"a","b","c"};
            case "3":return new String[]{"d","e","f"};
            case "4":return new String[]{"g","h","i"};
            case "5":return new String[]{"j","k","l"};
            case "6":return new String[]{"m","n","o"};
            case "7":return new String[]{"p","q","r","s"};
            case "8":return new String[]{"t","u","v"};
            case "9":return new String[]{"w","x","y","z"};
            default:return new String[]{};
        }
    }
}