//Container With Most Water
public class Container {
	public int maxArea(int[] height) {
        int max = 0;
        if (height == null || height.length == 0) return max;
        int low = 0, high = height.length -1;
        while (low < high){
            max = Math.max(max, (high - low)*Math.min(height[low],height[high]));
            if (height[low] < height[high]) low++;
            else high--;
        }
        return max;
    }
}
