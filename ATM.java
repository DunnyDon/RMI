import java.rmi.Naming;

public class ATM {

    // Command Line Arguments:
    // 0. server_address: the address of the rmiregistry
    // 1. server_port: the port of the rmiregistry
    // 2. operation: one of "login", "deposit", "withdraw", and "inquiry"
    // 3. account: the user account
    // 3. username: only for "login" operation
    // 4. password: only for "login" operation
    // 4. amount: only for “deposit” and “withdraw” operations
    // 4. from: only for "statement" operation
    // 5. to: only for "statement" operation

    public static void main (String args[]) throws Exception {
        // get user’s input, and perform the operations
        String hostAddress = args[0];
        String portNumber = args[1];
        BankInterface bank = (BankInterface) Naming.lookup("//"+ hostAddress +":"+ portNumber +"/Banks");

        String action = args[2];
        switch (action) {
            case "login":      bank.login(args[3], args[4]);
                               break;
            case "inquiry":    bank.inquiry(args[3]);
                               break;
            case "deposit":    bank.deposit(args[3], args[4]);
                               break;
            case "withdraw":   bank.withdraw(args[3], args[4]);
                               break;
            case "statement":  DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); // 01/10/2016
                               Date startDate = df.parse(args[4]);
                               Date endDate = df.parse(args[5]);
                               Statement statement = bank.getStatement(args[3], startDate, endDate);
                               printStatement(statement);
                               break;
            default: System.out.println("You need to provide a valid ATM action.");
                     break;
        }

    }

    private void printStatement(Statement statement) {
      System.out.println("Account Number: " + statement.getAccountnum());
      System.out.println("Account Name: " + statement.getAccountName());
      System.out.println("From: " + statement.getStartDate());
      System.out.println("To: " + statement.getEndDate());
      System.out.println("Transactions:");
      for(Transaction t : statement.getTransactions()) {
        System.out.println("Type:" + t.getType());
        System.out.println("Amount:" + t.getAmount());
      }
    }
}
