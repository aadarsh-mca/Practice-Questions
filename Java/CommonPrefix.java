import java.util.Arrays;

class CommonPrefix {
	int index = -1;
	public static void main(String[] args) {
		CommonPrefix obj = new CommonPrefix();
		String[] strArr = {"geeksforgeeks", "geeks", "geek", "geezer"};
		String prefix = "geeksforgeeks";
		
		Arrays.sort(strArr);
		System.out.println(Arrays.toString(strArr));
		
		obj.comPrefixIndex(strArr, 0, obj.smallestWordLength(strArr)-1);
		if(obj.index == -1) {
			System.out.println("No common prefix found !!!");
		} else {
			obj.index++; // adding 1, because substring exclude the last index
			prefix = strArr[0].substring(0, obj.index);
			System.out.println("Longest common prefix is : " + prefix);
		}
	}
	
	void comPrefixIndex(String[] arr, int x, int smallWordLen) {
		for(int i=1; i<arr.length; i++) {
			if(arr[0].charAt(x) != arr[i].charAt(x)) {
				this.index = x-1;
				return;
			}
		}
		if(x == smallWordLen) {
			this.index = x;
			return;
		}
		comPrefixIndex(arr, x+1, smallWordLen);
		
	}
	
	int smallestWordLength(String[] arr) {
		int len = arr[0].length();
		for(int i=1; i<arr.length; i++) {
			if(len > arr[i].length()) {
				len = arr[i].length();
			}
		}
		return len;
	}
}