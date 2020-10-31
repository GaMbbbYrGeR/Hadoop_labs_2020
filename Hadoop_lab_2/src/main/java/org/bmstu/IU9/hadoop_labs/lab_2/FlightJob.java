package org.bmstu.IU9.hadoop_labs.lab_2;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class FlightJob {
    public static void main(String[] args) throws Exception {

        Job job = Job.getInstance();
        job.setJarByClass(FlightJob.class);
        job.setJobName("Join sort");
        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, AirportsMap.class);
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, FlightsMap.class);
        FileOutputFormat.setOutputPath(job, new Path(args[2]));
        job.setPartitionerClass(FlightPartition.class);
        job.setGroupingComparatorClass(FlightGroupingComparator.class);
        job.setReducerClass(FlightReduce.class);
        job.setMapOutputKeyClass(FlightWritableComparable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        job.setNumReduceTasks(2);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
