package com.bridgelabz.HotelReservationProject;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class HotelReservationTest {
    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredName() {
        HotelReservation hotelReservation = new HotelReservation() ;
        HotelInfos newHotel = hotelReservation.addHotel("Lakewood" , "Normal" , 110 ,90) ;
        Assert.assertEquals(newHotel.getHotelName() , "Lakewood") ;
    }

    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredCustomerType() {
        HotelReservation hotelReservation = new HotelReservation() ;
        HotelInfos newHotel = hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 60) ;
        Assert.assertEquals(newHotel.getTypeOfCustomer() , "Normal") ;
    }

    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredWeekdayRate() {
        HotelReservation hotelReservation = new HotelReservation() ;
        HotelInfos newHotel = hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 150) ;
        Assert.assertTrue(newHotel.getWeekdayRate().equals(110)); ;
    }

    @Test
    public void givenDateRange_WhenAddedForHotel_ShouldReturnCheapestHotelName() {
        HotelReservation hotelReservation = new HotelReservation();
        ArrayList<HotelInfos> hotelArray = new ArrayList<>();
        hotelArray.add(hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 ));
        hotelArray.add(hotelReservation.addHotel("Bridgewood" , "Normal" , 160 , 60 ));
        hotelArray.add(hotelReservation.addHotel("Ridgewood" , "Normal" , 220 , 150 ));
        Result cheapestHotel = hotelReservation.findCheapestHotel(hotelArray,"2020-09-11" , "2020-09-12");
        Assert.assertEquals("Lakewood" , cheapestHotel.getHotelName());

    }

    @Test
    public void givenDateRange_WhenAddedForHotel_ShouldReturnCheapestHotelRate() {
        HotelReservation hotelReservation = new HotelReservation();
        ArrayList<HotelInfos> hotelArray = new ArrayList<>();
        hotelArray.add(hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90));
        hotelArray.add(hotelReservation.addHotel("Bridgewood" , "Normal" , 160 , 60));
        hotelArray.add(hotelReservation.addHotel("Ridgewood" , "Normal" , 220 , 150 ));
        Result cheapestHotel = hotelReservation.findCheapestHotel(hotelArray,"2020-09-10" , "2020-09-12");
        Assert.assertEquals(110+90+110 , cheapestHotel.getTotalCost());

    }
    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShoulReturnEnteredWeekendRate() {
        HotelReservation hotelReservation = new HotelReservation();
        HotelInfos firstHotel = hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 );
        HotelInfos secondHotel = hotelReservation.addHotel("Bridgewood" , "Normal" , 160 , 50 );
        HotelInfos thirdHotel = hotelReservation.addHotel("Ridgewood" , "Normal" , 220 , 150 );
        Assert.assertTrue( secondHotel.getWeekendRate().equals(50));
    }

    @Test
    public void givenDateRange_WhenAddedForHotel_ShouldReturnCheapestHotelRateOnBasisOfWeekdaysAndWeekends() {
        HotelReservation hotelReservation = new HotelReservation();
        ArrayList<HotelInfos> hotelArray = new ArrayList<>();
        hotelArray.add(hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 ));
        hotelArray.add(hotelReservation.addHotel("Bridgewood" , "Normal" , 160 , 50 ));
        hotelArray.add(hotelReservation.addHotel("Ridgewood" , "Normal" , 220 , 150  ));
        Result cheapestHotel = hotelReservation.findCheapestHotel(hotelArray , "2020-09-11" , "2020-09-14");
        Assert.assertEquals("Lakewood" , cheapestHotel.getHotelName());
    }


}