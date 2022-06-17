import java.util.HashMap;
import java.util.Scanner;

public class JournalApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] marks = new int[13]; 
        int k=0;
        while(k<marks.length){
            System.out.print("Enter a mark: ");
            int num = scanner.nextInt();
            if(num>0&&num<6){
                marks[k]=num;
                k++;
            }else{
                System.out.println("Wrong value!");
            }
        }
        
        HashMap<Integer, Integer> marksCount = calculate(marks);
        display(marksCount);
    }

    static HashMap<Integer, Integer> calculate(int[] marks){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<marks.length;i++){
            int key = marks[i];
            if(map.containsKey(key)){
                int val = map.get(key);
                val++;
                map.put(key, val);
            }else{
                map.put(key, 1);
            }
        }
        return map;
    }

    static void display(HashMap<Integer, Integer> map){
        map.forEach((key,value) -> System.out.println(key + ": " + value));
    }
}