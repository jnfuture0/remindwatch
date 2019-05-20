package com.team3.sm;

import java.util.Arrays;
import java.util.Calendar;

import static java.util.Calendar.DAY_OF_MONTH;

public class CurrentTime extends Controller {
    private Calendar calendar = Calendar.getInstance();
    CurrentTime(){
        this.cursorList = Arrays.asList(
                Pair.of("seconds", "zero"),
                Pair.of("minutes", "inc"),
                Pair.of("hours", "inc"),
                Pair.of("date", "inc"),
                Pair.of("month", "inc"),
                Pair.of("year", "inc")
        );
        this.setStorageName("time.data.properties");
    }
    protected Integer increaseElement(String name, int prev){
        this.data.putIfAbsent("year", 2000);
        this.data.putIfAbsent("month", 1);
        //noinspection MagicConstant
        calendar.set(this.data.get("year"), this.data.get("month")-1,1);
        int maxDay = calendar.getActualMaximum(DAY_OF_MONTH);
        if(name.equals("minutes") && prev == 60){
            return 0;
        }
        else if(name.equals("hours") && prev == 24){
            return 1;
        }
        else if(name.equals("date") && prev == maxDay){
            return 1;
        }
        else if(name.equals("month") && prev == 12){
            return 1;
        }
        else if(name.equals("year")){
            if(((prev/100)&1) == 1){
                return 2000;
            }
        }
        return prev + 1;
    }
}
