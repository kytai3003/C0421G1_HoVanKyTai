package resort_management.models;

public class Contract {
    private int contractNumb;
    private String bookingCode;
    private String customerCode;
    private double deposit;
    private double totalPay;

    public Contract(int contractNumb, String bookingCode, String customerCode, double deposit, double totalPay) {
        this.contractNumb = contractNumb;
        this.bookingCode = bookingCode;
        this.customerCode = customerCode;
        this.deposit = deposit;
        this.totalPay = totalPay;
    }

    public Contract() {
    }

    public int getContractNumb() {
        return contractNumb;
    }

    public void setContractNumb(int contractNumb) {
        this.contractNumb = contractNumb;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractNumb=" + contractNumb +
                ", bookingCode='" + bookingCode + '\'' +
                ", customerCode='" + customerCode + '\'' +
                ", deposit=" + deposit +
                ", totalPay=" + totalPay +
                '}';
    }
}
