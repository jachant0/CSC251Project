// default constructor
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

// constructor with all arguments
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

// Getters
public String getPolicyNumber() { return policyNum; }
public String getProviderName() { return provider; }
public String getFirstName() { return fName; }
public String getLastName() { return lName; }
public int getAge() { return age; }
public String getSmokingStatus() { return smokerStatus; }
public double getHeight() { return height; }
public double getWeight() { return weight; }

// Setters
public void setPolicyNumber(String pNum) { this.policyNum = pNum; }
public void setProviderName(String prov) { this.provider = prov; }
public void setFirstName(String fn) { this.fName = fn; }
public void setLastName(String ln) { this.lName = ln; }
public void setAge(int a) { this.age = a; }
public void setSmokingStatus(String s) { this.smokerStatus = s; }
public void setHeight(double h) { this.height = h; }
public void setWeight(double w) { this.weight = w; }

// Calculate BMI
public double calculateBMI() {
    return (weight * 703) / (height * height);
}

// Calculate the total price
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
