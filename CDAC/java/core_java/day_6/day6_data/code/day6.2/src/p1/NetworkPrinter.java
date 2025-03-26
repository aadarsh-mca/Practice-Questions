package p1;

public class NetworkPrinter implements Printer{
 @Override
 public void  print(String mesg)
 {
	 System.out.println("Sending a mesg to the server - "+mesg);
	 /*
	  * Can implementation class directly use i/f constant : YES
	  * Non imple classes - have to access - InterfaceName.dataMember
	  */
	 System.out.println(SPEED);
 }
 //establish connection
 public void establishConnection(String remoteHost)
 {
	 System.out.println("establishing connection to the remote host "+remoteHost);
 }
 public void closeConnection(String remoteHost)
 {
		System.out.println("closing connection to the remote host "+remoteHost);
 }
}
