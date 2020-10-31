package org.bmstu.IU9.hadoop_labs.lab_2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class FlightPartition extends Partitioner<FlightWritableComparable, Text> {
}
