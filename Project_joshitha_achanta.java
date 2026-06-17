import java.util.*;
import java.io.*;

public class Project_joshitha_achanta {
    public static void main(String[] args) {
        // Structure that automatically adjusts to accommodate number of objects (Step 2)
        ArrayList<Policy> policyList = new ArrayList<>();
        
        int smokerCount = 0;
        int nonSmokerCount = 0;

        try {
            // Read information from the text file (Step 2)
            File file = new File("PolicyInformation.txt");
            Scanner fileInput = new Scanner(file);

            while (fileInput.hasNext()) {
                // Read the fields in the exact order specified in the instructions
                String pNum = fileInput.nextLine();
                String pName = fileInput.nextLine();
                String first = fileInput.nextLine();
                String last = fileInput.nextLine();
                int userAge = Integer.parseInt(fileInput.nextLine());
                String status = fileInput.nextLine();
                double userHeight = Double.parseDouble(fileInput.nextLine());
                double userWeight = Double.parseDouble(fileInput.nextLine());

                // Create Policy object and add to ArrayList
                Policy currentPolicy = new Policy(pNum, pName, first, last, userAge, status, userHeight, userWeight);
                policyList.add(currentPolicy);
            }
            fileInput.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: PolicyInformation.txt not found. Please ensure the file is in the correct folder.");
            return; // Exit program if file is missing
        } catch (NumberFormatException e) {
            System.out.println("Error: File contains invalid numeric data.");
            return;
        }

        // Display information for each policy (Step 3)
        for (Policy p : policyList) {
            System.out.println("Policy Number: " + p.getPolicyNumber());
            System.out.println("Provider Name: " + p.getProviderName());
            System.out.println("Policyholder's First Name: " + p.getFirstName());
            System.out.println("Policyholder's Last Name: " + p.getLastName());
            System.out.println("Policyholder's Age: " + p.getAge());
            System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + p.getSmokingStatus());
            System.out.println("Policyholder's Height: " + p.getHeight() + " inches");
            System.out.println("Policyholder's Weight: " + p.getWeight() + " pounds");
            System.out.printf("Policyholder's BMI: %.2f\n", p.calculateBMI());
            System.out.printf("Policy Price: $%.2f\n", p.calculatePrice());
            System.out.println(); // Blank line for spacing

            // Track smokers vs non-smokers (Step 4)
            if (p.getSmokingStatus().equalsIgnoreCase("smoker")) {
                smokerCount++;
            } else {
                nonSmokerCount++;
            }
        }

        // Final totals (Step 4)
        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
    }
}
