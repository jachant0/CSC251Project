/**
 * The Policy class manages insurance policy information, 
 * including the policyholder's health data and pricing.
 */
public class Policy {
    // attributes for the policy
    private String policyNum;
    private String provider;
    private String fName;
    private String lName;
    private int age;
    private String smokerStatus; 
    private double height;        
    private double weight;        

    /**
     * Default constructor initializes a Policy with empty/default values.
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
     * Constructor to initialize a Policy with specific values.
     * @param pNum The policy number.
     * @param prov The provider name.
     * @param fn The first name of the policyholder.
     * @param ln The last name of the policyholder.
     * @param a The age of the policyholder.
     * @param status The smoking status (smoker/non-smoker).
     * @param h The height in inches.
     * @param w The weight in pounds.
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
     * Gets the policy number.
     * @return The policy number as a String.
     */
    public String getPolicyNumber() { return policyNum; }

    /**
     * Gets the provider name.
     * @return The name of the insurance provider.
     */
    public String getProviderName() { return provider; }

    /**
     * Gets the policyholder's first name.
     * @return The first name.
     */
    public String getFirstName() { return fName; }

    /**
     * Gets the policyholder's last name.
     * @return The last name.
     */
    public String getLastName() { return lName; }

    /**
     * Gets the age of the policyholder.
     * @return The age.
     */
    public int getAge() { return age; }

    /**
     * Gets the smoking status.
     * @return "smoker" or "non-smoker".
     */
    public String getSmokingStatus() { return smokerStatus; }

    /**
     * Gets the height in inches.
     * @return The height.
     */
    public double getHeight() { return height; }

    /**
     * Gets the weight in pounds.
     * @return The weight.
     */
    public double getWeight() { return weight; }

    /**
     * Sets the policy number.
     * @param pNum The new policy number.
     */
    public void setPolicyNumber(String pNum) { this.policyNum = pNum; }

    /**
     * Sets the provider name.
     * @param prov The new provider name.
     */
    public void setProviderName(String prov) { this.provider = prov; }

    /**
     * Sets the first name.
     * @param fn The new first name.
     */
    public void setFirstName(String fn) { this.fName = fn; }

    /**
     * Sets the last name.
     * @param ln The new last name.
     */
    public void setLastName(String ln) { this.lName = ln; }

    /**
     * Sets the age.
     * @param a The new age.
     */
    public void setAge(int a) { this.age = a; }

    /**
     * Sets the smoking status.
     * @param s The new smoking status.
     */
    public void setSmokingStatus(String s) { this.smokerStatus = s; }

    /**
     * Sets the height.
     * @param h The new height in inches.
     */
    public void setHeight(double h) { this.height = h; }

    /**
     * Sets the weight.
     * @param w The new weight in pounds.
     */
    public void setWeight(double w) { this.weight = w; }

    /**
     * Calculates the Body Mass Index based on height and weight.
     * @return The calculated BMI.
     */
    public double calculateBMI() {
        return (weight * 703) / (height * height);
    }

    /**
     * Calculates the total insurance price based on age, smoking status, and BMI.
     * @return The total calculated price.
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
