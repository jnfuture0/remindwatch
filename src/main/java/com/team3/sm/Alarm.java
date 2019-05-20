package com.team3.sm;

import java.util.*;

class Alarm extends Controller {
        Alarm(){
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

    protected Integer increaseElement(String name, int prev) {
        if (name.equals("minutes") && prev == 60) {
            return 0;
        } else if (name.equals("hours") && prev == 24) {
            return 1;
        }
        return prev + 1;
    }
}
