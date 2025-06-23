package com.cdac.tester;

import java.sql.Date;
import java.util.Scanner;

import com.cdac.dao.FlightDao;
import com.cdac.dao.FlightDaoImpl;

public class TestLayeredCRUDApp {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// init phase - create dao instance
			FlightDao flightDao=new FlightDaoImpl();
			boolean exit = false;
			while (!exit) {
				// client servicing phase
				System.out.println("Options 1. Display Available flights"
						+ "  0. Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter src , dest , departure date(yr-mon-day)");
						System.out.println("Available Flights -");
						flightDao.getAvailableFlights(sc.next(), sc.next(), Date.valueOf(sc.next()))
						.forEach(System.out::println);// flight -> System.out.println(flight)
						break;
								case 0: // shut down (destroy)
						exit = true;
						flightDao.cleanUp();
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
