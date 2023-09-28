import java.util.Scanner;

public class GWAcalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Primitive Data Type
        char Gender, userChoice;
        boolean userAction = false;
        float numGrade;
        float grResult = 0;
        double result = 0;
        int numSubject;

        // Non-primitive Data Type
        String userName, userCourse, userGender, solveExpression;
        

        // User Input and Output
        System.out.print("Enter your Name: ");
        userName = input.nextLine();
        System.out.print("Enter your Gender ('M'/'F'): ");
        Gender = input.next().charAt(0);
        input.nextLine();
        System.out.print("Enter your Course: ");
        userCourse = input.nextLine();

        // If Else statement
        if (Gender == 'M') {
            userGender = "Male";
        } else if (Gender == 'F') {
            userGender = "Female";
        } else {
            userGender = "Unknown";
        }

        System.out.println("Hello " + userName + "!!");
        System.out.println("Gender: " + userGender);
        System.out.println("Course: " + userCourse);

        // do..while
        do {
            System.out.println("----------------------------------------------------------------");
            System.out.println("Hello " + userName + "!!");
            System.out.println("Gender: " + userGender);
            System.out.println("Course: " + userCourse);
            System.out.println("\nWhat do you want to do: \nA. Simple Arithmetic Calculator\nB. GWA Calculator\nC. Exit");
            System.out.print("Your Choice: ");
            userChoice = input.next().charAt(0);

            // if
            if (userChoice == 'A' || userChoice == 'B') {
                // switch
                switch (userChoice) {
                    case 'A':
                    	input.nextLine(); // Consume the newline character
                        // while loop with break
                        while (true) {
                            System.out.println("\nEnter a series of numbers and operations (e.g., 5 * 3 + 2 - 1 / 4) or 'x' to cancel:");
                            solveExpression = input.nextLine();

                            if (solveExpression.equalsIgnoreCase("x")) {
                                break;
                            }

                            try {
                                result = calExpression(result, solveExpression);
                                System.out.println("Answer: " + result);
                            } catch (IllegalArgumentException e) {
                                System.out.println("Invalid input. Try again.");
                            }
                        }

                    case 'B':
                        System.out.println("---GWA calculator---");
                        input.nextLine();
                        while (true) {
                        	System.out.println("Enter the number of subjects: ");
                        	numSubject = input.nextInt();
                        	numGrade = calGWA(grResult, numSubject);
                        	
                        }
                }
            } else if (userChoice == 'C') {
                userAction = true;
                break;
            } else {
                System.out.println("\n-----Wrong Input! Try Again-----");
            }
        } while (!userAction);

        System.out.println("\n\nThank You! \nProgram Ended!");
        input.close();
    }

    private static Double calExpression(double solResult, String inputExp) {
        String[] parts = inputExp.split(" ");
        double integer = Double.parseDouble(parts[0]);
        solResult = integer;
        String operations = "";

        for (int i = 1; i < parts.length; i += 2) {
            operations = parts[i];
            double nextNum = Double.parseDouble(parts[i + 1]);

            switch (operations) {
                case "+":
                    solResult += nextNum;
                    break;
                case "-":
                    solResult -= nextNum;
                    break;
                case "*":
                    solResult *= nextNum;
                    break;
                case "/":
                    if (nextNum != 0) {
                        solResult /= nextNum;
                    } else {
                        throw new IllegalArgumentException("Division by zero is not allowed.");
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operator: " + operations);
            }
        }
        return solResult;
    }
    
    private static float calGWA(float result, int num) {
    	float grade;
    	
    	for(int i = 0; i < num; i++) {
    		
    	}
    	return result;
    }
}
