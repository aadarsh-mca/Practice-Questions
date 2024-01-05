public class Pattern {
    public static void main(String[] args) {
        Pattern obj = new Pattern();

        
        // obj.numberPattern_13(4);
        // letterPattern_14(4);
        // revLetterPattern_15(4);
        // obj.letterPattern_16(4);
        letterHill_17(4);
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

}
