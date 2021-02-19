package com.sendemail.presentation;
import java.io.Console;
import java.io.IOException;
import java.util.Scanner;
import com.sendemail.business.SendEmail;

public class WriteEmail {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SendEmail sendEmail = new SendEmail();
		System.out.println("Welcome");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter your email address: ");
		String emailAddress = sc.nextLine(); //read input till enter
		
		System.out.println("Now email To: ");
		String to = sc.nextLine();
		
		System.out.println("What about the Subject: ");
		String subject = sc.nextLine();
		
		System.out.println("Finally write your email/letter: ");
		String text = sc.nextLine();
		
		System.out.println("From: " + emailAddress);
		System.out.println("To: " + to);
		System.out.println("Subject: " + subject);
		System.out.println("Text: " + text);
		String pass = "";
        Console console =  System.console();
        if (console == null) { //BUG IN IDEs console from .readPassword
             System.out.println("Parece que estas usando un IDE asi que cuando escribas la contraseña SERÁ visible: ");
             pass = sc.nextLine();
             sc.close();
        }
	        else { //Outside Eclipse IDE
             pass = new String(console.readPassword("Password: "));
	        } 
		sc.close();
		
		try {
			sendEmail.send(emailAddress, to, subject, text, pass);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}

}
