package org.bmstu.IU9.hadoop_labs.lab_2;

import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class FlightGroupingComparator extends WritableComparator {

    public FlightGroupingComparator() {
        super(FlightWritableComparable.class, true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        return super.compare(a, b);
    }

    public int compare(FlightWritableComparable a, FlightWritableComparable b) {
        FlightWritableComparable x = (FlightWritableComparable) x1;
        FlightWritableComparable y = (FlightWritableComparable) y1;

        if(x1.get_dectairip() > y1.get_dectairip()) {
            return 1;
        } else {
            if (x1.get_dectairip() < y1.get_dectairip()) {
                return -1;
            } else {
                return 0;
            }
        }

        return 0;
    }
}
