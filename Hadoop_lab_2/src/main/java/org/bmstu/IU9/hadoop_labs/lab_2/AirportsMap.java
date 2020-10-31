package org.bmstu.IU9.hadoop_labs.lab_2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirportsMap extends Mapper<LongWritable, Text, FlightWritableComparable, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        final String SPLITTER = ",(?! )";
        final String REPLACE = "\"";
        final String REPLACEMENT = "";
        final String COMPARE = "Code";
        final int FLAG_AIRPORT = 0;

        String[] str = value.toString().replaceAll(REPLACE, REPLACEMENT).split(SPLITTER);

        if(!str[0].equals(COMPARE)) {
            FlightWritableComparable flight = new FlightWritableComparable(FLAG_AIRPORT, Integer.parseInt(str[0]));

            Text name = new Text(str[1]);

            context.write(flight, name);
        }
    }

}
