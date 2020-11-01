package com.bridgelabz.HotelReservationProject;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class HotelReservationTest {
    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredName() {
        HotelReservation hotelReservation = new HotelReservation() ;
        HotelInfos newHotel = hotelReservation.addHotel("Lakewood" , "Normal" , 110 ) ;
        Assert.assertEquals(newHotel.getHotelName() , "Lakewood") ;
    }

    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredCustomerType() {
        HotelReservation hotelReservation = new HotelReservation() ;
        HotelInfos newHotel = hotelReservation.addHotel("Lakewood" , "Normal" , 110 ) ;
        Assert.assertEquals(newHotel.getTypeOfCustomer() , "Normal") ;
    }

    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredWeekdayRate() {
        HotelReservation hotelReservation = new HotelReservation() ;
        HotelInfos newHotel = hotelReservation.addHotel("Lakewood" , "Normal" , 110 ) ;
        Assert.assertEquals(newHotel.getWeekdayRate() , 110) ;
    }

    @Test
    public void givenDateRange_WhenAddedForHotel_ShouldReturnCheapestHotelRate() {
        HotelReservation hotelReservation = new HotelReservation();
        ArrayList<HotelInfos> hotelArray = new ArrayList<>();
        hotelArray.add(hotelReservation.addHotel("Lakewood" , "Normal" , 110  ));
        hotelArray.add(hotelReservation.addHotel("Bridgewood" , "Normal" , 160  ));
        hotelArray.add(hotelReservation.addHotel("Ridgewood" , "Normal" , 220  ));
        Result cheapestHotel = hotelReservation.findCheapestHotel(hotelArray,"10092020" , "12092020");
        Assert.assertEquals(220 , cheapestHotel.getTotalCost());

    }

}