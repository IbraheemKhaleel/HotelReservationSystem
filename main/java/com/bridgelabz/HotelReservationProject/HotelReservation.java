package com.bridgelabz.HotelReservationProject;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.*;

public class HotelReservation  {

    HotelInfos addHotel(String hotelName , String typeofCustomer , int weekdayRate , int weekendRate , int rating) {
        return new HotelInfos(hotelName , typeofCustomer , weekdayRate ,weekendRate, rating);
    }

    public Result getCheapestHotel(List<HotelInfos> hotelList , String startingDate , String endingDate){

        this.setCost(hotelList, startingDate , endingDate);
        Optional<HotelInfos> cheapestHotel = hotelList.stream().min(Comparator.comparingInt(hotel -> hotel.getTotalCost()));
        Result result = new Result();
        result.setHotelName(cheapestHotel.get().getHotelName());
        result.setTotalCost(cheapestHotel.get().getTotalCost());
        return result;
    }

    public void setCost(List<HotelInfos> hotelList , String startingDate , String endingDate) {

        Integer cost;
        LocalDate checkingIn = null;
        LocalDate checkingOut = null;

        try {
            checkingIn = LocalDate.parse(startingDate);
        } catch (Exception e) {
            System.out.println("Please enter proper starting date");
        }
        try {
            checkingOut = LocalDate.parse(endingDate);
        } catch (Exception e) {
            System.out.println("Please enter proper ending date");
        }
        long difference = Duration.between(checkingIn.atStartOfDay() , checkingOut.atStartOfDay()).toDays();

        for(HotelInfos hotel : hotelList) {
            cost = hotel.getTotalRate(checkingIn, checkingOut, difference);
            hotel.setTotalCost(cost);
        }
    }

    public Result findCheapestBestRatedHotel(List<HotelInfos> hotelList , String startingDate ,String endingDate) {
        Result result;
        result = this.getCheapestHotel(hotelList , startingDate , endingDate);
        Optional<HotelInfos> maximumCostHotel = hotelList.stream().max(Comparator.comparingInt(hotel -> hotel.getTotalCost()));
        Optional<HotelInfos> minimumRatingHotel = hotelList.stream().min(Comparator.comparingInt(hotel -> hotel.getRating()));
        for (HotelInfos hotel : hotelList) {
            if (hotel.getTotalCost() < maximumCostHotel.get().getTotalCost() && hotel.getRating() > minimumRatingHotel.get().getRating()) {
                result.setRating(hotel.getRating());
                result.setHotelName(hotel.getHotelName());
                result.setTotalCost(hotel.getTotalCost());
            }
        }
        return result;
    }

    public Result findBestRatedHotel(List<HotelInfos> hotelList , String startingDate , String endingDate) {

        Result result = new Result();
        this.setCost(hotelList , startingDate , endingDate);
        Optional<HotelInfos> maximumRatingHotel = hotelList.stream().max(Comparator.comparingInt(hotel -> hotel.getRating()));
        result.setHotelName(maximumRatingHotel.get().getHotelName());
        result.setTotalCost(maximumRatingHotel.get().getTotalCost());
        result.setRating(maximumRatingHotel.get().getRating());
        return result;
    }
}

