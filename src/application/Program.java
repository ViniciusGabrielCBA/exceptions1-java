package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservations;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Room Number: ");
		int number = sc.nextInt();
		System.out.print("Chek-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Chek-Out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Data inválida: Data de entrada não pode ser menor que a data de saída.");
		} else {
			Reservations reservation = new Reservations(number, checkIn, checkOut);
			System.out.println(reservation);

			System.out.println();
			System.out.println("Enter data to update the reservations");
			System.out.print("Chek-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Chek-Out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Erro! A data de entrada e saída tem que ser futuras.");
			} else {
				if (!checkOut.after(checkIn)) {
					System.out.println("Data inválida: Data de entrada não pode ser menor que a data de saída.");
				} else {
					reservation.updateDates(checkIn, checkOut);
					System.out.println(reservation);
				}
			}
		}

		sc.close();
	}

}
