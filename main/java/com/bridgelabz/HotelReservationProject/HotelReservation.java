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
        return this.getCheapestHotel(hotelArray);
    }

    public Result getCheapestHotel(ArrayList<HotelInfos> hotelArray){ //compares total costs of hotels
        Optional<HotelInfos> cheapestHotel = hotelArray.stream().min(Comparator.comparingInt(hotel -> hotel.getTotalCost()));
        Result result = new Result();
        result.setHotelName(cheapestHotel.get().getHotelName());
        result.setTotalCost(cheapestHotel.get().getTotalCost());
        System.out.println(result.getHotelName() + result.getTotalCost());
        return result;
    }

}
