public class CellReachInGivenTime {
    
    public static void main(String[] args) {
        /**
         * Simple Solution
         * **/
        // int x = fx-sx;
        // int y = fy-sy;
        // int minDist = Math.max(x, y);
        // return t >= minDist;


        isReachableAtTime(2, 4, 7, 7, 6);
        isReachableAtTime(2, 4, 1, 7, 6);
    }

    public static boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        System.out.println("[" + sx + "," + sy + "]");
        System.out.println("Time: " + t);
        while(sx != fx && sy != fy) {
            t--;
            if(sx > fx || sy > fy) {
                sx--;
                sy--;
            } else {
                sx++;
                sy++;
            }
            System.out.println("[" + sx + "," + sy + "]");
            System.out.println("Time: " + t);
        }

        while(sx != fx || sy != fy) {
            if(sx != sy) {
                sx++;
                t--;
            }

            if(sy != fy) {
                sy++;
                t--;
            }
        }

        return t >= 0;
    }

}
