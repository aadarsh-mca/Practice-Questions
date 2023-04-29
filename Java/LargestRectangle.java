import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class LargestRectangle {

	public static void main(String[] args) {
		List<Integer> height = new ArrayList<Integer>();
		
		height.addAll(Arrays.asList(3, 2, 4, 5, 3, 3, 6, 4));
		System.out.println(height);
		
		int temp = 0, min = 0, minIndex = 0, max = 0, maxIndex = 0;
		for(int i = 0; i < height.size(); i++) {
			// temp = 
			if(temp > i) {
				temp = i;
			}
		}
		
	}

}