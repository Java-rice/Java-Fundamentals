import java.util.Scanner;

public class GWAcalculator {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Primitive Data Type
		char Gender, userChoice;
		boolean userAction = false;
		
		//Non-primitive Data Type
		String userName, userCourse, userGender;

		//User Input and Output
		System.out.print("Enter your Name: ");
		userName = input.nextLine();
		System.out.print("Enter your Gender ('M'/'F'): ");
		Gender = input.next().charAt(0);
		input.nextLine();
		System.out.print("Enter your Course: ");
		userCourse = input.nextLine();
		
		//If Else statement
		if (Gender == 'M') {
			userGender = "Male";
		}else if(Gender == 'F') {
			userGender = "Female";
		}else {
			userGender = "Unknown";
		}
		
		System.out.println("Hello " + userName + "!!");
		System.out.println("Gender: " + userGender);
		System.out.println("Course: " + userCourse);
		
		//do..while
		do {
			System.out.println("----------------------------------------------------------------");
			System.out.println("Hello " + userName + "!!");
			System.out.println("Gender: " + userGender);
			System.out.println("Course: " + userCourse);
            System.out.println("\nWhat do you want to do: \nA. Arithmetic Calculator\nB. GWA Calculator\nC. Even or Odd \nD. Exit");
            System.out.print("Your Choice: ");
            userChoice = input.next().charAt(0);
            
            if (userChoice == 'A' || userChoice == 'B' || userChoice == 'C') {
                switch(userChoice){
                	case 'A':
                		
                	case 'B':
                		
                	case 'C':
                		
                }
            } else if (userChoice == 'D') {
                userAction = true;
                break;
            } else {
                System.out.println("\n-----Wrong Input! Try Again-----");
            }
        } while (!userAction);
		
		System.out.println("\n\nThank You! \nProgram Ended!");
	}
}
