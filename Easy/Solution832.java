package Easy;

//832. Flipping an Image
public class Solution832 {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for (int i = 0; i < n; i++) {
            int j = 0;
            while (n - 2 * j - 1 > 0) {
                int temp = image[i][j];
                image[i][j] = image[i][n - 1 - j];
                image[i][n - 1 - j] = temp;
                image[i][j] = image[i][j] == 0 ? 1 : 0;
                image[i][n - 1 - j] = image[i][n - 1 - j] == 0 ? 1 : 0;
                j++;
            }
        }
        return image;
    }
}
