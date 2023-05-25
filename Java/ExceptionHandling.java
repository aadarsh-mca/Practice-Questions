class ExceptionHandling {
    public static void main(String[] args) {
        try {
            int a = 10/0;
            System.out.println(a);
        } catch (Throwable e) {
            // ArithmeticException ae;
            // if(e == ae) {
                
            // }
            System.out.println(e.getMessage());
        }
    }    
}
