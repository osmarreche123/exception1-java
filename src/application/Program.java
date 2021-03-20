package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        System.out.print("Room number: ");
        int number =  sc.nextInt();
        System.out.print("Check-in (dd/mm/yyyy): ");
        Date checkin = sdf.parse(sc.next());
        System.out.print("Check-out (dd/mm/yyyy): ");
        Date checkout = sdf.parse(sc.next());

        if (!checkout.after(checkin)){
            System.out.println("Error in reservation: Check-Out date must be after check-in date");
        }
        else {
            Reservation reservation = new Reservation(number, checkin, checkout);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in (dd/mm/yyyy): ");
            checkin = sdf.parse(sc.next());
            System.out.print("Check-out (dd/mm/yyyy): ");
            checkout = sdf.parse(sc.next());

            Date now = new Date();

            if(checkin.before(now) || checkout.before(now)){
                System.out.println("Error in reservation dates for update must be future dates");
            }
            else if (!checkout.after(checkin)){
                System.out.println("Error in reservation: Check-Out date must be after check-in date");
            }
            else {
                reservation.updateDates(checkin,checkout);
                System.out.println("Reservation: " + reservation);
            }

        }






        sc.close();
    }
}
