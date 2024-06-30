import java.util.Scanner;
public class GradeCalc{
    public static void main(String a[]){
        Scanner sc = new Scanner(System.in);
        int total=0;
        System.out.println("*****Welcome to Student Grade Calculator****");
        System.out.println("Enter no. of subjects");
        int totSub = sc.nextInt();
        int marks[]=new int[totSub];
        for(int i=0;i<totSub;i++){
            System.out.println("Enter "+(i+1)+" Subject mark : ");
            marks[i] = sc.nextInt();
            total = total+marks[i];
        }
        int fullMark = totSub*100;
        int Avg = (int)(((float)total/fullMark)*100);

        System.out.println("Average percentage : "+Avg+"%");
        System.out.println("Total marks "+total+" out of "+fullMark);
        if(Avg>=90)
            System.out.println("Grade 'O'");
        else if(Avg>=80)
            System.out.println("Grade 'E'");
        else if(Avg>=70)
            System.out.println("Grade 'A'");
        else if(Avg>=60)
            System.out.println("Grade 'B'");
        else if(Avg>=50)
            System.out.println("Grade 'C'");
        else if(Avg>=30)
            System.out.println("Grade 'D'");
        else
            System.out.println("Grade 'F'");
    }
}