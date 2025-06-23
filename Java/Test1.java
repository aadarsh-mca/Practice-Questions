import java.security.NoSuchAlgorithmException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.JFrame;

import DSA.PQueue;

interface IDbFunction {
    void insert();
    void update();
    void delete();
}

interface IFileFunction {
    void open();
    void close();
    void delete();
}

class IFunctions implements IDbFunction, IFileFunction {
    @Override
    public void insert() {
        System.out.println("IDbFunction -- .insert()");
    }
    
    @Override
    public void update() {
        System.out.println("IDbFunction -- .update()");
    }
    
    // =============================

    @Override
    public void open() {
        System.out.println("IFileFunction -- .open()");
    }
    
    @Override
    public void close() {
        System.out.println("IFileFunction -- .close()");
    }

    // =============================
    
    @Override
    public void delete() {
        System.out.println("IDbFunction -- .delete()");
    }
}

public class Test1 {

    static void SHA256Generator() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
        keyGen.init(256); // key size
        SecretKey secretKey = keyGen.generateKey();
        String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        System.out.println("\nSecret Key: " + encodedKey);
    }

    public static void main(String[] args) throws Exception {
        // SHA256Generator();
        
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> pQue = new PriorityQueue<>((a, b) -> b-a);

        // pQue.add(1);
        // pQue.add(10);
        // pQue.add(20);
        // pQue.add(15);
        // pQue.add(2);
        // pQue.add(12);
        // pQue.add(14);

        // System.out.println("initial : " + pQue);
        
        // System.out.println(pQue.remove());
        // System.out.println(pQue.remove());
        // System.out.println(pQue.remove());
        // System.out.println("after remove() : " + pQue);
        
        // pQue.add(16);
        // System.out.println(pQue.remove());
        // pQue.add(21);

        // System.out.println("after add/remove : " + pQue);
        
        // System.out.println("===================================");

        // PQueue pQueue = new PQueue();
        // pQueue.add(1);
        // pQueue.add(10);
        // pQueue.add(20);
        // pQueue.add(15);
        // pQueue.add(2);
        // pQueue.add(12);
        // pQueue.add(14);

        // System.out.println("initial : " + pQueue); 

        // System.out.println(pQueue.remove());
        // System.out.println(pQueue.remove());
        // System.out.println(pQueue.remove());
        // System.out.println("after remove() : " + pQueue);
        
        // pQueue.add(16);
        // System.out.println(pQueue.remove());
        // pQueue.add(21);

        // System.out.println("after add/remove : " + pQueue);




        

        int[] arr = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9};
        int n = arr.length;
        int k = 3;

        System.out.println("is min heap : " + isHeap(arr, n, 0));

        System.out.println("before conversion : " + Arrays.toString(arr));
        
        PQueue.toMaxHeap(arr);  // 30, 21, 23, 10, 20

        System.out.println("after conversion : " + Arrays.toString(arr));



        // System.out.println(UUID.randomUUID());
        // System.out.println(UUID.nameUUIDFromBytes("example@gmail.com".getBytes()));
        // System.out.println(UUID.randomUUID().toString());
        // System.out.println(UUID.nameUUIDFromBytes("test@gmail.com".getBytes()).toString());
        // System.out.println(UUID.nameUUIDFromBytes("test123@gmail.com".getBytes()).toString());
    }


    private static boolean isHeap(int[] nums, int n, int parent) {
        if(parent >= n) {
            return true;
        }

        int left = 2 * parent + 1;
        int right = 2 * parent + 2;

        if(left < n && nums[parent] > nums[left]) {
            return false;
        }
        if(right < n && nums[parent] > nums[right]) {
            return false;
        }
        
        if(isHeap(nums, n, left) == false) {
            return false;
        }
        if(isHeap(nums, n, right) == false) {
            return false;
        }

        return true;
    }

    // private static boolean checkHeap() {

    // }








    


    





}



// class AWTExample1 extends Frame {    
  
//     // initializing using constructor  
//     AWTExample1() {  
   
//        // creating a button   
//        Button b = new Button("Click Me!!");  
   
//        // setting button position on screen  
//        b.setBounds(30,100,80,30);  
   
//        // adding button into frame    
//        add(b);  
   
//        // frame size 300 width and 300 height    
//        setSize(300,300);  
   
//        // setting the title of Frame  
//        setTitle("This is our basic AWT example");   
           
//        // no layout manager   
//        setLayout(null);   
   
//        // now frame will be visible, by default it is not visible    
//        setVisible(true);  

//         b.addMouseListener(new MouseListener() {
//             public void mouseClicked(MouseEvent e) {
//                 dispose();
//             }
            
//             public void mousePressed(MouseEvent e) {
//                 System.out.println("Pressed !!!!");
//             }
            
//             public void mouseReleased(MouseEvent e) {
//                 System.out.println("Released !!!!");
//             }

//             public void mouseEntered(MouseEvent e) {
//                 System.out.println("Entered ------>");
//             }
            
//             public void mouseExited(MouseEvent e) {
//                 System.out.println("Exited ------>");
//             }
//         });

//     } 
// }

