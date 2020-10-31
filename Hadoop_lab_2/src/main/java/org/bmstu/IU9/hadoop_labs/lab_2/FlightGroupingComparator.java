package org.bmstu.IU9.hadoop_labs.lab_2;

import org.apache.hadoop.io.RawComparator;

public class FlightGroupingComparator implements RawComparator {

    public int compare(FlightWritableComparable a, FlightWritableComparable b) {
        return a.compareTo(b);
    }

    public class NaturalKeyGroupingComparator extends WritableComparator {
        protected NaturalKeyGroupingComparator() {
            super(StockKey.class, true);
        }
        @SuppressWarnings("rawtypes")
        @Override
        public int compare(WritableComparable w1, WritableComparable w2) {
            StockKey k1 = (StockKey)w1;
            StockKey k2 = (StockKey)w2;

            return k1.getSymbol().compareTo(k2.getSymbol());
        }
}
