import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;

public class Test1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // int n = scan.nextInt();
        // for(int i=n; i>0; i--) {
        //     int temp = i;
            
        // }


        // int mark1 = scan.nextInt();
        // int mark2 = scan.nextInt();
        // int mark3 = scan.nextInt();
        // System.out.println("Smallest Number is " + (Math.min(Math.min(mark1, mark2), mark3)));



        // AWTExample1 awt = new AWTExample1();

        // Frame f = new Frame();
        // f.setVisible(true);

        JFrame jF = new JFrame();
        jF.setVisible(true);
        jF.setSize(400, 200);

        jF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        

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
