package CarRental.Payement;

import CarRental.Reservation.Reservation;

public class Invoice {
    Reservation reservation;
    double totalBillAmount;
    boolean isBillPaid;
    public Invoice(Reservation reservation){
        this.reservation = reservation;
        this.totalBillAmount = computeBillAmount();
        isBillPaid = false; // default
        System.out.printf("Invoice: reservation ID: %d, amount: %.2f\n", reservation.reservationID, totalBillAmount);
    }

    private double computeBillAmount(){
        return reservation.getvehicleCharges().getVehicleRentAmount();
    }
}
