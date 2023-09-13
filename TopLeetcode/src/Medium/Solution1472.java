package Medium;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/design-browser-history/
public class Solution1472 {


    public static void main(String[] args) {
        var app = new Solution1472();
        app.run();
    }

    /*

    ["BrowserHistory","visit","forward","forward","visit","visit","back","visit","visit","forward","back","visit","visit","visit","forward","forward","visit","visit","back","visit","forward","visit","visit","visit","back"]
[["jrbilt.com"],
["uiza.com"],
[3],
[3],
["fveyl.com"],
["hyhqfqf.com"],
[3],
["cccs.com"],["bivz.com"],[6],[1],["cmbw.com"],["iywwwfn.com"],["sktbhdx.com"],[8],[10],["bskj.com"],["thw.com"],[6],["hgesj.com"],[6],["ctb.com"],["fllnc.com"],["fs.com"],[7]]
     */

    private void run() {

        BrowserHistory history = new BrowserHistory("jrbilt.com");
        history.visit("uiza.com");
        history.forward(3);
        history.forward(3);
        history.visit("fveyl.com");
        history.visit("hyhqfqf.com");
        history.back(3);
        history.visit("cccs.com");
        history.visit("bivz.com");
        history.forward(6);
        history.back(1);
        history.visit("cmbw.com");
        history.visit("iywwwfn.com");
        history.visit("sktbhdx.com");
        history.forward(8);
        history.forward(10);
        history.visit("bskj.com");
        history.visit("thw.com");
        history.back(6);//
        history.visit("hgesj.com");
        history.forward(6);
        history.visit("ctb.com");
        history.visit("fllnc.com");
        history.visit("fs.com");
        history.forward(7);
    }

    class BrowserHistory {

        int idx = 0;

        List<String> pages;
        int current = 0;

        public BrowserHistory(String homepage) {
            System.out.print(++idx + ". ");
            System.out.println("start:");
            pages = new ArrayList<>();
            pages.add(homepage);
        }

        public void visit(String url) {
            System.out.print(++idx + ". ");
            System.out.println("visit: " + url);

            if (current + 1 < pages.size()) {
                pages.subList(current + 1, pages.size()).clear();
            }


            pages.add(url);
            current = pages.size() - 1;
            displayPages();
        }

        public String back(int steps) {
            System.out.print(++idx + ". ");
            int next = current - steps;
            if (next >= 0) {
                current = next;
            } else {
                current = 0;
            }
            System.out.println("back " + steps + ": " + pages.get(current));
            displayPages();
            return pages.get(current);
        }

        public String forward(int steps) {
            int next = current + steps;
            if (next < pages.size()) {
                current = next;
            } else {
                current = pages.size() - 1;
            }
            System.out.print(++idx + ". ");
            System.out.println("forward " + steps + ": " + pages.get(current));
            displayPages();
            return pages.get(current);
        }

        public void displayPages() {
            System.out.println("current: " + current);
            System.out.print("pages : {");
            for (String item : pages) {
                System.out.print(item + ", ");
            }
            System.out.print("}");
            System.out.println("");
            System.out.println("");
        }
    }
}


