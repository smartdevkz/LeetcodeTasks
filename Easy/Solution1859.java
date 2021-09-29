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
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = getMinimumIndex(arr, i);
            String temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            arr[i] = getCorrectedString(arr[i]);
        }
        arr[arr.length - 1] = getCorrectedString(arr[arr.length - 1]);
        return String.join(" ", arr);
    }

    String getCorrectedString(String s) {
        return s.substring(0, s.length() - 1);
    }

    int getMinimumIndex(String[] arr, int start) {
        int min = getNumber(arr[start]);
        int index = start;
        for (int i = start + 1; i < arr.length; i++) {
            int current = getNumber(arr[i]);
            if (current < min) {
                min = current;
                index = i;
            }
        }
        return index;
    }

    int getNumber(String s) {
        return Character.getNumericValue(s.charAt(s.length() - 1));
    }
}
