package com.ecc.javalanguage.datatype.bitset;

import java.util.BitSet;

public class HolidaySked {
    BitSet sked;

    public HolidaySked() {
        sked = new BitSet(365);
        int[] holiday = {1, 15, 50, 148, 185, 246, 281, 316, 326, 359};

        for (int i : holiday) {
            addHoliday(i);
        }
    }

    public void addHoliday(int dayAdd) {
        sked.set(dayAdd);
    }

    public boolean isHoliday(int dayToCheck) {
        return sked.get(dayToCheck);
    }

}
