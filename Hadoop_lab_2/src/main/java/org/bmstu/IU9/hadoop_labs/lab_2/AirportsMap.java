package org.bmstu.IU9.hadoop_labs.lab_2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirportsMap extends Mapper<LongWritable, Text, FlightWritableComparable, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] str = value.toString().split(",");

        if(Float.parseFloat(str[19]) != (float)1 && !str[0].equals("YEAR")) {
            if(Float.parseFloat(str[18]) != (float)0) {
                FlightWritableComparable flight = new FlightWritableComparable();

                
            }
        }
    }

}
