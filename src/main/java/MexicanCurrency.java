public class MexicanCurrency {
    private double currencyMXN;
    private String text;

    public MexicanCurrency(String text) {
        this.text = text;
    }

    public double getCurrencyMXN() {
        // Expected text
        // 1 EUR = 23.65373770 MXN
        final String[] textSplit = text.trim().strip().split(" ");
        currencyMXN = Double.parseDouble(textSplit[3]);

        System.out.println("Current mxn currency = " + currencyMXN);

        return currencyMXN;
    }

    public void setCurrencyMXN(double currencyMXN) {
        this.currencyMXN = currencyMXN;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
