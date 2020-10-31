package org.bmstu.IU9.hadoop_labs.lab_2;

public class FlightReduce {
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
