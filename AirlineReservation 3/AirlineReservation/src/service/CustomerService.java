package service;

import java.util.Scanner;

import dao.PassengerDao;

public class CustomerService {
	public void getdetails()
	{
		  Scanner s = new Scanner(System.in);
	      System.out.println("**** Enter Details ****");
	 	  System.out.print("Passenger Name: ");
	      String name = s.nextLine();
	      System.out.print("Passenger Mobile: ");
	      String mobile = s.nextLine();
	      System.out.print("Passenger Address: ");
	      String address = s.nextLine();
	      System.out.print("Password: ");
	      String password = s.nextLine();
	      PassengerDao passengerdao = new PassengerDao();
	      passengerdao.insertPassenger(name, mobile, address, password);
	}
}

