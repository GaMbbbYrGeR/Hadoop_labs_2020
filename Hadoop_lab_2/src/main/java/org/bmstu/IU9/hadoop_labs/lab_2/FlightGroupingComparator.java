package org.bmstu.IU9.hadoop_labs.lab_2;

import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class FlightGroupingComparator implements WritableComparator {

    public GroupingComparator() {
        super(FlightWritableComparable.class, true);
    }

    public int compare(FlightWritableComparable a, FlightWritableComparable b) {
        FlightWritableComparable x = (FlightWritableComparable) x1;
        FlightWritableComparable y = (FlightWritableComparable) y1;

        return x1.get_dectairip().compareTo(y1.get_dectairip());
    }
}
