package Easy;

//1662. Check If Two String Arrays are Equivalent
public class Solution1662 {
    public static void main(String[] args) {
        var word1 = new String[] { "ab", "c" };
        var word2 = new String[] { "a", "bc" };
        var app = new Solution1662();
        var res = app.arrayStringsAreEqual(word1, word2);
        System.out.println(res);
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        var iterator1 = new WordIterator(word1);
        var iterator2 = new WordIterator(word2);
        while (iterator1.hasNext() && iterator2.hasNext()) {
            var ch1 = iterator1.next();
            var ch2 = iterator2.next();
            if (ch1 != ch2) {
                return false;
            }
        }
        return !iterator1.hasNext() && !iterator2.hasNext();
    }

    class WordIterator {
        String[] words;
        int i = 0;
        int j = -1;

        public WordIterator(String[] words) {
            this.words = words;
        }

        public boolean hasNext() {
            if (j + 1 < words[i].length()) {
                return true;
            } else {
                return i < words.length - 1;
            }
        }

        public Character next() {
            j++;
            if (j >= words[i].length()) {
                j = 0;
                i++;
            }
            return i < words.length ? words[i].charAt(j) : null;
        }
    }
}
