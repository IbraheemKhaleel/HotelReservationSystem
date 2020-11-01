package com.bridgelabz.HotelReservationProject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Optional;

public class HotelReservation  {

    HotelInfos addHotel(String name , String type , int weekday) {
        return new HotelInfos(name , type , weekday);
    }
    public Result findCheapestHotel(ArrayList<HotelInfos> hotelArray , String dateStarting , String dateEnding) {
        int daysInBetween = getDaysInBetween(dateStarting , dateEnding);
        Result cheapestHotel = getCheapestHotel(daysInBetween , hotelArray);
        System.out.println("Hotel Name: " + cheapestHotel.getHotelName() + " Total Rate is: " + cheapestHotel.getTotalCost());
        return cheapestHotel;
    }

    private static int getDaysInBetween(String dateStarting , String dateEnding){

        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
        Date dateStart = new Date();
        try {
            dateStart = formatter.parse(dateStarting);
        } catch (Exception e) {
            //empty catch
        }
        Date dateEnd = new Date();
        try {
            dateEnd = formatter.parse(dateEnding);
        } catch (Exception e) {
            //empty catch
        }

        long difference = dateEnd.getTime() - dateStart.getTime();
        System.out.println(difference);
        int daysInBetween = (int) Math.ceil(difference / (1000 * 60 * 60 * 24));
        return daysInBetween;
    }

    private static Result getCheapestHotel(int daysInBetween , ArrayList<HotelInfos> hotelArray) {
        int currentHotelCost;
        for (HotelInfos currentHotel : hotelArray) {     // set weekday cost for each hotel
            currentHotelCost = daysInBetween * currentHotel.getWeekdayRate();
            currentHotel.setCostWeekDay(currentHotelCost);
        }
        // Optional<Hotel>
        Optional<HotelInfos> cheapestHotel = hotelArray.stream().min(Comparator.comparing(HotelInfos::getCostWeekday));
        Result result = new Result();
        result.setHotelName(cheapestHotel.get().getHotelName());
        result.setTotalCost(cheapestHotel.get().getCostWeekday());
        return result;
    }

}
