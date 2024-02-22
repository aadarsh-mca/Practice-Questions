public class Pattern {
    public static void main(String[] args) {

        Singleton singletonClass = Singleton.getInstance();
        System.out.println("from test : " + singletonClass);

        
        // obj.numberPattern_13(4);
        // letterPattern_14(4);
        // revLetterPattern_15(4);
        // obj.letterPattern_16(4);
        // letterHill_17(4);
        // revLetterHill_17(4);
        // symmetricStar(3);
        // crossPatt(3);
        // squareStar(4);
        // squareNumber(5);

    }


    /** 13)
     *      1
     *      2 3
     *      4 5 6
     * **/
    void numberPattern_13(int n) {
        int num = 1;
        for(int i=1; i<=n; i++) {
            for(int j=0; j<i; j++) {
                System.out.print(num++ + " ");
            }
            System.out.println();
        }
    }


    /** 14)
     *      A
     *      A B
     *      A B C
     * **/
    static void letterPattern_14(int n) {
        for(int i=1; i<=n; i++) {
            char letter = 'A';
            // int num = 65;
            for(int j=1; j<=i; j++) {
                System.out.print(letter++ + " ");
                // System.out.print((char) num++ + " ");
            }
            System.out.println();
        }
    }
    
    
    /** 15)
     *      A B C
     *      A B
     *      A
     * **/
    static void revLetterPattern_15(int n) {
        for(int i=n; i>=1; i--) {
            char letter = 'A';
            // int num = 65;
            for(int j=1; j<=i; j++) {
                System.out.print(letter++ + " ");
                // System.out.print((char) num++ + " ");
            }
            System.out.println();
        }
    }
    
    
    /** 16)
     *      A 
     *      B B
     *      C C C
     * **/
    void letterPattern_16(int n) {
        char letter = 'A';
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                // int letter = 64 + i;
                System.out.print(letter + " ");
                // System.out.print((char) letter + " ");
            }
            letter++;
            System.out.println();
        }
    }


    /** 17)
     *         A 
     *       A B A
     *     A B C B A
     * **/
    static void letterHill_17(int n) {
        int max = n*2-1;
        for(int i=1; i<=n; i++) {
            char letter = 'A';
            int nLetter = (i*2-1);
            int nSpace = max - nLetter;

            for(int j=1; j<=(nSpace/2); j++) {
                System.out.print(" ");
            }
            for(int j=1; j<=(nLetter/2); j++) {
                System.out.print(letter++ + " ");
            }
            nLetter -= (nLetter/2);
            while(nLetter >= 1) {
                System.out.print(letter-- + " ");
                nLetter--;
            }
            System.out.println();
        }
    }

    /** 18)
     *      C 
     *      C B
     *      C B A
     *  65 A
        66 B
        67 C
        68 D
        69 E
     * **/
    static void revLetterHill_17(int n) {
        int charInt = 65+n;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                char ch = (char)(charInt-j);
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
    
    /** 18, Part 1)
     * 
     * D
     * C D
     * B C D
     * A B C D
     * 
     * **/



    /** 19)
     * 
     *   * * * * * *
     *   * *     * *
     *   *         *
     *   *         *
     *   * *     * *
     *   * * * * * *
     * 
     * **/
     
    static void symmetricStar(int n) {
    n*=2;
    // For loop 'i (row)' in range 0 to N-1.
    for(int i=0; i<n; i++) {
        // For loop 'j (col)' in range 0 to N-1.
        for(int j=0; j<n; j++) {
            // Condition for first half of the i (rows).
            if(i < n/2 && (j < (n/2 - i) || j >= (n/2 + i))) {
                System.out.print('*');
            }
            // Condition for the second half of the is.
            else if(i >= n/2 && (j <= (i-n/2) || j >= (n-i+n/2-1))) {
                System.out.print('*');
            }
            else {
                System.out.print(' ');
            }
            System.out.print(' ');
        }
        System.out.println();
    }

    // int totalSpaces = n*2;

    // for(int i=1; i<=n; i++) {
    //     int nStars = (n-i+1);
    //     int nSpaces = totalSpaces - (2*nStars);

    //     /// for printing 1st set of nStars
    //     for(int j=1; j<=nStars; j++) {
    //         System.out.print("* ");
    //     }
    //     /// for printing nSpaces
    //     for(int j=1; j<=nSpaces; j++) {
    //         System.out.print("  ");
    //     }
    //     /// for printing 2nd set of nStars
    //     for(int j=1; j<=nStars; j++) {
    //         System.out.print("* ");
    //     }

    //     System.out.println();
    // }
    // for(int i=1; i<=n; i++) {
    //     int nStars = i;
    //     int nSpaces = totalSpaces - (2*nStars);

    //     /// for printing 1st set of nStars
    //     for(int j=1; j<=nStars; j++) {
    //         System.out.print("* ");
    //     }
    //     /// for printing nSpaces
    //     for(int j=1; j<=nSpaces; j++) {
    //         System.out.print("  ");
    //     }
    //     /// for printing 2nd set of nStars
    //     for(int j=1; j<=nStars; j++) {
    //         System.out.print("* ");
    //     }

    //     System.out.println();
    // }
    }

    /** 20)
     * 
     *   *         *
     *   * *     * *
     *   * * * * * *
     *   * *     * *
     *   *         *
     * 
     * **/
    
    static void crossPatt(int n) {
        int nRows = n*2-1;
        int nCols = n*2;
        for(int i=1; i<=nRows; i++) {
            int nStars = i <= nRows/2+1 ? i : nRows-i+1;
            int nSpaces = 2*(nCols/2 - nStars);

            for(int j=1; j<=nStars; j++) {
                System.out.print("* ");
            }
            for(int j=1; j<=nSpaces; j++) {
                System.out.print("  ");
            }
            for(int j=1; j<=nStars; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    /** 21)
     * 
     *   *****
     *   *   *
     *   *   *
     *   *   *
     *   *****
     * 
     * **/

    static void squareStar(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i==1 || i==n || j==1 || j==n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    /** 22)
     * 
     *   4 4 4 4 4 4 4
     *   4 3 3 3 3 3 4
     *   4 3 2 2 2 3 4
     *   4 3 2 1 2 3 4
     *   4 3 2 2 2 3 4
     *   4 3 3 3 3 3 4
     *   4 4 4 4 4 4 4
     * 
     * **/

    static void squareNumber(int n) {
        for(int i=1; i<=n*2-1; i++) {
            int num = n+1;
            for(int j=1; j<=n*2-1; j++) {
                int top = i;
                int left = j;
                int bottom = n*2-i;
                int right = n*2-j;

                int min = Math.min(top, left);
                min = Math.min(min, bottom);
                min = Math.min(min, right);

                // System.out.print(num-min);
                System.out.print(num - Math.min((Math.min(left, top)), (Math.min(right, bottom))));
            }
            System.out.println();
        }
    }

}
