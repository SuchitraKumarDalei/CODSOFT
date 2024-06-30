import java.util.Scanner;
import java.lang.Math;
public class NumGuess{
    public static void main(String args[]){
        Scanner scc = new Scanner(System.in);
        int min = 0;
        int max = 100;
        
        int rand = (int)(Math.random()*(max-min+1)+min);
        System.out.println("    *****Welcome to Number Guess Game*****     ");
        System.out.println("Guess a number between 0 - 100 : ");
        int player = scc.nextInt();

        int tryy=1;
        while(player!=rand){
            if(tryy == 5)
                break;
            if(rand > player){
                System.out.println(5-tryy+" Chance left");
                System.out.println("Enter a higher number");
                player = scc.nextInt();
                tryy++;
            }else{
                System.out.println(5-tryy+" Chance left");
                System.out.println("Enter a lower number");
                player = scc.nextInt();
                tryy++;
            }
        }
        if(tryy >= 5){
            System.out.println("You Exist the limit of guessing number!");
        }else{
            System.out.println("You Guessed it correct ! "+rand);
            System.out.println("Total attempts : "+tryy);
        }
        System.out.println("Random number is : "+rand);
    }
}