import java.util.*;
import java.io.*;

class t3
{
    String name;
    int amt;
    t3(String n,int a)
    {
       name=n;
       amt=a;
    }
   void account()
   {
       Scanner sc=new Scanner(System.in);
       try
       {
           FileWriter fw=new FileWriter("D:\\bank.txt",true);
           System.out.println("Enter Name : ");
            name=sc.nextLine();
            System.out.println("Enter Amount : ");
            amt=sc.nextInt();
            fw.write(name+"\n");
            fw.write(amt+"\n");
            fw.close();
       }
       catch(IOException e)
        {
        }
   }
}
public class atm extends t3
{
    atm(String n,int a)
    {
       super(n,a);
       
    }
    void main()
    {
        System.out.println("\n\tATM");
        while(true)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n1.Winthdraw\n2.Deposit\n3.Check Balance\n4.Exit");
            int c=sc.nextInt();
            if(c==1)
            {
                withdraw();
            }
            else if(c==2)
            {
                deposit();
            }
            else if(c==3)
            {
                checkbalance();
            }
            else if(c==4)
            {
                System.exit(0);
            }
            else
            {
                System.out.println("\nINVALID INPUT");
                main();
            }
        }
    }
    void deposit()
    {
        String name;
        try
        {   
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter Name ");
            String name1=sc.nextLine();
            System.out.println("Enter Amount To Deposit ");
            int amt1=sc.nextInt();
            FileWriter fw1 = new FileWriter("D:\\banknew.txt");
            FileReader br = new FileReader("D:\\bank.txt");
            BufferedReader fw=new BufferedReader(br);
            while((name=fw.readLine())!=null) //running loop to read contents of file
            {
                String amt= fw.readLine();
                if(name.equalsIgnoreCase(name1))
                {
                    amt1=Integer.parseInt(amt)+amt1;
                    System.out.println("Deposit successful");
                    System.out.println("\nNew Balance : "+amt1);
                    try
                    { 
                       fw1.write(name1+"\n");
                       fw1.write(amt1+"\n");
                    }
                    catch(IOException e)
                    {
                    }
                }
                else 
                {
                   fw1.write(name+"\n");
                    fw1.write(amt+"\n"); 
                }
            }
            fw.close();
            br.close();
            fw1.close();
        }
        catch(IOException e)
        {
        }
        try
        {
              FileWriter fw1 = new FileWriter("D:\\bank.txt");
              FileReader br = new FileReader("D:\\banknew.txt");
              BufferedReader fw=new BufferedReader(br);
              while((name=fw.readLine())!=null)
              {
                //String name= fw.readLine();
                String amt= fw.readLine();
                fw1.write(name+"\n");
                fw1.write(amt+"\n");
              }
              br.close();
                fw1.close();fw.close();
        }
        catch(IOException e)
        {
        }
        main();
    }
    void checkbalance()
    {
        String name;
        try
        {   
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter Name ");
            String name1=sc.nextLine();
            FileReader br = new FileReader("D:\\bank.txt");
            BufferedReader fw=new BufferedReader(br);
            while((name=fw.readLine())!=null) //running loop to read contents of file
            {
                String amt= fw.readLine();
                if(name.equalsIgnoreCase(name1))
                {
                    int amt1=Integer.parseInt(amt);
                    System.out.println("\n\t Account Balance : "+amt1);
                }
            }
            fw.close();
            br.close();
        }
        catch(IOException e)
        {
        }
        main();
    }
    void withdraw()
    {
        String name;
        try
        {   
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter Name ");
            String name1=sc.nextLine();
            System.out.println("Enter Amount To Withdraw ");
            int amt1=sc.nextInt();
            FileWriter fw1 = new FileWriter("D:\\banknew.txt");
            FileReader br = new FileReader("D:\\bank.txt");
            BufferedReader fw=new BufferedReader(br);
            while((name=fw.readLine())!=null) //running loop to read contents of file
            {
                String amt= fw.readLine();
                if(name.equalsIgnoreCase(name1))
                {
                    
                    amt1=Integer.parseInt(amt)-amt1;
                    if(amt1<0)
                    {
                        System.out.println("Insufficient balance !!!");
                        System.out.println("\nAvailable Balance : "+Integer.parseInt(amt));
                        amt1=Integer.parseInt(amt);
                    }
                    else
                    {
                        System.out.println("Withdrawl success");
                        System.out.println("\nNew Balance : "+amt1);
                    }
                    try
                    { 
                       fw1.write(name1+"\n");
                       fw1.write(amt1+"\n");
                    }
                    catch(IOException e)
                    {
                    }
                }
                else 
                {
                   fw1.write(name+"\n");
                    fw1.write(amt+"\n"); 
                }
            }
            fw.close();
            br.close();
            fw1.close();
        }
        catch(IOException e)
        {
        }
        try
        {
              FileWriter fw1 = new FileWriter("D:\\bank.txt");
              FileReader br = new FileReader("D:\\banknew.txt");
              BufferedReader fw=new BufferedReader(br);
              while((name=fw.readLine())!=null)
              {
                //String name= fw.readLine();
                String amt= fw.readLine();
                fw1.write(name+"\n");
                fw1.write(amt+"\n");
              }
              br.close();
                fw1.close();fw.close();
        }
        catch(IOException e)
        {
        }
        main();
    }
}