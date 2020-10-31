package com.bridgelabz.HotelReservationProject;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {
    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredName() {
        HotelReservation hotelReservation = new HotelReservation();
        HotelInfos newHotel = hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 );
        Assert.assertEquals(newHotel.hotelName , "Lakewood");
    }

    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredCustomerType() {
        HotelReservation hotelReservation = new HotelReservation();
        HotelInfos newHotel = hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 );
        Assert.assertEquals(newHotel.typeOfCustomer , "Normal");
    }

    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredWeekdayRate() {
        HotelReservation hotelReservation = new HotelReservation();
        HotelInfos newHotel = hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 );
        Assert.assertEquals(newHotel.weekRate , 110);
    }

    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredWeekDayRate() {
        HotelReservation hotelReservation = new HotelReservation();
        HotelInfos newHotel = hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 );
        Assert.assertEquals(newHotel.weekendRate , 90);
    }

}

