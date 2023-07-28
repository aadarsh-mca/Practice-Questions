class ContiBinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int n = arr.length;
        int key = -21;
        
        int result = binarySearch(arr, n, key, 0, n-1);

        System.out.println(result);
    }

    static int binarySearch(int[] arr, int n, int key, int start, int end) {
        int resultIdx = -1;
        int midIdx = (start + end) / 2;
        
        if(start > end) {  // || start < end
            return resultIdx;
        } 
        
        if(arr[midIdx] == key) {
            resultIdx = midIdx; 
        } else if(arr[midIdx] < key) {
            resultIdx = binarySearch(arr, n, key, midIdx+1, end);
        } else if(arr[midIdx] > key) {
            resultIdx = binarySearch(arr, n, key, 0, midIdx-1);
        }

        return resultIdx;
    }


}