package com.bridgelabz.HotelReservationProject;

public class HotelInfos {
    String hotelName;
    String typeOfCustomer;
    int weekRate;
    int weekendRate;

    public HotelInfos(String hotelName, String typeOfCustomer, int weekRate, int weekendRate) {
        this.hotelName = hotelName;
        this.typeOfCustomer = typeOfCustomer;
        this.weekRate = weekRate;
        this.weekendRate = weekendRate;
    }
}
