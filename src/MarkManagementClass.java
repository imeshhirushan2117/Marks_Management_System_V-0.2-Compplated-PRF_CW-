import java.util.Scanner;

public class MarkManagementClass {
    public static int chainer = 0; // This is the variable that continue chain of student adding of all methods.
    public static int countForPrintRanks = 0; // This varibale is for counting positions for rank printing.

    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
// Handle any exceptions.
        }
    }

    //Below welcomeScreen method is for printing UI in index screen. there are no any inputs or calculations here.
    public static void welcomeScreen() {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("|                   WELCOME TO GDSE MARKS MANAGEMENT SYSTEM                   |");
        System.out.println("-------------------------------------------------------------------------------");
        //End of the header & Below code lines are for printing options.
        System.out.println("[1] Add New Student                      [2] Add New Students With Marks");
        System.out.println("[3] Add Marks                            [4] Update Student Details");
        System.out.println("[5] Update Marks                         [6] Delete Students");
        System.out.println("[7] Print Student Details                [8] Printing Students Ranks");
        System.out.println("[9] Best In Programming Fundamentals     [10] Best In Database Management System");
    }

    //This is the main method and here we are calling all other sub methods.
    public static void main(String[] args) {
        String[][] idName = new String[999][2];
        int[][] marks = new int[999][3];
        selectOption(idName, marks);
    }


    public static void selectOption(String[][] idName, int[][] marks) { //method is used for selecting other options in menu.
        int[][] totalArray = new int[999][2];
        welcomeScreen(); //welcome menu
        do {
            //welcomeScreen(); //welcome menu
            System.out.println();
            Scanner scn1 = new Scanner(System.in); //Scanner
            System.out.print("Enter an option to continue : ");
            int option = scn1.nextInt();
            if(option > 0 && option < 12){
                switch (option) { //enhanced switch for selecting and calling methods.
                    case 1 : {
                        clearConsole();
                        addStudent(idName, marks); //start to run adding student without adding marks.

                    }
                    case 2 : {
                        clearConsole();
                        addStudentWithMarks(idName, marks);

                    }
                    case 3 : {
                        clearConsole();
                        addStudentsMarks(idName, marks);

                    }
                    case 4 : {
                        clearConsole();
                        updateStudentDetails(idName, marks);
                    }
                    case 5 : {
                        clearConsole();
                        updateMarks(idName, marks);
                    }
                    case 6 : {
                        clearConsole();
                        deleteStudent(idName, marks, totalArray);
                    }
                    case 7 : {
                        clearConsole();
                        printStudentDetails(idName, marks, totalArray);
                    }
                    case 8 : {
                        clearConsole();
                        printStudentRanks(idName, marks, totalArray);
                    }
                    case 9 : {
                        clearConsole();
                        bestInPF(idName, marks);
                    }
                    case 10 : {
                        clearConsole();
                        bestInDB(idName, marks);
                    }
                    case 11 : {
                        System.exit(1);
                    }
                }
            }else{
                System.out.println("Invalid Option");
            }
        } while (true);

    }

    public static void addStudent(String[][] idName, int[][] marks) {
        Scanner scn3 = new Scanner(System.in);


        for (int i = chainer; i < 999; i++) { /*This runs iteration for adding students. user can add up to 999 students.
                               chainer (var) is used to continue loop, if exit from the method and re-entered.*/
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("|                                 ADD NEW STUDENT                             |");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.print("Enter Student ID : ");
            String tempVariable = scn3.nextLine(); //temp variable is used to compare is this string is override.
            boolean chek = false; //used to run adding student name and other stuffs if above entered ID is not override.
            for (int j = 0; j < 999; j++) { //iteration used to run all array elements, to compare with temp (var)
                if (tempVariable.equals(idName[j][0])) { //comparing
                    System.out.println("The student ID already exits.!");
                    i--; //if it exits, remove 1 iteration from main loop.
                    chek = true; //if it is exits assign true to boolean (var).
                    break;

                }
            }
            if (!chek) {//this allows to run code if chek boolean is false.So if ID number is exits chek (var) is true.
                idName[i][0] = tempVariable; //if not exits this will assign tmp var to main var
                System.out.print("Enter Student Name : ");
                idName[i][1] = scn3.nextLine();
                chainer++; //continue the chain by adding 1 iteration per 1 added student
                System.out.print("Student has been added successfully.");
                String exitSelection;// = scn3.nextLine(); //getting selection
                do{
                    System.out.print(" Do you want to add new student (Y/N) : ");
                    exitSelection = scn3.nextLine();
                    if(exitSelection.equals("N") || exitSelection.equals("n")){
                        clearConsole();
                        selectOption(idName,marks);
                    }
                    if (!(exitSelection.equals("Y") || exitSelection.equals("N") || exitSelection.equals("y")
                            || exitSelection.equals("n"))){
                        System.out.println("Invalid Option!");
                    }
                }while (!(exitSelection.equals("Y") || exitSelection.equals("N") || exitSelection.equals("y") ||
                        exitSelection.equals("n")));
            }
        }
    }

    public static void addStudentWithMarks(String[][] idName, int[][] marks) {
        Scanner scn4 = new Scanner(System.in);
        for (int i = chainer; i < 999; i++) {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("|                            ADD NEW STUDENT WITH MARKS                       |");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.print("Enter Student ID : ");
            String tempVariable = scn4.nextLine();
            boolean chek = false;
            for (int j = 0; j < 999; j++) {
                if (tempVariable.equals(idName[j][0])) { //comparing
                    System.out.println("The student ID already exits.!");
                    i--; //if it exits, remove 1 iteration from main loop.
                    chek = true; //if it is exits assign true to boolean (var).
                    break;

                }
            }
            if (!chek) {//this allows to run code if chek boolean is false.So if ID number is exits chek (var) is true.
                idName[i][0] = tempVariable; //if not exits this will assign tmp var to main var
                System.out.print("Enter Student Name : ");
                idName[i][1] = scn4.nextLine();
                int tempMarkPF = 0;
                do {
                    System.out.print("Enter Programing Fundamentals Marks : ");
                    tempMarkPF = scn4.nextInt();
                    if (tempMarkPF < 0 || tempMarkPF > 100) {
                        System.out.println("Invalid Marks");
                    }
                } while (tempMarkPF < 0 || tempMarkPF > 100);
                marks[i][0] = tempMarkPF;
                int tempMarkDB = 0;
                do {
                    System.out.print("Enter Database Management Marks : ");
                    tempMarkDB = scn4.nextInt();
                    if (tempMarkDB < 0 || tempMarkDB > 100) {
                        System.out.println("Invalid Marks");
                    }
                } while (tempMarkDB < 0 || tempMarkDB > 100);
                marks[i][1] = tempMarkDB;
                countForPrintRanks++;
                chainer++; //continue the chain by adding 1 iteration per 1 added student
                String exitSelection = "U";
                exitSelection = scn4.nextLine();
                System.out.print("Student has been added successfully." );
                while(!(exitSelection.equals("h") || exitSelection.equals("N") || exitSelection.equals("y") ||
                        exitSelection.equals("n"))) {
                    System.out.print("Do you want to add new student (Y/N) : ");
                    exitSelection = scn4.nextLine();
                }
                if(exitSelection.equals("N") || exitSelection.equals("n")){
                    clearConsole();
                    selectOption(idName,marks);
                    break;
                }
                if (!(exitSelection.equals("Y") || exitSelection.equals("N") || exitSelection.equals("y")
                        || exitSelection.equals("n"))){
                    System.out.println("Invalid Option!");
                }
            }
            clearConsole();

        }

    }

    public static void addStudentsMarks(String[][] idName, int[][] marks) {
        Scanner scn5 = new Scanner(System.in);
        for (int i = 0; ; i++) {
            clearConsole();
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("|                                   ADD MARKS                                 |");
            System.out.println("-------------------------------------------------------------------------------");
            boolean point_1 = false;
            boolean point_2 = false;
            int tempMarksPF = 0;
            int tempMarksDB = 0;
            int meter = 0;
            String tempID;
            System.out.print("Enter Student ID : ");
            tempID = scn5.nextLine();
            for (int l = 0; l < 999; l++) {
                if (tempID.equals(idName[l][0])) {
                    point_1 = true;
                    meter = l;
                    break;
                }
            }
            if (point_1) {
                System.out.println("Student name is : " + idName[meter][1]);
                if (marks[meter][0] == 0 || marks[meter][1] == 0) {
                    point_2 = true;
                    do {
                        System.out.print("Enter Programming Fundamentals marks: ");
                        tempMarksPF = scn5.nextInt();
                        if (tempMarksPF < 0 || tempMarksPF > 100) {
                            System.out.println("Invalid Marks");
                        }
                    } while (tempMarksPF < 0 || tempMarksPF > 100);
                    marks[meter][0] = tempMarksPF;
                    do {
                        System.out.print("Enter Database Management Marks : ");
                        tempMarksDB = scn5.nextInt();
                        if (tempMarksDB < 0 || tempMarksDB > 100) {
                            System.out.println("Invalid Marks");
                        }
                    } while (tempMarksDB < 0 || tempMarksDB > 100);
                    marks[meter][1] = tempMarksDB;
                    countForPrintRanks++;

                }


            }
            if (!point_1) {
                System.out.println("Invalid Student ID");
            }
            if (!point_2 && point_1) {
                System.out.println("Marks Already added. If you want to update marks please use [5]Update Marks.");
            }

            if (point_1 && point_2) {
                System.out.print("Student has been added successfully.");
            }
            String exitSelection;
            do{
                System.out.print("Do you want to add marks for add another student (Y/N) : ");
                exitSelection = scn5.nextLine();
                if(exitSelection.equals("N") || exitSelection.equals("n")){
                    clearConsole();
                    selectOption(idName,marks);
                }
                if (!(exitSelection.equals("Y") || exitSelection.equals("N") || exitSelection.equals("y")
                        || exitSelection.equals("n"))){
                    System.out.println("Invalid Option!");
                }
            }while (!(exitSelection.equals("Y") || exitSelection.equals("N") || exitSelection.equals("y") ||
                    exitSelection.equals("n")));
        }
    }

    public static void updateStudentDetails(String[][] idName, int[][] marks) {
        Scanner scn6 = new Scanner(System.in);
        for (int i = 0; i < 1000; i++) {
            clearConsole();
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("|                            UPDATE STUDENT DETAILS                           |");
            System.out.println("-------------------------------------------------------------------------------");
            String tempID;
            int meter = 0;
            boolean point_1 = false;
            boolean point_2 = false;
            System.out.print("Enter Student ID : ");
            tempID = scn6.nextLine();
            for (int j = 0; j < 999; j++) {
                if (tempID.equals(idName[j][0])) {
                    point_1 = true;
                    meter = j;
                    break;
                }

            }
            if (point_1) {
                System.out.println("Student Name : " + idName[meter][1]);
                System.out.println();
                System.out.print("Enter The New Student Name : ");
                idName[meter][1] = scn6.nextLine();
                System.out.println("Student details has been updated successfully!");
            }
            if (!point_1) {
                System.out.println("Invalid Student ID");
            }
            String exitSelection = "v";
            while(!(exitSelection.equals("Y") || exitSelection.equals("N") || exitSelection.equals("y") ||
                    exitSelection.equals("n"))) {
                System.out.print("Do you want to update new student detail? (Y/N) : ");
                exitSelection = scn6.nextLine();
                if (!(exitSelection.equals("Y") || exitSelection.equals("N") || exitSelection.equals("y")
                        || exitSelection.equals("n"))){
                    System.out.println("Invalid Option!");
                }
            }
            if(exitSelection.equals("N") || exitSelection.equals("n")){
                clearConsole();
                selectOption(idName,marks);
                break;
            }
        }

    }

    public static void updateMarks(String[][] idName, int[][] marks) {
        Scanner scn7 = new Scanner(System.in);
        for (int i = 0; ; i++) {
            String tempID;
            int meter = 0;
            int tempMarksPF = 0;
            int tempMarksDB = 0;
            boolean point_2 = false;
            boolean point_1 = false;
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("|                                 UPDATE MARKS                                |");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.print("Enter Student ID : ");
            tempID = scn7.nextLine();
            for (int j = 0; j < 999; j++) {
                if (tempID.equals(idName[j][0])) {
                    point_1 = true;
                    meter = j;
                    break;
                }
            }
            if ((marks[meter][0] == 0 || marks[meter][1] == 0) && point_1) {
                System.out.println("Student Name : " + idName[meter][1]);
                System.out.println("Student Marks yet to be added");
                point_2 = true;
            }
            if (point_1 && !point_2){
                System.out.print("Student Name : " + idName[meter][1]);
                System.out.println();
                System.out.println("Programming Fundamental : " + marks[meter][0]);
                System.out.println("Database Management Marks : " + marks[meter][1]);
                System.out.println();
                do {
                    System.out.print("Enter New Programming Fundamental Marks : ");
                    tempMarksPF = scn7.nextInt();
                    if (tempMarksPF < 0 || tempMarksPF > 100) {
                        System.out.println("Invalid Marks");
                    }
                } while (tempMarksPF < 0 || tempMarksPF > 100);
                marks[meter][0] = tempMarksPF;
                do {
                    System.out.print("Enter Database Management Marks : ");
                    tempMarksDB = scn7.nextInt();
                    if (tempMarksDB < 0 || tempMarksDB > 100) {
                        System.out.println("Invalid Marks");
                    }
                } while (tempMarksDB < 0 || tempMarksDB > 100);
                marks[meter][1] = tempMarksDB;
            }
            if (!point_1) {
                System.out.println("Invalid Student ID");
            }
            System.out.print("Do you want to update another student marks ? (Y/N) : ");
            String exitSelection = scn7.nextLine();
            while (!(exitSelection.equals("y") || exitSelection.equals("n"))) {
                exitSelection = scn7.nextLine();
            }
            if (exitSelection.equals("N") || exitSelection.equals("n")) {
                clearConsole();
                selectOption(idName, marks);
            }
        }

    }

    public static void deleteStudent(String[][] idName, int[][] marks,int[][] totalArray) {
        Scanner scn8 = new Scanner(System.in);
        String tempID;
        int meter = 0;
        for (int i = 0; ; i++) {
            boolean point_1 = false;
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("|                                DELETE STUDENT                               |");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.print("Enter Student ID : ");
            tempID = scn8.nextLine();
            for (int j = 0; j < 999; j++) {
                if (tempID.equals(idName[j][0])) {
                    point_1 = true;
                    meter = j;
                    break;
                }
            }
            if (point_1) {
                idName[meter][0] = null;
                idName[meter][1] = null;
                if(!(marks[meter][0] == 0 && marks[meter][1] == 0)) {
                    marks[meter][0] = 0;
                    marks[meter][1] = 0;
                    totalArray[meter][0] = 0;
                    countForPrintRanks--;
                }
            }
            if (!point_1) {
                System.out.print("Invalid Student ID. Do you want to search again ? (Y/N) : ");
                String exitSelection = scn8.nextLine();
                while (!(exitSelection.equals("y") || exitSelection.equals("n"))) {
                    exitSelection = scn8.nextLine();
                }
                if (exitSelection.equals("N") || exitSelection.equals("n")) {
                    clearConsole();
                    selectOption(idName, marks);
                }
            }
            if (point_1) {
                System.out.println("Student has been deleted successfully.");
                System.out.print("Do you want to delete another student? (Y/N) : ");
                String exitSelection = scn8.nextLine();
                while (!(exitSelection.equals("y") || exitSelection.equals("n"))) {
                    exitSelection = scn8.nextLine();
                }
                if (exitSelection.equals("N") || exitSelection.equals("n")) {
                    clearConsole();
                    selectOption(idName, marks);
                }
            }
            clearConsole();

        }
    }

    public static void printStudentDetails(String[][] idName, int[][] marks,int[][] totalArray) {
        Scanner scn9 = new Scanner(System.in);
        for (int i = 0; ; i++) {
            int tempRank2 = 0;
            String exitSelection;
            String tempID;
            int meter = 0;
            int[][] rankArray = new int[999][2];
            int tempMarksPF = 0;
            int tempMarksDB = 0;

            boolean point_2 = false;
            boolean point_1 = false;
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("|                            PRINT STUDENT DETAILS                            |");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.print("Enter Student ID : ");
            tempID = scn9.nextLine();
            for (int j = 0; j < 999; j++) {
                if (tempID.equals(idName[j][0])) {
                    point_1 = true;
                    meter = j;
                    break;
                }
            }
            if ((marks[meter][0] == 0 || marks[meter][1] == 0) && point_1) {
                System.out.println("Student Name : " + idName[meter][1]);
                System.out.println("Student Marks yet to be added");
                System.out.print("Do you want to add another student detail? (Y/N) : ");
                exitSelection = scn9.nextLine();
                while (!(exitSelection.equals("y") || exitSelection.equals("n"))) {
                    exitSelection = scn9.nextLine();
                }
                if (exitSelection.equals("N") || exitSelection.equals("n")) {
                    clearConsole();
                    selectOption(idName, marks);
                }
                point_2 = true;
            }
            if (point_1 && !point_2) {
                System.out.println("Student Name : " + idName[meter][1]);
                for (int q = 0 ; q < 999 ; q++){
                    totalArray[q][0] = marks[q][0] + marks[q][1];
                    rankArray[q][0] = totalArray[q][0];
                    rankArray[q][1] = q;
                    totalArray[q][1] = q;
                }
                for(int j = 998; j>=0;j--){
                    for(int w = 0 ; w < j; w++){
                        if(rankArray[w][0] < rankArray[w+1][0]){
                            int temp = rankArray[w][0];
                            int tempPrimaryKey = rankArray[w][1];
                            rankArray[w][0] = rankArray[w+1][0];
                            rankArray[w][1] = rankArray[w+1][1];
                            rankArray[w+1][0] = temp;
                            rankArray[w+1][1] = tempPrimaryKey;
                        }
                    }
                }
                //print Rank
                int  e = meter;
                for ( int o = 0 ; o < 999 ; o++){
                    if(totalArray[e][1] == rankArray[o][1]) {
                        tempRank2 = o;
                        break;
                    }
                }

                int total = marks[meter][0] + marks[meter][1];
                double avg = (double) (marks[meter][0] + marks[meter][1]) / 2;
                String place = "";
                tempRank2++;
                if (tempRank2 < 4) {
                    if (tempRank2 == 1 ){
                        place = "(First)";
                    }else if (tempRank2 == 2){
                        place = "(Second)";
                    }else if (tempRank2 == 3){
                        place = "(Third)";
                    }
                }
                String str = String.format("%.02f", avg);
                System.out.println("+------------------------------------------+-----------------+");
                System.out.println("| Programming Fundamental Marks            |              " + marks[meter][0] + " |");
                System.out.println("| Database Management System Marks         |              " + marks[meter][1] + " |");
                if (99 < total) {
                    System.out.println("| Total Marks                              |             " + total + " |");
                } else {
                    System.out.println("| Total Marks                              |              " + total + " |");
                }
                System.out.println("| Avg. Marks                               |           " + str + " |");
                System.out.println("| Rank                                     |       " + (tempRank2)+(String)place+ "  |");
                System.out.println("+------------------------------------------+-----------------+");
                System.out.print("Do you want to add another student detail? (Y/N) : ");
                exitSelection = scn9.nextLine();
                while (!(exitSelection.equals("y") || exitSelection.equals("n") || exitSelection.equals("Y") ||
                        exitSelection.equals("N"))) {
                    System.out.print("Invalid Option! Please Enter (Y/N) : ");
                    exitSelection = scn9.nextLine();
                }
                if (exitSelection.equals("N") || exitSelection.equals("n")) {
                    clearConsole();
                    selectOption(idName, marks);
                }
            }
            if (!point_1 && !point_2) {
                System.out.println("Invalid Student ID!");
                System.out.print("Do you want to search another student detail? (Y/N) : ");
                exitSelection = scn9.nextLine();
                while (!(exitSelection.equals("y") || exitSelection.equals("n"))) {
                    exitSelection = scn9.nextLine();
                }
                if (exitSelection.equals("N") || exitSelection.equals("n")) {
                    clearConsole();
                    selectOption(idName, marks);
                }
            }
            clearConsole();
        }

    }

    public static void printStudentRanks (String[][] idName, int[][] marks,int[][] totalArray){
        Scanner scn10 = new Scanner(System.in);
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("|                            PRINT STUDENT DETAILS                            |");
        System.out.println("-------------------------------------------------------------------------------");
        boolean point_1 = false;
        boolean point_2 = false;
        double[] averageArray = new double[999];
        int[][] rankArray = new int[999][2];
        for (int q = 0 ; q < 999 ; q++){
            totalArray[q][0] = marks[q][0] + marks[q][1];
            averageArray[q] = (totalArray[q][0])/(double)2;
            rankArray[q][0] = totalArray[q][0];
            rankArray[q][1] = q;
            totalArray[q][1] = q;
        }
        for(int j = 998; j>=0;j--){
            for(int w = 0 ; w < j; w++){
                if(rankArray[w][0] < rankArray[w+1][0]){
                    int temp = rankArray[w][0];
                    int tempPrimaryKey = rankArray[w][1];
                    rankArray[w][0] = rankArray[w+1][0];
                    rankArray[w][1] = rankArray[w+1][1];
                    rankArray[w+1][0] = temp;
                    rankArray[w+1][1] = tempPrimaryKey;
                }
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("+-------+---------------+-------------------------------+---------------+");
        System.out.println("|Rank\t|ID\t\t|Name\t\t\t\t|Total Marks\t\t|Avg. Marks\t|");
        System.out.println("+-------+---------------+-------------------------------+---------------+");
        for (int i = 0 ; i < countForPrintRanks ; i++){
            for (int j = 0; j < 999 ; j++){
                if (rankArray[i][1] == totalArray[j][1]){
                    System.out.println("|"+(i+1)+"\t\t|\t"+idName[j][0]+"\t|"+idName[j][1]+"\t\t\t\t|"+
                            totalArray[j][0]+"\t\t\t|"+averageArray[j]+ "\t\t|");
                    break;
                }
            }
        }
        System.out.println("+-------+---------------+-------------------------------+---------------+");
        System.out.println();
        System.out.print("Do you want to go back to main menu? (Y) : ");
        String exitSelection = scn10.nextLine();
        while (!(exitSelection.equals("y") || (exitSelection.equals("Y")))){
            System.out.print("Invalid Option! Please enter ( Y ) if you want to redirect home.");
            exitSelection = scn10.nextLine();
        }
        if (exitSelection.equals("y") || exitSelection.equals("Y")) {
            clearConsole();
            selectOption(idName, marks);
        }

    }
    public static void bestInPF(String[][] idName, int[][] marks){
        Scanner scn11 = new Scanner(System.in);
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("|                       BEST IN PROGRAMMING FUNDAMENTALS                      |");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.println("+---------------+-------------------------------+---------------+---------------+");
        System.out.println("|ID\t\t|Name\t\t\t\t|PF Marks\t|DB Marks\t|");
        System.out.println("+---------------+-------------------------------+---------------+---------------+");
        int[][] rankArray = new int[999][2];
        for (int q = 0 ; q < 999 ; q++){
            rankArray[q][0] = marks[q][0];
            rankArray[q][1] = q;
            marks[q][2] = q;
        }
        for(int j = 998; j>=0;j--){
            for(int w = 0 ; w < j; w++){
                if(rankArray[w][0] < rankArray[w+1][0]){
                    int temp = rankArray[w][0];
                    int tempPrimaryKey = rankArray[w][1];
                    rankArray[w][0] = rankArray[w+1][0];
                    rankArray[w][1] = rankArray[w+1][1];
                    rankArray[w+1][0] = temp;
                    rankArray[w+1][1] = tempPrimaryKey;
                }
            }
        }
        for (int f = 0; f < countForPrintRanks ;f++) {
            for (int j = 0 ; j < 999 ; j++ ){
                if (rankArray[f][1] == marks[j][2]){
                    System.out.println("| "+idName[j][0]+"\t\t|"+idName[j][1]+"\t\t\t\t|"+rankArray[f][0]+"\t\t|"
                            +marks[j][1]+"\t\t|");
                    break;
                }
            }
        }
        System.out.println();
        System.out.println("+---------------+-------------------------------+---------------+---------------+");
        System.out.println();
        System.out.println();
        System.out.print("Do you want to go back to main menu? (Y) : ");
        String exitSelection = scn11.nextLine();
        while (!(exitSelection.equals("y") || (exitSelection.equals("Y")))){
            System.out.print("Invalid Option! Please enter ( Y ) if you want to redirect home.");
            exitSelection = scn11.nextLine();
        }
        if (exitSelection.equals("y") || exitSelection.equals("Y")) {
            clearConsole();
            selectOption(idName, marks);
        }
    }
    public static void bestInDB (String[][] idName, int[][] marks){
        Scanner scn12 = new Scanner(System.in);
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("|                      BEST IN DATABASE MANAGEMENT SYSTEM                     |");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.println("+---------------+-------------------------------+---------------+---------------+");
        System.out.println("|ID\t\t|Name\t\t\t\t|DB Marks\t|PF Marks\t|");
        System.out.println("+---------------+-------------------------------+---------------+---------------+");
        int[][] rankArray = new int[999][2];
        for (int q = 0 ; q < 999 ; q++){
            rankArray[q][0] = marks[q][1];
            rankArray[q][1] = q;
            marks[q][2] = q;
        }
        for(int j = 998; j>=0;j--){
            for(int w = 0 ; w < j; w++){
                if(rankArray[w][0] < rankArray[w+1][0]){
                    int temp = rankArray[w][0];
                    int tempPrimaryKey = rankArray[w][1];
                    rankArray[w][0] = rankArray[w+1][0];
                    rankArray[w][1] = rankArray[w+1][1];
                    rankArray[w+1][0] = temp;
                    rankArray[w+1][1] = tempPrimaryKey;
                }
            }
        }
        for (int f = 0; f < countForPrintRanks ;f++) {
            for (int j = 0 ; j < 999 ; j++ ){
                if (rankArray[f][1] == marks[j][2]){
                    System.out.println("| "+idName[j][0]+"\t\t|"+idName[j][1]+"\t\t\t\t|"+rankArray[f][0]+"\t\t|"
                            +marks[j][0]+"\t\t|");
                    break;
                }
            }
        }
        System.out.println("+---------------+-------------------------------+---------------+---------------+");
        System.out.println();
        System.out.print("Do you want to go back to main menu? (Y) : ");
        String exitSelection = scn12.nextLine();
        while (!(exitSelection.equals("y") || (exitSelection.equals("Y")))){
            System.out.print("Invalid Option! Please enter ( Y ) if you want to redirect home.");
            exitSelection = scn12.nextLine();
        }
        if (exitSelection.equals("y") || exitSelection.equals("Y")) {
            clearConsole();
            selectOption(idName, marks);
        }
    }
}
