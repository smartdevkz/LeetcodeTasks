package Easy;

//1859. Sorting the Sentence
public class Solution1859 {
    public static void main(String[] args) {
        var app = new Solution1859();
        var res = app.sortSentence("Myself2 Me1 I4 and3");
        System.out.println(res);
    }

    public String sortSentence(String s) {
        String[] arr = s.split(" ");

        int i = 0;
        while (i < arr.length) {
            Character c = arr[i].charAt(arr[i].length() - 1);
            if (isNumeric(c)) {
                int number = parseInt(c);
                var temp = arr[number - 1];
                arr[number - 1] = arr[i];
                arr[i] = temp;
                arr[number - 1] = getCorrectedString(arr[number - 1]);
            } else {
                i++;
            }
        }

        return String.join(" ", arr);
    }

    boolean isNumeric(Character c) {
        return Character.isDigit(c);
    }

    int parseInt(Character c) {
        return Character.getNumericValue(c);
    }

    String getCorrectedString(String s) {
        return s.substring(0, s.length() - 1);
    }

}
