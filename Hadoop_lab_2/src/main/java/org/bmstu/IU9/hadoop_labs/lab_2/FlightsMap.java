package org.bmstu.IU9.hadoop_labs.lab_2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightsMap extends Mapper<LongWritable, Text, FlightWritableComparable, Text> {
    @Override
    protected void map(LongWritable key, Text value, Mapper.Context context) throws IOException, InterruptedException {

        final String SPLITTER = ",";
        final String COMPARE = "\"YEAR\"";
        final int FLAG_FLIGHT = 1;
        final float NO_CANCELED = 0;

        String[] str = value.toString().split(SPLITTER);

        if(!str[0].equals(COMPARE) && !str[18].isEmpty()) {
            if(Float.parseFloat(str[18]) != NO_CANCELED) {
                FlightWritableComparable flight = new FlightWritableComparable(FLAG_FLIGHT, Integer.parseInt(str[14]));

                Text name = new Text(str[18]);

                context.write(flight, name);
            }
        }
    }
}
