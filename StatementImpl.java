import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StatementImpl implements Statement {

    private Account account;
    private Date startDate;
    private Date endDate;
	private ArrayList <Transaction> trans;
    public StatementImpl(Account account, Date startDate, Date endDate) {
      this.account = account;
      this.startDate = startDate;
      this.endDate = endDate;
    }

    public int getAccountnum() {
      return account.getAccountNum();
    }

    public Date getStartDate() {
      return this.startDate;
    }

    public Date getEndDate() {
      return this.endDate;
    }
    public String getAccoutName() {
      return account.getAccountName();
    }
	public void addTransaction(Transaction t){
		trans.add(t);
	}
    public List getTransations() {
		return trans;
    }

	@Override
	public int getAccountNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getAccountName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getTransactions() {
		// TODO Auto-generated method stub
		return null;
	}
}
