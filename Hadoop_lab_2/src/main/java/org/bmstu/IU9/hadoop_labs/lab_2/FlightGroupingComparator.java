package org.bmstu.IU9.hadoop_labs.lab_2;

import org.apache.hadoop.io.RawComparator;

public class FlightGroupingComparator implements RawComparator {

    public int compare(FlightWritableComparable a, FlightWritableComparable b) {
        return a.compareTo(b);
    }
}
