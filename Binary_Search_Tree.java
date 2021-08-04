package BST;
import java.util.*;

public class Binary_Search_Tree    
{
    Scanner scan = new Scanner(System.in);
    
    // Creating A node of tree using inner class
    private class Data
    {
         // Data Field
        private String Name;
        private int Acc_no;
        private int Pin;
        private double balance;

        
         // Linking Field
        Data L,R;

        // Creating A node
        Data(String N,int A,int P,double B)
        {
            Name=N;
            Acc_no = A;
            Pin = P;
            balance = B;
            L=R=null;
        }
    }
   
    private Data root;  // Creating reference of the root of BST

    public Binary_Search_Tree()
    {
        root=null;
    }
    
    // Inserting a node using insert method
    public void insert(String N,int A,int P,double B)
    {
        root=Insert_node(root, N, A, P, B);
    }

    private Data Insert_node(Data root,String N,int A,int P,double B)
    {
        if(root!=null){

            if(A<root.Acc_no) 
            root.L=Insert_node(root.L,N,A,P,B);

            else if(A>root.Acc_no)
            root.R=Insert_node(root.R,N,A,P,B);

            else{
                System.out.println("Duplicates not allowed");
            }
            return root;
        }
        else
        {
            Data New = new Data(N,A,P,B);
            return New;
        }
    }
    // Inserting Finished

    //Printing the data of all the users
    public void Print()
    {
        Inorder(root);
    }
    private void Inorder(Data root)
    {
        if(root!=null)
        {
            Inorder(root.L);
            Details(root);
            Inorder(root.R);
        }
    }
    // Printing Finished

    // Basic Operations done by ATM
    private void Deposit(Data root)
    {
        double a;
        System.out.println("Enter Ammount to be deposited");
        a=scan.nextDouble();
        if(a<=0)    System.out.println("Invalid ammount");
        else
        {
            root.balance+=a;
        }   
    }

    private void Withdrawl(Data root)
    {
        double a;
        System.out.println("Enter Ammount");
        a=scan.nextDouble();
        if(a>root.balance)      System.out.println("Not enough balance");
        else
        {
            root.balance-=a;
            System.out.println("Collect your money from Cash Dispenser");
        }

    }

    private void Change_Pin(Data root)
    {
        int p;
        System.out.println("Enter old Pin");
        p=scan.nextInt();
        if(p==root.Pin)
        {
            System.out.println("Enter new Pin");
            p=scan.nextInt();
            root.Pin=p;
        }
    }

    private void Details(Data root)
    {
        System.out.println("\n*******/ Details \\*******");
        System.out.println("  Name    : "+root.Name);
        System.out.println("Account no: "+root.Acc_no);
        System.out.println("  Pin     : ****");
        System.out.println(" Balance  : "+root.balance+"\n");
    }

    private void Operations(Data root,boolean[] F)
    {
        int c;
        int p;
        F[0] = true;
        
        // asking for PIN  
        System.out.println("Enter Pin");
        p=scan.nextInt();

        if(p==root.Pin){
        for(int i=0;i<25;i++)   System.out.print("*");
        
        System.out.println("\nName : "+root.Name);
        do{
        System.out.print("\n\t1 - Deposit\n\t2 - Withdrawl\n\t3 - Change Pin\n\t4 - Details\n\t0 - Exit\n\tEnter: ");
        c=scan.nextInt();
    
        switch(c)
        {
        case 1:
        Deposit(root);
        break;

        case 2:
        Withdrawl(root);
        break;

        case 3:
        Change_Pin(root);
        break;

        case 4:
        Details(root);
        break;

        case 0:
        break;

        default:
        System.out.println("Invalid Input");
        }
        }while(c!=0);

        for(int i=0;i<25;i++)   System.out.print("*");
        System.out.println();
    }   // end of if
    else
    {
        System.out.println("\n Wrong Pin");
    }

    }
    // End of Operations

    // Searching an Account to perform the Operations
    public void search_Tree(int A,boolean[] F)
    {
        search(root, A,F);
    }
    private void search(Data root,int A,boolean[] F)
    {
        if(root!=null){
        if(A > root.Acc_no)
        search(root.R, A,F);

        else if( A < root.Acc_no)
        search(root.L, A,F);

        else 
        {
            Operations(root,F);
        }
        
        }

    }
    //  End of Searching

}   // End of class
