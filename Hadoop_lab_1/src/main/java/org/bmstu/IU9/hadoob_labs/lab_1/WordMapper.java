package org.bmstu.IU9.hadoob_labs.lab_1;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WordMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    static final String deleteSymbolsExpThis = "[^a-zа-я]";
    static final String deletespaces = " +";

    @Override
    protected void map(LongWritable key, Text value, Context context) throws
            IOException, InterruptedException {
        String line = value.toString();
        line = line.trim().toLowerCase().replaceAll(deleteSymbolsExpThis, " ");
        String[] words = line.split(deletespaces);
        for (String word : words) {
            context.write(new Text(word), new IntWritable(1));
        }
    }
}