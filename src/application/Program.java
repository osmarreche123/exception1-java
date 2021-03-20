package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Room number: ");
            int number =  sc.nextInt();
            System.out.print("Check-in (dd/mm/yyyy): ");
            Date checkin = sdf.parse(sc.next());
            System.out.print("Check-out (dd/mm/yyyy): ");
            Date checkout = sdf.parse(sc.next());



            Reservation reservation = new Reservation(number, checkin, checkout);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in (dd/mm/yyyy): ");
            checkin = sdf.parse(sc.next());
            System.out.print("Check-out (dd/mm/yyyy): ");
            checkout = sdf.parse(sc.next());

            reservation.updateDates(checkin, checkout);
            System.out.println("Reservation: " + reservation);
        }
        catch (ParseException e){
            System.out.println("Invalid Date Format");
        }
        catch (DomainException e){
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (InputMismatchException e){
            System.out.println("Invalid Format to int: " );
        }


        sc.close();
    }
}
