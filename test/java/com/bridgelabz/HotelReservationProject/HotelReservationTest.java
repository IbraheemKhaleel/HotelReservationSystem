package com.bridgelabz.HotelReservationProject;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class HotelReservationTest {
    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredName() {
        HotelReservation hotelReservation = new HotelReservation() ;
        HotelInfos newHotel = hotelReservation.addHotel("Lakewood" , "Normal" , 110 ,90 , 3) ;
        Assert.assertEquals(newHotel.getHotelName() , "Lakewood") ;
    }

    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredCustomerType() {
        HotelReservation hotelReservation = new HotelReservation() ;
        HotelInfos newHotel = hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 60,3) ;
        Assert.assertEquals(newHotel.getTypeOfCustomer() , "Normal") ;
    }

    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredWeekdayRate() {
        HotelReservation hotelReservation = new HotelReservation() ;
        HotelInfos newHotel = hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 150,3) ;
        Assert.assertTrue(newHotel.getWeekdayRate().equals(110)); ;
    }


    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShoulReturnEnteredWeekendRate() {
        HotelReservation hotelReservation = new HotelReservation();
        HotelInfos firstHotel = hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 ,3);
        HotelInfos secondHotel = hotelReservation.addHotel("Bridgewood" , "Normal" , 160 , 50 ,4);
        HotelInfos thirdHotel = hotelReservation.addHotel("Ridgewood" , "Normal" , 220 , 150 ,5);
        Assert.assertTrue( secondHotel.getWeekendRate().equals(50));
    }

    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredRating() {
        HotelReservation hotelReservation = new HotelReservation();
        HotelInfos newHotel = hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 , 3);
        Assert.assertTrue(newHotel.getRating().equals(3));
    }
    @Test
    public void givenDateRange_WhenAddedForHotel_ShouldReturnCheapestHotelRateOnBasisOfCostAndRating() {
        HotelReservation hotelReservation = new HotelReservation();
        ArrayList<HotelInfos> hotelArray = new ArrayList<>();
        hotelArray.add(hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 , 3));
        hotelArray.add(hotelReservation.addHotel("Bridgewood" , "Normal" , 160 , 50 , 4));
        hotelArray.add(hotelReservation.addHotel("Ridgewood" , "Normal" , 220 , 150  , 5));
        Result cheapestBestRatedHotel = hotelReservation.findCheapestBestRatedHotel(hotelArray , "2020-09-11" , "2020-09-12");
        Assert.assertEquals("Bridgewood" , cheapestBestRatedHotel.getHotelName());
    }

    //checking best rated hotel
    @Test
    public void givenDateRange_WhenAddedForHotel_ShouldReturnHotelNameOnBasisOfBestRating() {
        HotelReservation hotelReservation = new HotelReservation();
        ArrayList<HotelInfos> hotelArray = new ArrayList<>();
        hotelArray.add(hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 , 3));
        hotelArray.add(hotelReservation.addHotel("Bridgewood" , "Normal" , 160 , 50 , 4));
        hotelArray.add(hotelReservation.addHotel("Ridgewood" , "Normal" , 220 , 150  , 5));
        Result bestRatedHotel = hotelReservation.findBestRatedHotel(hotelArray , "2020-09-11" , "2020-09-12");
        Assert.assertEquals("Ridgewood" , bestRatedHotel.getHotelName());
    }
}