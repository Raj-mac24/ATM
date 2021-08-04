package atm;

import java.io.*;
import java.util.*;
import BST.Binary_Search_Tree;

public class ATM extends Binary_Search_Tree{

    // Taking Input from file to do the operations
    private void Input_form_file() throws IOException
    {

        // Opening A file into scanner
       Scanner scanner = new Scanner(new File("Input.txt"));
        
       // Scanning and inserting in Tree
       while(scanner.hasNextLine())
       {
        String Line = scanner.nextLine();
        String Name = "";
        int Acc,P;
        Acc=P=0;
        double ammount=0;
            int i=0;
            // scanning name
            while(Line.charAt(i)!=' ')
            {
                Name+=Line.charAt(i++);
            }

            // scanning account no.
            while(Line.charAt(++i)!=' ')
            {
                Acc=Acc*10+(Line.charAt(i)-'0');
            }

            // scanning password
            while(Line.charAt(++i)!=' ')
            {
                P=P*10+(Line.charAt(i)-'0');
            }

            // scanning initial balance
            ++i;
            while(i<Line.length())
            {
                ammount=ammount*10+(Line.charAt(i++)-'0');
            }

        // inseting the node in BST   
        insert(Name, Acc, P, ammount);
       }
       
       scanner.close();
    }
    // scanning ended here

    // constructor to print the necessory info 
    public ATM()
    {
        System.out.println("\n******/ Welcome \\*******\n");
        try{
            Input_form_file();
           // Print();
        }catch(IOException e)
        {
            System.out.println("IO Exception in input form file");
        }
    }

    // To check the account exists or not 
    public void Check(int A,boolean[] F){

        search_Tree(A,F);
    }
}