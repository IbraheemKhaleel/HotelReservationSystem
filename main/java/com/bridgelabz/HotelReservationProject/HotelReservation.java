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
    public Result findCheapestHotel(ArrayList<HotelInfos> hotelArray , String dateS , String dateE) {  //gets total cost for each hotel and returns cheapest hotel

        Integer cost;
        LocalDate dateStart = null , dateEnd = null;

        try {
            dateStart = LocalDate.parse(dateS);
        } catch (Exception e) {
            System.out.println("Please enter proper starting date");
        }
        try {
            dateEnd = LocalDate.parse(dateE);
        } catch (Exception e) {
            System.out.println("Please enter proper ending date");
        }
        long difference = Duration.between(dateStart.atStartOfDay() , dateEnd.atStartOfDay()).toDays();

        for(HotelInfos hotelInfos : hotelArray) {
            cost = hotelInfos.getTotalRate(dateStart, dateEnd, difference);
            hotelInfos.setTotalCost(cost);
        }
        Result result = this.getCheapestHotel(hotelArray);
        result = this.cheapestBestRatedHotel(hotelArray , result);
        return result;
    }
    // method to get the cheapest hotel
    public Result getCheapestHotel(ArrayList<HotelInfos> hotelArray){ //compares total costs of hotels
        Optional<HotelInfos> cheapestHotel = hotelArray.stream().min(Comparator.comparingInt(hotel -> hotel.getTotalCost()));
        Result result = new Result();
        result.setHotelName(cheapestHotel.get().getHotelName());
        result.setTotalCost(cheapestHotel.get().getTotalCost());
        System.out.println(result.getHotelName() + result.getTotalCost());
        return result;
    }
    // method to get the cheapest and best rated hotel
    public Result cheapestBestRatedHotel(ArrayList<HotelInfos> hotelArray , Result result) {
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

}
