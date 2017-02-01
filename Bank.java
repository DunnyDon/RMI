import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

public class Bank extends UnicastRemoteObject implements BankInterface {

    private List<Account> accounts; // users accounts

    public Bank() throws RemoteException {

    }

    public long login(String username, String password) throws RemoteException, InvalidLogin {
		return 0;
      // implementation code
    }

    

    public Statement getStatement(Date from, Date to) throws RemoteException, InvalidSession {
		return null;
        // implementation code
    }

    public static void main(String args[]) throws Exception {

        System.setSecurityManager(new RMISecurityManager());
        try {
            // First reset our Security manager

            // Create an instance of the local object
            Bank bank = new Bank();
            // Put the server object into the Registry
            String portNumber = args[0];
            Naming.rebind("//localhost:"+ portNumber +"/Banks", bank);
            System.out.println("Name rebind completed");
            System.out.println("Server ready for requests!");
        } catch(Exception exc) {
            System.out.println("Error in main - " + exc.toString());
        }
    }

	@Override
	public void deposit(int accountnum, int amount, long sessionID) throws RemoteException, InvalidSession {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdraw(int accountnum, int amount, long sessionID) throws RemoteException, InvalidSession {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int inquiry(int accountnum, long sessionID) throws RemoteException, InvalidSession {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Statement getStatement(Date from, Date to, long sessionID) throws RemoteException, InvalidSession {
		// TODO Auto-generated method stub
		return null;
	}
}
