import java.util.*;
import java.io.*;

public class Project_joshitha_achanta { 
    public static void main(String[] args) {
        try {
            // Step 2: Read information from PolicyInformation.txt instead of user input
            File file = new File("PolicyInformation.txt");
            Scanner inputFile = new Scanner(file);

            // Store Policy objects in an ArrayList to automatically adjust to file size (Chapter 7)
            ArrayList<Policy> policies = new ArrayList<>();

            while (inputFile.hasNextLine()) {
                // The file contains labels (e.g., "Policy Number: 3450"). 
                // We split the line at the colon ":" and take the data on the right side.
                
                String pNum = inputFile.nextLine().split(":")[1].trim();
                String pName = inputFile.nextLine().split(":")[1].trim();
                String first = inputFile.nextLine().split(":")[1].trim();
                String last = inputFile.nextLine().split(":")[1].trim();
                int userAge = Integer.parseInt(inputFile.nextLine().split(":")[1].trim());
                String status = inputFile.nextLine().split(":")[1].trim();
                
                // Height and Weight contain units (" inches", " pounds") that must be removed
                String hLine = inputFile.nextLine().split(":")[1].trim();
                double userHeight = Double.parseDouble(hLine.replace(" inches", ""));
                
                String wLine = inputFile.nextLine().split(":")[1].trim();
                double userWeight = Double.parseDouble(wLine.replace(" pounds", ""));

                // Consume the blank line between policy records
                if (inputFile.hasNextLine()) {
                    inputFile.nextLine(); 
                }

                // Create the policy object and add it to the ArrayList
                Policy myPolicy = new Policy(pNum, pName, first, last, userAge, status, userHeight, userWeight);
                policies.add(myPolicy);
            }
            inputFile.close();

            // Step 4: Counters for smokers and non-smokers
            int smokerCount = 0;
            int nonSmokerCount = 0;

            // Step 3: Display information for each Policy object by iterating over the ArrayList
            for (Policy p : policies) {
                System.out.println("Policy Number: " + p.getPolicyNumber());
                System.out.println("Provider Name: " + p.getProviderName());
                System.out.println("Policyholder’s First Name: " + p.getFirstName());
                System.out.println("Policyholder’s Last Name: " + p.getLastName());
                System.out.println("Policyholder’s Age: " + p.getAge());
                System.out.println("Policyholder’s Smoking Status: " + p.getSmokingStatus());
                System.out.println("Policyholder’s Height: " + p.getHeight() + " inches");
                System.out.println("Policyholder’s Weight: " + p.getWeight() + " pounds");
                System.out.printf("Policyholder’s BMI: %.2f\n", p.calculateBMI());
                System.out.printf("Policy Price: $%.2f\n", p.calculatePrice());
                System.out.println(); // Space between policies

                // Increment counters for Step 4
                if (p.getSmokingStatus().equalsIgnoreCase("smoker")) {
                    smokerCount++;
                } else {
                    nonSmokerCount++;
                }
            }

            // Final Output for Step 4
            System.out.println("The number of policies with a smoker is: " + smokerCount);
            System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);

        } catch (FileNotFoundException ex) {
            System.out.println("Error: Could not find PolicyInformation.txt. Please ensure it is in the project folder.");
        } catch (Exception ex) {
            System.out.println("An error occurred while processing the file: " + ex.getMessage());
        }
    }
}
