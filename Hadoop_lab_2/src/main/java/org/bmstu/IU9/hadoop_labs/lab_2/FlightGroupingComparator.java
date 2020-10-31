package org.bmstu.IU9.hadoop_labs.lab_2;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class FlightGroupingComparator extends WritableComparator {

    public FlightGroupingComparator() {
        super(FlightWritableComparable.class, true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        FlightWritableComparable x1 = (FlightWritableComparable) a;
        FlightWritableComparable y1 = (FlightWritableComparable) b;

        if(x1.getDestAirID() > y1.getDestAirID()) {
            return 1;
        }
        if(x1.getDestAirID() < y1.getDestAirID()) {
            return -1;
        }

        return 0;
    }
}
