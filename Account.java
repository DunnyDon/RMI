import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {

    private int accountNum;
    private double balance;
    private List<Transaction> transactions;
    private String name;
    public Account(int num, String name) {
        this.accountNum = num;
        this.balance = 0;
        transactions = new ArrayList<Transaction>();
        this.name = name;
    }

    public Account(int num, double bal, String name) {
        this.balance = bal;
        transactions = new ArrayList<Transaction>();
        this.name=name;
    }

    public void deposit(double amt){
  		balance += amt;
  	}
  	public void withdraw(double amt) throws InvalidSession{
  		if(amt <= balance){
  			balance -= amt;
  		} else {
  			throw new InvalidSession("Not enough money to withdraw");
  		}
  	}
    public void addTransaction(String type, Date date, double amount){
  		Transaction t = new Transaction(date, type,amount);
  		transactions.add(t);
  	}
  	public double getBalance(){
  		return balance;
  	}
  	public int getAccountNum() {
  		return accountNum;
  	}
  	public List getTransactions(Date s, Date e) {
		StatementImpl state = new StatementImpl(this,s,e);
		for(int i=0;i<transactions.size();i++){
			if(transactions.get(i).getDate().after(s) && transactions.get(i).getDate().before(e)) {
				state.addTransaction(transactions.get(i));
			}
		}
  		return state.getTransactions();
  	}
  	public String getAccountName(){
  		return this.name;
  	}
}
