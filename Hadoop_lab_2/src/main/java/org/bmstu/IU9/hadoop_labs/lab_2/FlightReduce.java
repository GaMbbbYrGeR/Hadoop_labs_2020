package org.bmstu.IU9.hadoop_labs.lab_2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class FlightReduce extends Reducer<FlightWritableComparable, Text, Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

        long count = 0;
        Iterator iter =  values.iterator();
        while (iter.hasNext()) {
            iter.next();
            count++;
        }
        context.write ( key, new LongWritable ( count));
    }
}
