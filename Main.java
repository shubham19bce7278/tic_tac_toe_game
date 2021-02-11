import java.util.*;
import java.lang.*;
class Main{
        static String intex[];
        static String turn;
    static String winner()
   {
     for(int i=0;i<8;i++)
     {
       String line=null;
       switch(i)
       {
       case 0:
       line=intex[0]+intex[1]+intex[2];
       break;
        case 1:
       line=intex[3]+intex[4]+intex[5];
       break;
        case 2:
       line=intex[6]+intex[7]+intex[8];
       break;
        case 3:
       line=intex[0]+intex[3]+intex[6];
       break;
        case 4:
       line=intex[1]+intex[4]+intex[7];
       break;
        case 5:
       line=intex[2]+intex[5]+intex[8];
       break;
        case 6:
       line=intex[0]+intex[4]+intex[8];
       break; 
       case 7:
       line=intex[2]+intex[4]+intex[6];
       break;
       }
       if(line.equals("XXX"))
       {
               return "X";
       }
       else if (line.equals("OOO"))
       {
               return "O";
       }
     }
     for(int i=0;i<9;i++)
     {
     if(Arrays.asList(intex).contains( 
                    String.valueOf(i + 1)))
     {
             break;
     }
     else if(i==8){
             return "draw";
     }
   }
   System.out.println(turn+"'s turn\n enter your number:");
   return null;

   }
     public static void printboard()
     {
         System.out.println("-------------");
         System.out.println("| "+ intex[0]+" | "+intex[1]+" | "+intex[2]+" |");
         System.out.println("-------------");
         System.out.println("| "+intex[3]+" | "+intex[4]+" | "+intex[5]+" |");
         System.out.println("-------------");
         System.out.println("| "+intex[6]+" | "+intex[7]+" | "+intex[8]+" |");
         System.out.println("-------------");
     }
 public static void main (String[] args) {
     Scanner q=new Scanner(System.in);
     turn="X";
     String win=null;
      intex = new String [9];
     for(int i=0;i<9;i++)
     {
           intex[i]=String.valueOf(i+1);
     }System.out.println("Welcome to 3x3 Tic Tac Toe."); 
        printboard(); 
  
        System.out.println( 
            "X will play first. Enter a slot number to place X in:"); 

     while(win==null){
             int num;
             try{
                     num=q.nextInt();
                     if(!(num>=1&&num<10))
                     {
                             System.out.println("Invalid input; re-enter slot number:");
                             continue;
                     }

             }
             catch(InputMismatchException e)
             {
                System.out.println("Invalid input; re-enter slot number:");
                continue;      
             }
             if(intex[num-1].equals(String.valueOf(num)))
             {
                intex[num-1]=turn;
                if(turn.equals("X"))
                {
                        turn="O";
                }
                else
                {
                        turn="X";
                }
                printboard();
                win=winner();
             }
             else
             {
                 System.out.println( 
                    "Slot already taken; re-enter slot number:");     
             }
     }
     if(win.equalsIgnoreCase("draw"))
     {
         System.out.println( 
                "It's a draw! Thanks for playing.");      
     }
     else
     {
       System.out.println( 
                "Congratulations! " + win 
                + "'s have won! Thanks for playing.");      
     }
 }
 }