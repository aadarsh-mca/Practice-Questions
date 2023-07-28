class MaxSumPath {

    static int[] arr1; 
    static int[] arr2;
    static int n1, n2;

    public static void main(String[] args) {
        int[] ar1 = {1,2,3,4,5,6};   // 2,3,7,10,12   1,2,3,4,5,6   1,2,3,4,5,6
        int[] ar2 = {3,5,6,4};       // 1,5,7,8       6,7,8,9       3,5,6,4

        arr1 = ar1;
        arr2 = ar2;
        n1 = ar1.length;
        n2 = ar2.length;

        int sum1 = findSum(0, 1, 0);
        int sum2 = findSum(0, 2, 0);
        
        // if(sum1 >= sum2) {
            System.out.println("sum 1 : " + sum1);
        // } else {
            System.out.println("sum 2 : " + sum2);
        // }

    }

    static int findSum(int i, int route, int sum) {
        if(route == 1) {
            if(i >= n1) {
                return sum;
            }
        } else {
            if(i >= n2) {
                return sum;
            }
        }
        
        
        if(route == 1) {
            sum += arr1[i];
            // if(i < n2) {
                for(int j=0; j < n2; j++) {
                    if(arr1[i] == arr2[j]) {
                        route = 2;
                        i = j;
                        break;
                    }
                }
            // }
            i++;
            sum = findSum(i, route, sum);
        } else if(route == 2) {
            sum += arr2[i];
            // if(i < n1) {
                for(int j=0; j < n1; j++) {
                    if(arr2[i] == arr1[j]) {
                        route = 1;
                        i = j;
                        break;
                    }
                }
            // }
            i++;
            sum = findSum(i, route, sum);
        }
        
        return sum;        
    }



}