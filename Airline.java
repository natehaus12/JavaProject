import java.util.Scanner;
import java.io.*;
import java.io.FileWriter;

public class Airline {
    static void tickets(){ //this function will allow you to book a ticket
        System.out.println("Here are the available tickets.");

        try{
            File tickets = new File("tickets.txt"); //initialize tickets file
            Scanner reader = new Scanner(tickets);

            while (reader.hasNextLine()){ //loop for the length of the file
                String data = reader.nextLine();
                System.out.println(data);//print the tickets

            }
        reader.close();
        } catch (FileNotFoundException e){
        System.out.println("Error");
        e.printStackTrace();
        }

        System.out.println("Please Enter the ticket number you would like to reserve.");

        Scanner resernum = new Scanner(System.in); // initalize reservaiton number and username
        System.out.println("Enter number: ");
        String reservationNum = resernum.nextLine();
        Scanner name = new Scanner(System.in);
        System.out.println("Please Enter a username: ");
        String userName = name.nextLine();

        File find = new File("tickets.txt"); //initailize ticekts file again
        try{
       
            Scanner scanner = new Scanner(find);
            int linNum = 0;//these are counters
            int wrong = 0;
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                linNum++;
                if(line.contains("Ticket #: " + reservationNum)){ //find the reservation number
                    FileWriter writer = new FileWriter("reservations.txt", true); //initialize file
                    writer.write("Username and Reservation Number:\n" + userName + "\n" + reservationNum + "\n"); // add info to file
                    writer.close();
                    System.out.println("Success!");
                }
                else{
                    wrong += 1; //error check for invalid ticket numbers
                }

            }
         if (wrong >= linNum){ //check for invalid ticket number
            System.out.println("Invalid Ticket #");
        }


        }catch (IOException e){
                    System.out.println("Error");

        }
        }
        
    static void reservations(){ //this fucntion will allow you to check for your existing reservation
        Scanner input = new Scanner(System.in); //initailie username variable
        System.out.println("Please Enter your username: ");
        String userName = input.nextLine();

        File find = new File("reservations.txt"); //initailize reservations txt
        String foundNumber = "";
        int wrong = 0;

        try{
       
            Scanner scanner = new Scanner(find);
            int linNum = 0;
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                linNum++;
                if(line.equals(userName)){
                    foundNumber = scanner.nextLine(); // find the reservation number
                    
                }else {
                    wrong += 1; //error counter
                }

                }
                if(wrong == linNum){ //error checking
                    System.out.println("Invalid Username");
                }


        }catch (IOException e){
                    System.out.println("Error");

        }

        File finder = new File("tickets.txt"); //intialize tickets file
        try{
       
            Scanner last = new Scanner(finder);
            while (last.hasNextLine()){
                String line = last.nextLine();
                if(line.contains("Ticket #: " + foundNumber)){ // find the correct ticket number
                    System.out.println("Ticket Information: " + last.nextLine()); // print that line
                }
            }

        }catch (IOException e){
                    System.out.println("Error");

        }
    
    }
    public static void main(String[] args) { // this will act as a menu for the user
        System.out.println("Welcome to House Airlines."); //diplay the menu
        System.out.println("If you need to book a ticket, enter 1.");
        System.out.println("If you need to check an existing reservation, enter 2.");

        Scanner obj = new Scanner(System.in);
        System.out.println("Enter number: ");
        int decision = obj.nextInt(); //get the user input

        if (decision == 1){
            tickets(); //book a ticket
        } else if (decision == 2){
            reservations(); // check a reservation
        } else{
            System.out.println("Invalid Input."); //error checking
        }
    }

    }
  