import java.security.NoSuchAlgorithmException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.UUID;
import java.util.Vector;
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

    class Pair {
        public int num;
        public int freq;

        public Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }

    static void SHA256Generator() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
        keyGen.init(256); // key size
        SecretKey secretKey = keyGen.generateKey();
        String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        System.out.println("\nSecret Key: " + encodedKey);
    }

    public static void main(String[] args) throws Exception {
        // SHA256Generator();
        
        int[] arr = new int[10];
        Set<List<Integer>> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>(List.of(1,2,4,5,6,7,8,9));
        ArrayDeque<Integer> que = new ArrayDeque<>();
        Queue<Integer> pQue = new PriorityQueue<>();


        
        System.out.println(list);

        


        // System.out.println(UUID.randomUUID());
        // System.out.println(UUID.nameUUIDFromBytes("example@gmail.com".getBytes()));
        // System.out.println(UUID.randomUUID().toString());
        // System.out.println(UUID.nameUUIDFromBytes("test@gmail.com".getBytes()).toString());
        // System.out.println(UUID.nameUUIDFromBytes("test123@gmail.com".getBytes()).toString());
    }



    public static int[] nearlySorted(int[] array, int n, int k) {
        // Write your code here.
        PriorityQueue<Integer> pQue = new PriorityQueue<>();

        int i=0;
        while(i <= k) {
            pQue.offer(array[i]);
            i++;
        }

        while(i < n) {
            array[i-k-1] = pQue.poll();
            pQue.offer(array[i]);
            i++;
        }

        while(pQue.isEmpty() == false) {
            array[i-k-1] = pQue.poll();
            i++;
        }

        return array;
  }







    


    





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

