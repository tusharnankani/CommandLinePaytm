import java.util.*;
import java.io.Console;

class paytmWallet
{
	String name;
	long phoneno;
	paytmWallet(String n,long a)
	{
		name=n;
		phoneno=a;
	}
	void display()
	{
		System.out.println("Name of the account holder: " +name);
		System.out.println("Phone Number: "+phoneno);
	}
}
class paytmMoney extends paytmWallet
{
	int amount;
	paytmMoney(String s,long a,int amt)
	{
		super(s,a);
		amount=amt;
		super.display();
	}
	void display()
	{
		System.out.println("Amount (in rupees) : "+amount);
	}
}

class paytmDetails extends paytmMoney
{
	int balance1,balance2,choice;
	int recharge;
	int cashback;
	paytmDetails(String s,long a,int amt,int ch,int bal1,int bal2,int r,int c)
	{
		super(s,a,amt);
		if(ch==1)
		{
			recharge=r;
			bal1=10000-amt-r;
			balance1=bal1;
			c=30;
			cashback=c;
			balance2=bal2;
			super.display();
		}
		if(ch==2)
		{
			recharge=r;
			bal1=10000+amt-r;
			balance1=bal1;
			c=30;
			cashback=c;
			balance2=bal2;
			super.display();
		}
	}
	void display()
	{
		System.out.println("Recharge amount (0 if recharge is not required): "+recharge);
		System.out.println("Balance amount: "+balance1);
		System.out.println("There is a cashback of rupees "+cashback+"!");
		System.out.println("Updated Balance amount: "+balance2);
	}
}

class paytmLite
{
	public static void main(String a[])
	{
		Scanner sc=new Scanner(System.in);
		Console console = System.console();

		System.out.println("\npaytmLite");
		System.out.print("Enter username:");
		String user=sc.next();

		// implementing masking of password;
		System.out.print("Enter password:");
		char[] password=console.readPassword();
		String pwd = new String(password);
		sc.nextLine();
		if((user.equals("admin")) && (pwd.equals("admin123")))
		{
			System.out.println("+-------- Welcome PaytmLite Users ---------+");

			System.out.println("Total: Rs. 10000");
			System.out.print("Name: ");
			String n=sc.nextLine();
			System.out.print("Phone number: ");
			long years=sc.nextLong();

			while(true)
			{
				System.out.print("Select: \n[1] Withdraw money \n[2] Deposit money \n[3] Exit \nYour choice: ");
				int choice=sc.nextInt();
				if(choice==1)
				{
					System.out.print("Amount:");
					int amt=sc.nextInt();
					System.out.print("Recharge amount (0 if recharge is not required):");
					int r=sc.nextInt();
					int bal1=10000-amt;
					int c=30;
					int bal2=bal1-r+c;
					System.out.println(" ");
					System.out.println("DETAILS");
					paytmDetails save=new paytmDetails(n,years,amt,choice,bal1,bal2,r,c);
					save.display();
					break;
				}
				else if(choice==2)
				{
					System.out.print("Amount: ");
					int amt=sc.nextInt();
					System.out.print("Recharge amount (0 if recharge is not required): ");
					int r=sc.nextInt();
					int bal1=10000+amt;
					int c=30;
					int bal2=bal1-r+c;
					System.out.println(" ");
					System.out.println("DETAILS");
					paytmDetails save=new paytmDetails(n,years,amt,choice,bal1,bal2,r,c);
					save.display();
					break;
				}
				else {
					System.out.println("Invalid Choice!\n");
				}
			}
		}
		else
		{
			System.out.println("Either the username or the password is invalid.");
		}
	}
}