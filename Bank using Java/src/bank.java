import java.util.Scanner;

class passIncorrect extends Exception
{
	String pass;
	public passIncorrect(String s) 
	{
		pass=s;
	}
	
	@Override
	public String toString()
	{
		return ("Password Incorrect ");
	}
}

class minBal extends Exception
{
	@Override
	public String toString()
	{
		return ("Your Account should have a minimum balance of 2500 Rs.\n That's our policy");
		
	}
}


public class bank 
{

	private int accNum=100;
	private String name="Mr.A";
	private int age=20;
	private double balance=2500;
	private String pass="admin";
	private String enter;
	private double money;
	
	Scanner sc=new Scanner(System.in);
	
	int init()
	{
		System.out.println("Enter Your Account Number ");
	    accNum=sc.nextInt();
	    
	    try
	    {
	    	System.out.println("Enter Your Password ");
	    	enter=sc.next();
	    	if(accNum==111&&enter.equals(pass))
	    	{
	    		System.out.println("Access Granted");
	    		return 1;
	    	}
	    	else if(!enter.equals(pass))
	    	{
	    		throw new passIncorrect(pass);
	    	}
	    }
	    catch(passIncorrect p)
	    {
	    	System.out.println(p);
	    	return 0;
	    }
		return 1;
	}
	
	//function to create account
	public void Create()
	{
		System.out.println("Welcome to XYZ Bank");
		
		System.out.println("Enter Your Name");
		name=sc.next();
		
		System.out.println("Enter Your Age");
		age=sc.nextInt();
		
		System.out.println("Congratulations Your Account is Successfully Created");
		accNum++;
		System.out.println("Your Account Number is "+accNum);
		System.out.println("Enter Your new PAssword");
		pass=sc.next();
		
		System.out.println("Your Data is Registered");
		
		balance = 2500;	
	}
	
	public <E> double getbalance()
	{
		return balance;
	}
	
	public <E> String getName()
	{
		return name;
	}
	
	public <E> int getAge()
	{
		return age;
	}
	
	public <E> double bal()
	{
		return balance;
	}
	
	public <E> void deposit()
	{
		int access=init();
		if(access==1)
		{
			System.out.println("Enter the Amount You want to Deposit");
			money=sc.nextDouble();
			balance=balance+money;
		}
		else
		{
			String ans;
			System.out.println("Retry?");
			ans=sc.next();
			if(ans=="y")
				deposit();
			else
				System.out.println("Thank you ");
		}
	}
	
	public void withdraw()
	{
		int access=init();
		if(access==1)
		{
			System.out.println("Enter the Amount You want to Withdraw");
			money=sc.nextDouble();
			try
			{
				if(balance==2500&&(balance-money)<2500)
					throw new minBal();
				else
					balance=balance-money;
			}
			catch(minBal m)
			{
				System.out.println(m);
			}
		}
		else
		{

			String ans;
			System.out.println("Retry?");
			ans=sc.next();
			if(ans=="y")
				deposit();
			else
				System.out.println("Thank you ");
		}
	}

	public void menu()
	{
		System.out.println("Welcome to XYZ Bank ,The Bank Of Richest");
		System.out.println("1.Create");
		System.out.println("2.Existing");
		int choice;
		System.out.println("Enter Your Choice");
		choice=sc.nextInt();
		switch(choice)
		{
			case 1:
				Create();
				break;
			case 2:
				existing();
				break;
		}
	}
	public void profile()
	{
		System.out.println("========================================");
		System.out.println("Name "+getName());
		System.out.println("Age  "+getAge());
		System.out.println("Balance "+getbalance());
		System.out.println("========================================");
	}
	public void existing()
	{
		int access=init();
		boolean flag =true;
		if(access==1)
		{
			while(flag==true)
			{
				System.out.println("Welcome to XYZ Bank ,The Bank Of Richest");
				System.out.println("1.Deposit");
				System.out.println("2.Withdraw");
				System.out.println("3.Get Details");
				System.out.println("4.Get Bank Balance ");
				System.out.println("5.Exit");
				int choice;
				System.out.println("Enter Your Choice");
				choice=sc.nextInt();
				switch(choice)
				{
					case 1:
						deposit();
						break;
					case 2:
						withdraw();
					case 3:
						profile();
						break;
					case 4:
						System.out.println("================================");
						System.out.println("Your Bank Balance is "+getbalance());
						System.out.println("================================");
						break;
					case 5:
						flag=false;
						break;
				}
			}
		}
		else
		{
			System.out.println("Access Denied");
		}
	}
	public static void main(String[] args) 
	{
		bank a=new bank();
		while(true)
		{
			a.menu();
		}	
	}
}


