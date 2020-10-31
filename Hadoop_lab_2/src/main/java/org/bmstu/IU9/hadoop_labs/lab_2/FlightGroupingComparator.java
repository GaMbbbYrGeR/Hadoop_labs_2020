package org.bmstu.IU9.hadoop_labs.lab_2;

import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class FlightGroupingComparator extends WritableComparator {

    public FlightGroupingComparator() {
        super(FlightWritableComparable.class, true);
    }

    @Override
    public int compare(FlightWritableComparable a, FlightWritableComparable b) {
        FlightWritableComparable x1 = (FlightWritableComparable) b;
        FlightWritableComparable y1 = (FlightWritableComparable) a;

        if(x1.get_dectairip() > y1.get_dectairip()) {
            return 1;
        }
        if (x1.get_dectairip() < y1.get_dectairip()) {
            return -1;
        }

        return 0;
    }
}
