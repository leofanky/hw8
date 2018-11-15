import javax.swing.JOptionPane;
import java.util.Date;
public class TestATM {
   public static void main(String[] args) {
   	    
   //Creates 10 accounts
      Account[] accounts = new Account[10];
      for (int i = 0; i < accounts.length; i++) { 
         accounts[i] = new Account(i, 100); 
      }
      
      while(true) {
      
         boolean using = true;
      
         int idInput = Integer.parseInt(JOptionPane.showInputDialog("Enter your account ID"));
         int index = -1; //holder position for the Account index
      	
         for(int i = 0; i < accounts.length; i++) {
            if(accounts[i].getId() == idInput) {
               index = i; //we have the index;
               i = accounts.length;
            }				
         }
         
         if(index != -1) {
            while(using) {
            
            //display menu 					
               int choice = Integer.parseInt(JOptionPane.showInputDialog(null, 
                    "      ATM main menu:\n" + "\n"
                  + "1 - View account balance\n"
                  + "2 - Withdraw funds\n"
                  + "3 - Deposit funds\n"
                  + "4 - Terminate transaction\n" + "\n"));
                  
               if (choice < 1 || choice > 4){
                  JOptionPane.showMessageDialog(null, 
                     "Invalid Choice" );
               }
                  
               if (choice == 1){
                  JOptionPane.showMessageDialog(null, 
                     accounts[0].getDate() + "\n" + "\n" +
                     "You have a balance of $" + accounts[index].getBalance() + "\n" + "\n");
               
               }
               
               if(choice == 2) {
                  double amount = Double.parseDouble(JOptionPane.showInputDialog("Input withdraw amount!"));
                  if(amount > accounts[index].getBalance()) {
                     JOptionPane.showMessageDialog(null, "Insufficient Funds");
                  } 
                  else {
                     accounts[index].withdraw(amount);
                     JOptionPane.showMessageDialog(null, 
                        "Withdrawal amount: $" + amount + "\n" + "New balance: $" + accounts[index].getBalance());
                  }
               }
               
               if(choice == 3) {
                  double amount = Double.parseDouble(JOptionPane.showInputDialog("Input deposit amount!"));
                  accounts[index].deposit(amount);
                  JOptionPane.showMessageDialog(null, 
                     "Deposit amount: $" + amount + "\n" + "New balance: $" + accounts[index].getBalance());
               }
            
               if (choice == 4){
                  using = false;
               }
            }
         }
         
         else {
         
            JOptionPane.showMessageDialog(null, "Invalid ID");
         }
      }   
   }
}  

class Account {

   private int id = 0;
   private double balance = 0;
   private double withdraw = 0;
   private double deposit = 0;
   private double amount = 0;
   private Date date = new Date();
   
   public Account() {
   }
   
   public Account(int id, double balance){
   
      this.id = id;
      this.balance = balance;
   }
         
   public int getId(){
   
      return this.id;
   }
	
   public void setId(int newId) {
     
      id = newId;	
   }
	  
   public double getBalance() {
     
      return this.balance;   
   }		  
  
   public java.util.Date getDate() {
   
      return this.date;      
   }
	
   public double getWithdraw() {
   
      return this.withdraw;   
   }
	
   public void withdraw(double amount) {
   
      balance -= amount;   
   }
   
   public double getDeposit() {
   
      return this.deposit;   
   }
	
   public void deposit(double amount) {
   
      balance += amount;
   }
}