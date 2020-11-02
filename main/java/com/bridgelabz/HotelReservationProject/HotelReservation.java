package com.bridgelabz.HotelReservationProject;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Optional;

public class HotelReservation  {

    HotelInfos addHotel(String name , String type , int weekday , int weekend , int rating) {
        return new HotelInfos(name , type , weekday ,weekend, rating);
    }
    // method to find cheapest hotel in the basis of given date range
    public void setCost(ArrayList<HotelInfos> hotelArray , String startingDate , String endingDate) {

        Integer cost;
        LocalDate dateStart = null , dateEnd = null;

        try {
            dateStart = LocalDate.parse(startingDate);
        } catch (Exception e) {
            System.out.println("Please enter proper starting date");
        }
        try {
            dateEnd = LocalDate.parse(endingDate);
        } catch (Exception e) {
            System.out.println("Please enter proper ending date");
        }
        long difference = Duration.between(dateStart.atStartOfDay() , dateEnd.atStartOfDay()).toDays();

        for(HotelInfos hotel : hotelArray) {
            cost = hotel.getTotalRate(dateStart, dateEnd, difference);
            hotel.setTotalCost(cost);
        }
    }
    public Result getCheapestHotel(ArrayList<HotelInfos> hotelArray , String dateS , String dateE){

        this.setCost(hotelArray , dateS , dateE);
        Optional<HotelInfos> cheapestHotel = hotelArray.stream().min(Comparator.comparingInt(hotel -> hotel.getTotalCost()));
        Result result = new Result();
        result.setHotelName(cheapestHotel.get().getHotelName());
        result.setTotalCost(cheapestHotel.get().getTotalCost());
        return result;
    }

    public Result findCheapestBestRatedHotel(ArrayList<HotelInfos> hotelArray , String dateS ,String dateE) {
        Result result;
        result = this.getCheapestHotel(hotelArray , dateS , dateE);
        Optional<HotelInfos> maxCostHotel = hotelArray.stream().max(Comparator.comparingInt(hotel -> hotel.getTotalCost()));
        Optional<HotelInfos> minRatingHotel = hotelArray.stream().min(Comparator.comparingInt(hotel -> hotel.getRating()));
        for (HotelInfos hotel : hotelArray) {
            if (hotel.getTotalCost() < maxCostHotel.get().getTotalCost() && hotel.getRating() > minRatingHotel.get().getRating()) {
                result.setRating(hotel.getRating());
                result.setHotelName(hotel.getHotelName());
                result.setTotalCost(hotel.getTotalCost());
            }
        }
        return result;
    }

    public Result findBestRatedHotel(ArrayList<HotelInfos> hotelArray , String dateS , String dateE) {

        Result result = new Result();
        this.setCost(hotelArray , dateS , dateE);
        Optional<HotelInfos> maxRatingHotel = hotelArray.stream().max(Comparator.comparingInt(hotel -> hotel.getRating()));
        result.setHotelName(maxRatingHotel.get().getHotelName());
        result.setTotalCost(maxRatingHotel.get().getTotalCost());
        result.setRating(maxRatingHotel.get().getRating());
        return result;
    }
}

