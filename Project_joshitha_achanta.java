import java.util.Scanner;

public class Project_joshitha_achanta { 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // getting all the info from user
        System.out.print("Please enter the Policy Number: ");
        String pNum = input.nextLine();

        System.out.print("Please enter the Provider Name: ");
        String pName = input.nextLine();

        System.out.print("Please enter the Policyholder’s First Name: ");
        String first = input.nextLine();

        System.out.print("Please enter the Policyholder’s Last Name: ");
        String last = input.nextLine();

        System.out.print("Please enter the Policyholder’s Age: ");
        int userAge = input.nextInt();
        input.nextLine(); // clear the buffer

        System.out.print("Please enter the Policyholder’s Smoking Status (smoker/non-smoker): ");
        String status = input.nextLine();

        System.out.print("Please enter the Policyholder’s Height (in inches): ");
        double userHeight = input.nextDouble();

        System.out.print("Please enter the Policyholder’s Weight (in pounds): ");
        double userWeight = input.nextDouble();

        // make the policy object
        Policy myPolicy = new Policy(pNum, pName, first, last, userAge, status, userHeight, userWeight);

        // print everything back out
        System.out.println("\nPolicy Number: " + myPolicy.getPolicyNumber());
        System.out.println("Provider Name: " + myPolicy.getProviderName());
        System.out.println("Policyholder’s First Name: " + myPolicy.getFirstName());
        System.out.println("Policyholder’s Last Name: " + myPolicy.getLastName());
        System.out.println("Policyholder’s Age: " + myPolicy.getAge());
        System.out.println("Policyholder’s Smoking Status: " + myPolicy.getSmokingStatus());
        System.out.println("Policyholder’s Height: " + myPolicy.getHeight() + " inches");
        System.out.println("Policyholder’s Weight: " + myPolicy.getWeight() + " pounds");
        
        // use printf for the decimals
        System.out.printf("Policyholder’s BMI: %.2f\n", myPolicy.calculateBMI());
        System.out.printf("Policy Price: $%.2f\n", myPolicy.calculatePrice());

        input.close();
    }
}