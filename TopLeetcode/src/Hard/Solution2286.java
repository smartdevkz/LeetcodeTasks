package Hard;

//https://leetcode.com/problems/booking-concert-tickets-in-groups/
public class Solution2286 {
    class BookMyShow {
        int[][] arr;
        int n, m;

        public BookMyShow(int n, int m) {
            this.arr = new int[n][m];
            this.n = n;
            this.m = m;
        }

        public int[] gather(int k, int maxRow) {
            int count = 0;
            if(k > m) return new int[]{};
            for( int i = 0; i <= maxRow; i++){
                for(int j = 0; j < m; j++){
                    if(arr[i][j] == 0){
                        count++;
                        if(count == k){
                            setZeros(i, j-k+1, k);
                            return new int[]{ i, j-k+1 };
                        }
                    } else {
                        count = 0;
                    }
                }
            }
            return new int[]{};
        }

        private void setZeros(int row, int col, int k){
            for(int j = col; j<col+k;j++){
                arr[row][j] = 1;
            }
        }

        public boolean scatter(int k, int maxRow) {
            int count = 0;

            for( int i = 0; i <= maxRow; i++){
                for(int j = 0; j < m; j++){
                    if(arr[i][j] == 0){
                        arr[i][j] = 2;
                        count++;
                        if(count == k){
                            replace(2,1,i);
                            return true;
                        }
                    }
                }
            }
            replace(2,0,maxRow);
            return false;
        }

        void replace(int val, int newVal, int maxRow){
            for( int i = 0; i <= maxRow; i++){
                for(int j = 0; j < m; j++){
                    if(arr[i][j] == val){
                        arr[i][j] = newVal;
                    }
                }
            }
        }
    }
}
