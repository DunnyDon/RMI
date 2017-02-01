import java.util.Date;

public class Transaction {
  public Date date;
  private String type;
  private double amount;

  public Transaction(Date date, String type, double amount) {
    this.date = date;
    this.type = type;
    this.amount = amount;
  }

  public Date getDate() {
    return this.date;
  }
  public String getType() {
    return this.type;
  }
  public Double getAmount() {
    return this.amount;
  }
}
