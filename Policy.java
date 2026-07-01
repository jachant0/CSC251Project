/**
 * Represents an insurance policy containing a PolicyHolder.
 */
public class Policy {
    private String policyNum;
    private String provider;
    private PolicyHolder holder; 

    private static int policyCount = 0;

    public Policy() {
        this.policyNum = "";
        this.provider = "";
        this.holder = new PolicyHolder();
        policyCount++;
    }

    public Policy(String policyNum, String provider, PolicyHolder holder) {
        this.policyNum = policyNum;
        this.provider = provider;
        this.holder = holder;
        policyCount++;
    }

    public String getPolicyNumber() { return policyNum; }
    public String getProviderName() { return provider; }

    // Defensive copy to protect internal object state
    public PolicyHolder getHolder() {
        return new PolicyHolder(holder); 
    }

    public static int getPolicyCount() {
        return policyCount;
    }

    public double calculatePrice() {
        double total = 600.0;
        if (holder.getAge() > 50) total += 75.0;
        if (holder.getSmokingStatus().equalsIgnoreCase("smoker")) total += 100.0;
        
        double bmi = holder.calculateBMI();
        if (bmi > 35) {
            total += (bmi - 35) * 20;
        }
        return total;
    }

    @Override
    public String toString() {
        return String.format("Policy Number: %s\nProvider Name: %s\n%s\nPolicy Price: $%.2f", 
                             policyNum, provider, holder.toString(), calculatePrice());
    }
}
