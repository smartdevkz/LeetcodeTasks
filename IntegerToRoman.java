public class IntegerToRoman {
    public static void main(String[] args) {
        int num = 1994;
        String res = intToRoman(num);
        System.out.println(res);
    }

    public static String intToRoman(int num) {
        int rank = 10000;
        StringBuilder sb = new StringBuilder();
        while (rank > 1) {
            int digit = num % rank;
            rank /= 10;
            digit /= rank;
            sb.append(getRomanDigit(digit, rank));
        }
        return sb.toString();
    }

    public static String getRomanDigit(int digit, int rank) {
        String romanUnit1 = "I";
        String romanUnit5 = "V";
        if (rank > 1) {
            if (rank == 10) {
                romanUnit1 = "X";
                romanUnit5 = "L";
            } else if (rank == 100) {
                romanUnit1 = "C";
                romanUnit5 = "D";
            } else if (rank == 1000) {
                romanUnit1 = "M";
                romanUnit5 = "";
            }
        }

        StringBuilder sb = new StringBuilder();
        if (digit < 4) {
            for (int i = 0; i < digit; i++) {
                sb.append(romanUnit1);
            }
            return sb.toString();
        }else if(digit==4){
            sb.append(romanUnit1);
            sb.append(romanUnit5);
        } 
        else if (digit >= 5 && digit < 9) {
            sb.append(romanUnit5);
            for (int i = 0; i < digit - 5; i++) {
                sb.append(romanUnit1);
            }
        } else {
            rank = rank * 10;
            String nextRankRomanUnit1 = getRomanDigit(1, rank);
            sb.append(romanUnit1);
            sb.append(nextRankRomanUnit1);
        }
        return sb.toString();
    }
}