import java.util.*;
import java.io.*;

public class Project_joshitha_achanta {
    public static void main(String[] args) {
        ArrayList<Policy> policyList = new ArrayList<>();
        int smokerCount = 0;
        int nonSmokerCount = 0;

        try (Scanner fileInput = new Scanner(new File("PolicyInformation.txt"))) {
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine().trim();
                
                // IMPORTANT: Skip empty lines between records
                if (line.isEmpty()) {
                    continue; 
                }

                // If we reach here, 'line' is the Policy Number
                String pNum = line;
                String pName = fileInput.nextLine();
                String first = fileInput.nextLine();
                String last = fileInput.nextLine();
                int userAge = Integer.parseInt(fileInput.nextLine().trim());
                String status = fileInput.nextLine();
                double userHeight = Double.parseDouble(fileInput.nextLine().trim());
                double userWeight = Double.parseDouble(fileInput.nextLine().trim());

                PolicyHolder person = new PolicyHolder(first, last, userAge, status, userHeight, userWeight);
                Policy currentPolicy = new Policy(pNum, pName, person);
                policyList.add(currentPolicy);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: PolicyInformation.txt not found.");
            return;
        } catch (NumberFormatException e) {
            System.out.println("Error: File contains invalid numeric data.");
            return;
        } catch (NoSuchElementException e) {
            System.out.println("Error: File ended unexpectedly. Check data formatting.");
            return;
        }

        for (Policy p : policyList) {
            System.out.println(p); 
            System.out.println();

            if (p.getHolder().getSmokingStatus().equalsIgnoreCase("smoker")) {
                smokerCount++;
            } else {
                nonSmokerCount++;
            }
        }

        System.out.println("--------------------------------------------------");
        System.out.println("There were " + Policy.getPolicyCount() + " Policy objects created.");
        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
        System.out.println("--------------------------------------------------");
    }
}
