package com.bridgelabz.HotelReservationProject;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HotelReservationTest {
    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnName() {
        HotelReservation hotelReservation = new HotelReservation() ;
        HotelInfos newHotel = hotelReservation.addHotel("Lakewood" , "Normal" , 110 ,90 , 3) ;
        Assert.assertEquals(newHotel.getHotelName() , "Lakewood") ;
    }

    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnCustomerType() {
        HotelReservation hotelReservation = new HotelReservation() ;
        HotelInfos newHotel = hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 60,3) ;
        Assert.assertEquals(newHotel.getTypeOfCustomer() , "Normal") ;
    }

    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnWeekdayRate() {
        HotelReservation hotelReservation = new HotelReservation() ;
        HotelInfos newHotel = hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 150,3) ;
        Assert.assertTrue(newHotel.getWeekdayRate().equals(110)); ;
    }


    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShoulReturnWeekendRate() {
        HotelReservation hotelReservation = new HotelReservation();
        HotelInfos firstHotel = hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 ,3);
        HotelInfos secondHotel = hotelReservation.addHotel("Bridgewood" , "Normal" , 160 , 50 ,4);
        HotelInfos thirdHotel = hotelReservation.addHotel("Ridgewood" , "Normal" , 220 , 150 ,5);
        Assert.assertTrue( thirdHotel.getWeekendRate().equals(150));
    }

    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnRating() {
        HotelReservation hotelReservation = new HotelReservation();
        HotelInfos newHotel = hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 , 3);
        Assert.assertTrue(newHotel.getRating().equals(3));
    }
    @Test
    public void givenDateRange_WhenAddedForHotel_ShouldReturnCheapestAndBestRatedHotel() {
        HotelReservation hotelReservation = new HotelReservation();
        List<HotelInfos> hotelList = new ArrayList<>();
        hotelList.add(hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 , 3));
        hotelList.add(hotelReservation.addHotel("Bridgewood" , "Normal" , 160 , 50 , 4));
        hotelList.add(hotelReservation.addHotel("Ridgewood" , "Normal" , 220 , 150  , 5));
        Result cheapestBestRatedHotel = hotelReservation.findCheapestBestRatedHotel(hotelList , "2020-09-14" , "2020-09-18");
        Assert.assertEquals("Bridgewood" , cheapestBestRatedHotel.getHotelName());
    }

    //checking best rated hotel
    @Test
    public void givenDateRange_WhenAddedForHotel_ShouldReturnBestRatingHotelName() {
        HotelReservation hotelReservation = new HotelReservation();
        List<HotelInfos> hotelList = new ArrayList<>();
        hotelList.add(hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 , 3));
        hotelList.add(hotelReservation.addHotel("Bridgewood" , "Normal" , 160 , 50 , 4));
        hotelList.add(hotelReservation.addHotel("Ridgewood" , "Normal" , 220 , 150  , 5));
        Result bestRatedHotel = hotelReservation.findBestRatedHotel(hotelList , "2020-09-11" , "2020-09-12");
        Assert.assertEquals("Ridgewood" , bestRatedHotel.getHotelName());
    }
}