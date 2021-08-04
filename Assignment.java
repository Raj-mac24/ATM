
import atm.ATM;
import java.util.*;

class Assignment{

    public static void main(String[] args) {
        //Creating the object of ATM class
        ATM atm = new ATM();

        // to use the concept of pass by reference 
        // we have used the Found boolean array 
        // to check whether account is find or not
        boolean[] Found = new boolean[1];
        Found[0]=false;
        Scanner scan = new Scanner(System.in);
        int c1;
        do
        {
            // taking the account no. as input
            // and -1 to close the program
            System.out.println("Enter Account number(or enter -1 to close the program)");
             c1 = scan.nextInt();

            if(c1!=-1)
            {
                // check method is called to check
                // the input account no.
                atm.Check(c1,Found);
                if(!Found[0])  System.out.println("\nNot Found");
                else
                Found[0] = false;
            }
        }while(c1!=-1);

        scan.close();
    }
}
