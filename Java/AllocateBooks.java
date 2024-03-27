import java.util.ArrayList;
import java.util.Arrays;

public class AllocateBooks {
    
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(12, 34, 67, 90));
        int nStudents = 2;
        // ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(25,46,28,49,24));
        // int nStudents = 4;
        int n = arr.size();

        System.out.println("Brute : " + brute_getMinPages(arr, n, nStudents));
        System.out.println("Optimal : " + optimal1_getMinPages(arr, n, nStudents));
    }

    /**
     * Brute force approach,
     * 
     * Intution is to : 
     * Iterate over the number of pages to be allocated to each students.
     * 
     * [25, 46, 28, 49, 24]
     *   ⁰   ¹   ²   ³   ⁴
     *               ^   ^
     *             max   min
     * 
     * <p>If we take Minimum numbers of pages need to be alloted as 'min 24',
     * then the book having more than 24 pages cannot be alloted to any student,
     * therefore,
     * Minimum numbers of pages need to be alloted should be 'max 49', 
     * so that any students can take book having pages less than or equal to 49.
     * 
     * <p>If we take minimem number as 'max 49' than, 
     * what should be the maximum number ?
     * 
     * <p>Maximum number will be sum of all pages,
     * because if there is only 1 student present,
     * than we have to allot all book to him,
     * therefore,
     * Maximum numbers of pages need to be alloted should be 'sum 172',
     * 
     * <p>So, the range to search the answer lie between max to sum(pages).
     * 
     * <p>Time Complexity : {@code O((min->max) * n)}, near about n²
     * <p>Space Complexity : {@code O(1)}
     * 
     * @param arr {@code int[]} number of pages each book is having
     * @param nBooks {@code int} number of books
     * @param nStudents {@code int} number of students
     * @return {@code int} minimum number of pages alloted to student
     */
    static int brute_getMinPages(ArrayList<Integer> arr, int nBooks, int nStudents) {
        /**
         * If number of students are more than,
         * number of books,
         * this mean it is impossible to allot atleast one book to each student,
         * Hence, return -1.
         */
        if(nStudents > nBooks) {
            return -1;
        }

        /**
         * Here we are calculating, 
         * sum of total pages and max of all pages.
         * This will decide the range of linear/binary search.
         */
        int totalPages = 0;
        int minPages = arr.get(0);
        for(int pages : arr) {
            totalPages += pages;
            minPages = Math.max(minPages, pages);
        }

        /**
         * If number of books and number of students are equal,
         * that mean each students will have only one book,
         * therefore maximum number of pages, 
         * that each student can have will be max of all pages.
         */
        if(nBooks == nStudents) {
            return minPages;
        }

        /**
         * Performing linear search on the range(max-Page, total-Page),
         */
        int maxPages = totalPages;
        for(int i=minPages; i <= maxPages; i++) {
            int studentsAlloted = getMaxStudentsAlloted(arr, nBooks, i);

            /**
             * As we need the minimum number of pages, 
             * that each student can maximum have will be
             * the first encounter of the following condition.
             */
            if(studentsAlloted == nStudents) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Optimal approach,
     * 
     * Intution is similar to brute force,
     * 
     * <p>The only change is to 
     * perform binary search on the range (max-Page, total-Page),
     * instead of linear search.
     * 
     * <p>Time Complexity : {@code O(log n * n)}
     * <p>Space Complexity : {@code O(1)}
     * 
     * @param arr {@code int[]} number of pages each book is having
     * @param nBooks {@code int} number of books
     * @param nStudents {@code int} number of students
     * @return {@code int} minimum number of pages alloted to student
     */
    static int optimal1_getMinPages(ArrayList<Integer> arr, int nBooks, int nStudents) {
        /**
         * If number of students are more than,
         * number of books,
         * this mean it is impossible to allot atleast one book to each student,
         * Hence, return -1.
         */
        if(nStudents > nBooks) {
            return -1;
        }

        /**
         * Here we are calculating, 
         * sum of total pages and max of all pages.
         * This will decide the range of linear/binary search.
         */
        int totalPages = 0;
        int minPages = arr.get(0);
        for(int pages : arr) {
            totalPages += pages;
            minPages = Math.max(minPages, pages);
        }

        /**
         * If number of books and number of students are equal,
         * that mean each students will have only one book,
         * therefore maximum number of pages, 
         * that each student can have will be max of all pages.
         */
        if(nBooks == nStudents) {
            return minPages;
        }

        /**
         * Performing binary search on the range(max-Page, total-Page).
         */
        int ans = 0;
        int maxPages = totalPages;
        while(minPages <= maxPages) {
            int pagesToBeAlloted = (minPages + maxPages) / 2;

            /**
             * [25, 46, 28, 49, 24] , students = 4
             * 
             *              minPages = 49,      <-------->           sumPages = 172
             * students with 49 pages : 5       <-------->           students with 172 pages : 2 
             * 
             * If studentAlloted is more than required students,
             * that mean we have alloted very less number of pages,
             * we need to increase the number of pages to decrease the number of students.
             * 
             * And, if studentAlloted is less than required students,
             * that mean we have alloted alot number of pages,
             * we need to decrease the number of pages to increase the number of students.
             * 
             * The ans is 71, but 
             * if we allot 72 pages, than also we can allot 4 students,
             * Therefore, if studentsAlloted <= nStudents, 
             * there might be an answer. 
             */
            int studentsAlloted = getMaxStudentsAlloted(arr, nBooks, pagesToBeAlloted);
            if(studentsAlloted <= nStudents) {
                ans = pagesToBeAlloted;
                maxPages = pagesToBeAlloted-1;
            } else {
                minPages = pagesToBeAlloted+1;
            }
        }
        return ans;
    }

    /**
     * Here we calculate the number of students,
     * that will be alloted with specified number of pages.
     * 
     * @param arr {@code int[]} number of pages each book is having
     * @param nBooks {@code int} number of books
     * @param pagesToBeAlloted {@code int} pages to be alloted
     * @return {@code int} number of student
     */
    static int getMaxStudentsAlloted(ArrayList<Integer> arr, int nBooks, int pagesToBeAlloted) {
        int students = 0;
        int pagesAlloted = 0;
        int bookNo = 0;
        while(bookNo < nBooks) {

            /**
             * [25, 46, 28, 49, 24] , ans = 71
             *   ⁰   ¹   ²   ³   ⁴
             * 
             * If (pagesAlloted + next book pages) is less than (pages to be alloted),
             * this mean we can allot this current book pages to current student.
             * 
             * As soon we get the specified number of pages or less,
             * than we can count it for 1 student, 
             * and pageAlloted will reset.
             */
            while(bookNo < nBooks && (pagesAlloted + arr.get(bookNo)) <= pagesToBeAlloted) {
                pagesAlloted += arr.get(bookNo);
                bookNo++;
            }
            students++;
            pagesAlloted = 0;
        }
        return students;
    }
}
