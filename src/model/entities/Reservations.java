package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservations {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservations(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Erro! A data de entrada e saída tem que ser futuras.";
		}
		if (!checkOut.after(checkIn)) {
			return "Data inválida: Data de entrada não pode ser menor que a data de saída.";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;

	}

	@Override
	public String toString() {
		return "Reservation: Room: " + roomNumber + ", CheckIn: " + sdf.format(checkIn) + ", checkOut: "
				+ sdf.format(checkOut) + ", duration: " + duration() + " Nights ";
	}
}
