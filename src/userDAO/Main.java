package userDAO;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		UserDAO u = new UserDAO();
		u.menu();
	}
}
