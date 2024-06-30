import java.util.ArrayList;
import java.util.Scanner;

class Course{ 
    int code;
    String tittle;
    int capacity;
    String schedule;
    String description;
    Course(int code,String tittle,int capacity){
        this.code = code;
        this.capacity = capacity;
        this.tittle = tittle;
    }
    public void addDescription(String s){
        this.description = s;
    }
    public void addSchedule(String s){
        this.schedule = s;
    }
}
class Student{
    int id;
    String name;
    ArrayList <Course> course;
    Student(int id,String name){
        this.id = id;
        this.name = name;
        course = new ArrayList<>();
    }
    public void showRegisteredCourse(){
        System.out.println("You have registered below courses.");
        if(!this.course.isEmpty()){
            for(int i=0;i<this.course.size();i++){
                System.out.println((i+1)+". "+course.get(i).tittle);
            }
        }
    }
}
class CourseRegistrationSystem{
    static ArrayList <Course> courses;
    static ArrayList <Student> students;
    public void addCourses(Course c){
        courses.add(c);
    }
    public void totalCourses(){
        if(!courses.isEmpty()){
            for(int i=0;i<courses.size();i++){
                System.out.println("  "+(i+1)+". "+courses.get(i).tittle);
                System.out.println("course ID:"+courses.get(i).code);
                System.out.println("Description : "+courses.get(i).description);
                System.out.println("Schedule : "+courses.get(i).schedule);
                System.out.println("Availabel seats : "+courses.get(i).capacity);

            }
        }else{
            System.out.println("No course is available to registation.");
        }
    }
    public void addStudents(Student s){
        students.add(s);
    }
    public void courseRegistration(Scanner sc){
        System.out.println("Enter your Name : ");
        String s = sc.next();
        System.out.println("Enter your ID : ");
        int id = sc.nextInt();
        Student a = new Student(id, s);
        addStudents(a);

        totalCourses();
        System.out.println("Enter your choice :");
        int wantCourse = sc.nextInt();
        for(int i=0;i<courses.size();i++){
            if(i == wantCourse-1){
                a.course.add(courses.get(i));
                courses.get(i).capacity--;
            }
        }
        System.out.println("You are sucessfully registered....");
    }
    public void cancelRegistration(Scanner sc){
        boolean IdFlag = false;
        System.out.println("Enter your ID for Cancellation : ");
        int cencelID = sc.nextInt();
        for(int i=0;i<students.size();i++){
            if(students.get(i).id == cencelID){
                IdFlag = true;
                if (!students.get(i).course.isEmpty()) {
                    students.get(i).showRegisteredCourse();
                    System.out.println("Enter which course you want to cancel the course : ");
                    int cancelCourse = sc.nextInt();
                    for(int j =0;j<students.get(i).course.size();j++){
                        students.get(i).course.remove(cancelCourse-1);
                    }
                    System.out.println("Courese removed sucessfully...");
                }else{
                    System.out.println("You have not registered any course.");
                }
            }
        }
        if(!IdFlag){
            System.out.println("No record found or You have not registered yourself !");
        }
    }
    public void showRegisteredCourses(Scanner sc){
        System.out.println("Enter ID :  ");
        int showCourseID = sc.nextInt();
        if(!students.isEmpty()){
            for(int i=0;i<students.size();i++){
                if(students.get(i).id == showCourseID){
                    System.out.println("Your Registered course are showing below : ");
                    for(int j=0;j<students.get(i).course.size();j++){
                        System.out.print(students.get(i).course.get(j).tittle+", ");
                    }
                }
            }
        }else{
            System.out.println("No record found or You have not registered yourself !");
        }
    }
    public void menu(){
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("1. Course Registration");
            System.out.println("2. Cancel Registration");
            System.out.println("3. Show registered courses");
            System.out.println("4. Exit");
            System.out.println("Enter Your choice : ");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    courseRegistration(sc);
                    break;
                case 2:
                    cancelRegistration(sc);
                    break;
                case 3:
                    showRegisteredCourses(sc);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Enter a Valid option.....");
                    break;
            }
            
        }while(choice !=3);
    }
    public static void main(String a[]){
        CourseRegistrationSystem byjus = new CourseRegistrationSystem();
        courses = new ArrayList<>();
        students = new ArrayList<>();
        Course Webdev = new Course(100,"Web Development", 10);
        Webdev.addDescription("Full stack Web Development");
        Webdev.addSchedule("Forenoon");

        Course ML = new Course(101, "Machine Learning", 10);
        ML.addDescription("Aartificial inteligence and Machine Learning Development");
        ML.addSchedule("Afternoon");

        Course oops = new Course(102, "Object oreinted Design", 10);
        oops.addDescription("Object oriented desingn and analysis using JAVA");
        oops.addSchedule("Evening");

        byjus.addCourses(Webdev);
        byjus.addCourses(ML);
        byjus.addCourses(oops);

        byjus.menu();
    }
}