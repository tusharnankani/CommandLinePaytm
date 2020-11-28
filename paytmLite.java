import java.util.*;
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
		System.out.println("Name of the account holder : " +name);
		System.out.println("Phone Number : "+phoneno);
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
		System.out.println("Recharge amount (0 if recharge is not required) : "+recharge);
		System.out.println("Balance amount : "+balance1);
		System.out.println("There is a cashback of rupees "+cashback+"!!");
		System.out.println("Updated Balance amount : "+balance2);
	}
}

class paytmLite
{
	public static void main(String a[])
	{
		System.out.println(" ");
		System.out.println("paytmLite");
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter username :");
		String user=sc.next();
		System.out.print("Enter password :");
		String pwd=sc.next();
		if((user.equals("admin")) && (pwd.equals("admin123")))
		{
			System.out.println("--------WELCOME paytmLite USERS!!!---------");
			System.out.println("Total:10000");
			System.out.print("Name:");
			String n=sc.next();
			System.out.print("Phone number:");
			long years=sc.nextLong();
			System.out.print("Select 1 if you want to withdraw money and 2 if you want to deposit money...Your choice:");
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
			}
			if(choice==2)
			{
				System.out.print("Amount:");
				int amt=sc.nextInt();
				System.out.print("Recharge amount (0 if recharge is not required):");
				int r=sc.nextInt();
				int bal1=10000+amt;
				int c=30;
				int bal2=bal1-r+c;
				System.out.println(" ");
				System.out.println("DETAILS");
				paytmDetails save=new paytmDetails(n,years,amt,choice,bal1,bal2,r,c);
				save.display();
			}
		}
		else
		{
			System.out.println("Either the username or the password is invalid");
		}
	}
}