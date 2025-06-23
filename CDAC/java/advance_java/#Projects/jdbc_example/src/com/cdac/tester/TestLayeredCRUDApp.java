package com.cdac.tester;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Scanner;

import com.cdac.dao.BankDao;
import com.cdac.dao.BankDaoImpl;
import com.cdac.dao.FlightDao;
import com.cdac.dao.FlightDaoImpl;
import com.cdac.dao.UserDao;
import com.cdac.dao.UserDaoImpl;
import com.cdac.pojos.Flight;
import com.cdac.pojos.User;

public class TestLayeredCRUDApp {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// init phase - create dao instance
			
			UserDao userDao = new UserDaoImpl();
			FlightDao flightDao = new FlightDaoImpl();
			BankDao bankDao = new BankDaoImpl();
			
			boolean exit = false;
			while (!exit) {
				// client servicing phase
				System.out.println("Options :: "
						+ "\n1. Display all users "
						+ "\n2. Sign In  "
						+ "\n3. Sign Up "
						+ "\n\t4. All Flights"
						+ "\n\t5. Search Flights"
						+ "\n\t6. Update Flights"
						+ "\n\t7. Delete Flights"
						+ "\n\t8. Flight DB Extra Feature"
						+ "\n9. Bank DB Extra Feature"
						+ "\n10. Show All Accuonts"
						+ "\n11. Transfer Fund Procedure"
						+ "\n12. Transfer Fund Function"
						+ "\n0. Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("All users -");
						userDao.getAllUsers().forEach(System.out::println);// user -> System.out.println(user)
						break;
					case 2:
						System.out.println("Enter email n pwd for sign in");
						System.out.println(userDao.signIn(sc.next(), sc.next()));
						break;
					case 3:
						System.out.println("Enter firstName,  lastName,email ,pwd,   dob for sign up");
						// create instance of user (voter)
						User voter = new User(sc.next(), sc.next(), sc.next(), sc.next(), Date.valueOf(sc.next()));
						System.out.println(userDao.signUp(voter));
						break;

					case 4:
						flightDao.getAllFlights().forEach(System.out::println);
						break;
						
					case 5:
						System.out.println("Enter Source, Destination, Departure-Date :: ");
						List<Flight> availableFlights = flightDao.getAvailableFlights(sc.next(), sc.next(), Date.valueOf(sc.next()));
						availableFlights.forEach(System.out::println);
						break;
						
					case 6:
						System.out.println("Enter the flight ID, No of Stops, Arrival Time :: ");
						int updatedRowCount = flightDao.updateFlightData(sc.nextInt(), sc.nextInt(), Time.valueOf(sc.next()));
						
						if(updatedRowCount == 1) {
							System.out.println("====== [ Update Successful ] ======");
						} else {
							System.out.println("====== [ Update Failed !!! ] ======");
						}
						break;
						
					case 7:
						System.out.println("Enter Airline, Source, Destination :: ");
						sc.nextLine();
						String airline = sc.nextLine();
						String source = sc.nextLine();
						String destination = sc.nextLine();
						int deletedRowCount = flightDao.deleteFlight(airline, source, destination);
						
						if(deletedRowCount >= 1) {
							System.out.println("====== [ Delete Successful ] ======");
						} else {
							System.out.println("====== [ Delete Failed ] ======");
						}
						
						break;
						
					case 8:
						System.out.println("\n\t1. Toggle AutoCommit "
								+ "\n\t2. Rollback");
						switch(sc.nextInt()) {
						case 1:
							flightDao.toggleAutoCommit();
							break;
						case 2:
							flightDao.callRollback();
							break;
						}
						break;
						
					case 9:
						System.out.println(""
								+ "\t1. Toggle AutoCommit "
								+ "\n\t2. Commit"
								+ "\n\t3. Rollback");
						switch(sc.nextInt()) {
						case 1:
							bankDao.toggleAutoCommit();
							break;
						case 2:
							bankDao.commit();
							break;
						case 3:
							bankDao.callRollback();
							break;
						}
						break;
						
					case 10:
						bankDao.getAllAccount().forEach(System.out::println);
						break;
						
					case 11: {
						System.out.println("Enter the Source A/C No.,  Destination A/C No.,  Amount");
						int srcAcc = sc.nextInt();
						int destAcc = sc.nextInt();
						int amt = sc.nextInt();
						
						bankDao.callTransferFund_procedure(srcAcc, destAcc, amt);
						break;

					}
					case 12: {
						System.out.println("Enter the Source A/C No.,  Destination A/C No.,  Amount");
						int srcAcc = sc.nextInt();
						int destAcc = sc.nextInt();
						int amt = sc.nextInt();
						
						double receiverBankBalance = bankDao.callTransferFund_function(srcAcc, destAcc, amt);
						System.out.println("Receiver Bank Balance :: " + receiverBankBalance);
						break;
					}
					case 0: // shut down (destroy)
						exit = true;
						userDao.cleanUp();
						flightDao.cleanUp();
						bankDao.cleanUp();
						break;
					}
				} catch (Exception e) {
					System.out.println(e);
					sc.nextLine();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
