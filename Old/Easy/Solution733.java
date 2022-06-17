package Easy;

//733. Flood Fill
public class Solution733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        fill(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    public void fill(int[][] image, int sr, int sc, int newColor, int prevColor) {
        if (sr >= 0 && sr < image.length && sc >= 0 && sc < image[sr].length && image[sr][sc] != newColor) {
            if (image[sr][sc] == prevColor) {
                image[sr][sc] = newColor;
                fill(image, sr - 1, sc, newColor, prevColor);
                fill(image, sr + 1, sc, newColor, prevColor);
                fill(image, sr, sc - 1, newColor, prevColor);
                fill(image, sr, sc + 1, newColor, prevColor);
            }
            return;
        }
        return;
    }
}
