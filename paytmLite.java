import java.util.*;
import java.io.Console;

class paytmWallet
{
	String name, phoneno;
	paytmWallet(String n,String a)
	{
		name=n;
		phoneno=a;
	}
	void display()
	{
		
		System.out.println("+---------------------------------------------+");
		System.out.println("|  Name of the account holder: " +name);
		System.out.println("|  Phone Number: "+phoneno);
		System.out.println("+---------------------------------------------+");
	}
}
class paytmMoney extends paytmWallet
{
	int amount;
	paytmMoney(String s,String a,int amt)
	{
		super(s,a);
		amount=amt;
		super.display();
	}
	void display()
	{
		System.out.println("+------------------------------+");
		System.out.println("|  Amount (in rupees) : "+amount);
		System.out.println("+------------------------------+");
	}
}

class paytmDetails extends paytmMoney
{
	int balance1,balance2,choice;
	int recharge;
	int cashback;
	paytmDetails(String s,String a,int amt,int ch,int bal1,int bal2,int r,int c, int availableAmount)
	{
		super(s,a,amt);
		if(ch==1)
		{
			recharge=r;
			// bal1=availableAmount-amt-r;
			availableAmount = bal1;
			balance1=bal1;
			// c= (int)(0.05 * ((double)amt));
			cashback=c;
			balance2=bal2;
			availableAmount = bal2;
			super.display();
		}
		if(ch==2)
		{
			recharge=r;
			// bal1=availableAmount+amt-r;
			availableAmount = bal1;
			balance1=bal1;
			// c=(int)(0.05 * ((double)amt));
			cashback=c;
			balance2=bal2;
			availableAmount = bal2;
			super.display();
		}
	}

	public static void wait(int ms)
	{
		try
		{
			Thread.sleep(ms);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
	}
	

	void display()
	{
		System.out.println("+------------------------------------------------------------+");
		System.out.println("|  Recharge amount (0 if recharge is not required): "+recharge);
		System.out.println("|  Balance amount: "+balance1);
		wait(1000);
		if(cashback != 0)
		{
			System.out.println("|*******************************************************");
			System.out.println("|  There is 5% cashback, you get a cashback of Rupees "+cashback+"!");
			System.out.println("|*******************************************************\n|");
		}
		wait(2000);
		System.out.println("|  Updated Balance amount: "+balance2);
		System.out.println("|");
		System.out.println("+------------------------------------------------------------+\n");
	}
}

class paytmLite
{
	public static void main(String a[])
	{
		Scanner sc=new Scanner(System.in);
		Console console = System.console();
		
		int availableAmount = 10000;

		System.out.println("\n+ - - - - - - - - - - - - - PaytmLite - - - - - - - - - - - - - +\n");
		
		boolean continueInput = true;
		while(continueInput)
		{
			System.out.print("Enter username: ");
			String user=sc.next();
			
			// implementing masking of password;
			System.out.print("Enter password: ");
			char[] password=console.readPassword();
			String pwd = new String(password);
			sc.nextLine();
			
			if((user.equals("admin")) && (pwd.equals("admin123")))
			{
				continueInput = false;
				
				System.out.println("\n+-------- Welcome PaytmLite Users ---------+");
				
				System.out.println("Total: Rs. 10000");
				System.out.print("Name: ");
				String n=sc.nextLine();
				System.out.print("Phone number: ");
				String years=sc.nextLine();
				
				boolean continueInput2 = true;
				while(continueInput2)
				{
					boolean mno = true;
					int choice = -1;
					while(mno)
					{
						try {
							System.out.println("\n+-----------------------------+");
							System.out.println("|  Select an option:          |");
							System.out.println("|  [1] Make a Payment         |");
							System.out.println("|  [2] Deposit money          |");
							System.out.println("|  [3] Exit                   |");
							System.out.println("+-----------------------------+");
							System.out.print(">>> Your Choice: ");
							choice=sc.nextInt();
							mno = false;
						}
						catch(InputMismatchException e)
						{
							sc.nextLine();
							System.out.println("\n>>> Types don't match! Please enter a valid choice!");
						}
					}

					if(choice==1)
					{
						int amt = 0, r = 0;
						boolean abc = true;
						while(abc) {
							boolean def = true;
							while(def)
							{
								try {
									System.out.print("\nAmount: ");
									amt=sc.nextInt();
									System.out.print("Recharge amount (0 if recharge is not required): ");
									r=sc.nextInt();
									def = false;
								}
								catch(InputMismatchException e)
								{
									sc.nextLine();
									System.out.println("\n>>> Types don't match! Please enter a valid amount!");
								}
							}
							if(availableAmount-amt-r < 0)
							{
								System.out.println("+ - - Insufficient Balance. - - +");
								System.out.println("+ - - - -   Try Again   - - - - +");
								continue;
							}
							else {
								int bal1=availableAmount-amt;
								int c=(int)(0.05 * ((double)amt));
								int bal2=bal1-r+c;
								availableAmount = bal2;
								System.out.println(" ");
								abc = false;
								System.out.println("\n+-------------- DETAILS ----------------+");
								paytmDetails save=new paytmDetails(n,years,amt,choice,bal1,bal2,r,c,availableAmount);
								save.display();
							}
						}
					}
					else if(choice==2)
					{
						int amt = 0;
						boolean def = true;
						while(def)
						{
							try {
								System.out.print("\nAmount: ");
								amt=sc.nextInt();
								def = false;
							}catch(InputMismatchException e)
							{
								sc.nextLine();
								System.out.println("\n>>> Types don't match! Please enter a valid choice!");
							}
						}
						int r=0;
						int bal1=availableAmount+amt;
						int c=(int)(0.05 * ((double)amt));
						int bal2=bal1-r+c;
						availableAmount= bal2;
						System.out.println(" ");
						System.out.println("\n+-------------- DETAILS ----------------+");
						paytmDetails save=new paytmDetails(n,years,amt,choice,bal1,bal2,r,c,availableAmount);
						save.display();
					}
					else if(choice == 3) {
						System.out.println("\nExiting...\n");
						continueInput2 = false;
						System.exit(0);
					}
					else {
						System.out.println(">>> Invalid Choice!\n");
					}
				}
			}
			else
			{
				System.out.println("Either the username or the password is invalid.\n");
				continueInput = true;
			}
		}
	}
}