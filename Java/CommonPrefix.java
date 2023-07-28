import java.util.ArrayList;
import java.util.Arrays;

class CommonPrefix {

	public static void main(String[] args) {
		String[] arr = {"geeksforgeeks", "geeks", "geek", "geeze", "geezer", "geeksfor", "geforce", "zee"};
		int n = arr.length;

        int smallWordLen = -1;
        String result = "";
        
        Arrays.sort(arr);
        smallWordLen = arr[0].length();

        System.out.println(Arrays.toString(arr));

        for(int i=1; i<n; i++) {
            if(smallWordLen <= 1) {
                break;
            }
            for(int j=0; j<smallWordLen; j++) {
                if(arr[i].charAt(j) != arr[0].charAt(j)) {
                    smallWordLen = j;
					break;
                }
            }
        }
        
        if(smallWordLen <= 0) {
            result = "-1";
        } else {
			result = arr[0].substring(0, smallWordLen);
        }
        
		System.out.println("Result --> " + result);
        // return result;
	}


	// int index = -1;
	// public static void main(String[] args) {
	// 	CommonPrefix obj = new CommonPrefix();

	// 	String[] arr = {"geeksforgeeks", "geeks", "geek", "geeze", "geezer", "geeksfor", "geforce"};
	// 	int n = arr.length;

	// 	System.out.println("Result --> " + obj.longestCommonPrefix(arr, n));
		
	// }
	// String longestCommonPrefix(String arr[], int n){
	// 	// code here
	// 	int smallWordLen = -1;
	// 	String prefix = "";
		
	// 	Arrays.sort(arr);
	// 	smallWordLen = arr[0].length();
		
	// 	comPrefixIndex(arr, n, 0, smallWordLen);
		
	// 	if(index == -1) {
	// 		prefix = "-1";
	// 	} else {
	// 		index++;
	// 		prefix = arr[0].substring(0, index);
	// 	}
		
	// 	return prefix;
	// }
		
	// void comPrefixIndex(String[] arr, int n, int x, int smallWordLen) {
	// 	for(int i = 1; i < n; i++) {
	// 		if(arr[0].charAt(x) != arr[i].charAt(x)) {
	// 			index = x-1;
	// 			return;
	// 		}
	// 	}
	// 	if(x >= smallWordLen) {
	// 		index = x;
	// 		return;
	// 	}
	// 	comPrefixIndex(arr, n, x+1, smallWordLen);
		
	// }




}