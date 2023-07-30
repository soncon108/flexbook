package com.thanhson.flexbookjava.faker;

import java.sql.Timestamp;

public class TimestampGenerator {

    private static final long START_TIME = Timestamp.valueOf("2021-01-01 00:00:00").getTime();
    private static final long END_TIME = Timestamp.valueOf("2022-12-31 00:00:00").getTime();

    public static Timestamp getRandomTimestamp() {
        long offset = START_TIME;
        long diff = END_TIME - offset + 1;
        Timestamp randomTimestamp = new Timestamp(offset + (long)(Math.random() * diff));
        return randomTimestamp;
    }

}
