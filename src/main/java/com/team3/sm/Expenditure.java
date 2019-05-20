package com.team3.sm;

import java.util.Arrays;

public class Expenditure extends Controller {
    Expenditure(){
        this.cursorList = Arrays.asList(
                Pair.of("minutes", "inc"),
                Pair.of("hours", "inc"),
                Pair.of("mon", "set"),
                Pair.of("tue", "set"),
                Pair.of("wed", "set"),
                Pair.of("thu", "set"),
                Pair.of("fri", "set"),
                Pair.of("sat", "set"),
                Pair.of("sun", "set")
        );
        this.setStorageName("alarm.data.properties");
    }
}
