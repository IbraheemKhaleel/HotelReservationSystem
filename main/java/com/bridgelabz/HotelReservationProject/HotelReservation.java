package com.bridgelabz.HotelReservationProject;

public class HotelReservation  {

    HotelInfos addHotel(String name , String type , int weekday , int weekend) {
        return new HotelInfos(name , type , weekday , weekend);
    }
}
