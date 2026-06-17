/**
 * The Policy class represents an insurance policy for an individual.
 * It contains personal data about the policyholder and provides 
 * methods to calculate BMI and the overall insurance price.
 */
public class Policy {
    private String policyNum;
    private String provider;
    private String fName;
    private String lName;
    private int age;
    private String smokerStatus;
    private double height;
    private double weight;

    /**
     * Default constructor. 
     * Initializes a Policy object with default empty strings and zero values.
     */
    public Policy() {
        policyNum = "";
        provider = "";
        fName = "";
        lName = "";
        age = 0;
        smokerStatus = "non-smoker";
        height = 0.0;
        weight = 0.0;
    }

    /**
     * Parameterized constructor used to initialize a Policy object with specific data.
     * 
     * @param pNum   The policy identification number.
     * @param prov   The name of the insurance provider.
     * @param fn     The first name of the policyholder.
     * @param ln     The last name of the policyholder.
     * @param a      The age of the policyholder.
     * @param status The smoking status (either "smoker" or "non-smoker").
     * @param h      The height of the policyholder in inches.
     * @param w      The weight of the policyholder in pounds.
     */
    public Policy(String pNum, String prov, String fn, String ln, int a, String status, double h, double w) {
        policyNum = pNum;
        provider = prov;
        fName = fn;
        lName = ln;
        age = a;
        smokerStatus = status;
        height = h;
        weight = w;
    }

    /**
     * Retrieves the policy number.
     * @return The string containing the policy number.
     */
    public String getPolicyNumber() { return policyNum; }

    /**
     * Retrieves the name of the insurance provider.
     * @return The string containing the provider's name.
     */
    public String getProviderName() { return provider; }

    /**
     * Retrieves the first name of the policyholder.
     * @return The string containing the first name.
     */
    public String getFirstName() { return fName; }

    /**
     * Retrieves the last name of the policyholder.
     * @return The string containing the last name.
     */
    public String getLastName() { return lName; }

    /**
     * Retrieves the age of the policyholder.
     * @return The integer representing the age.
     */
    public int getAge() { return age; }

    /**
     * Retrieves the smoking status of the policyholder.
     * @return The string status ("smoker" or "non-smoker").
     */
    public String getSmokingStatus() { return smokerStatus; }

    /**
     * Retrieves the height of the policyholder.
     * @return The double value of height in inches.
     */
    public double getHeight() { return height; }

    /**
     * Retrieves the weight of the policyholder.
     * @return The double value of weight in pounds.
     */
    public double getWeight() { return weight; }

    /**
     * Updates the policy number.
     * @param pNum The new policy number to be set.
     */
    public void setPolicyNumber(String pNum) { this.policyNum = pNum; }

    /**
     * Updates the insurance provider name.
     * @param prov The new provider name to be set.
     */
    public void setProviderName(String prov) { this.provider = prov; }

    /**
     * Updates the first name of the policyholder.
     * @param fn The new first name to be set.
     */
    public void setFirstName(String fn) { this.fName = fn; }

    /**
     * Updates the last name of the policyholder.
     * @param ln The new last name to be set.
     */
    public void setLastName(String ln) { this.lName = ln; }

    /**
     * Updates the age of the policyholder.
     * @param a The new age to be set.
     */
    public void setAge(int a) { this.age = a; }

    /**
     * Updates the smoking status of the policyholder.
     * @param s The new status ("smoker" or "non-smoker") to be set.
     */
    public void setSmokingStatus(String s) { this.smokerStatus = s; }

    /**
     * Updates the height of the policyholder.
     * @param h The new height in inches to be set.
     */
    public void setHeight(double h) { this.height = h; }

    /**
     * Updates the weight of the policyholder.
     * @param w The new weight in pounds to be set.
     */
    public void setWeight(double w) { this.weight = w; }

    /**
     * Calculates the Body Mass Index (BMI) using the formula: 
     * (weight * 703) / (height * height).
     * 
     * @return The calculated BMI as a double.
     */
    public double calculateBMI() {
        return (weight * 703) / (height * height);
    }

    /**
     * Calculates the total price of the insurance policy based on 
     * age, smoking status, and BMI.
     * 
     * @return The total price of the insurance policy as a double.
     */
    public double calculatePrice() {
        double total = 600.0; // starting base fee

        if (age > 50) {
            total += 75.0;
        }

        if (smokerStatus.equalsIgnoreCase("smoker")) {
            total += 100.0;
        }

        double currentBmi = calculateBMI();
        if (currentBmi > 35) {
            total += (currentBmi - 35) * 20;
        }

        return total;
    }
}
