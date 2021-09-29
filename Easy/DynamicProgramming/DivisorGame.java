package Easy.DynamicProgramming;

public class DivisorGame {
    public static void main(String[] args) {

    }

    public boolean divisorGame(int n) {
        if (n == 1) {
            return false;
        } else {
            return !divisorGame(n - 1);
        }
    }
}
