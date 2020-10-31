package org.bmstu.IU9.hadoop_labs.lab_2;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlightWritableComparable implements WritableComparable {
    // Some data
    private int flag;
    private long dectairip;

    public void set_flag(int flag) {
        this.flag = flag;
    }

    public void set_dectairip(int dectairip) {
        this.dectairip = dectairip;
    }

    public void write(DataOutput out) throws IOException {
        out.writeInt(flag);
        out.writeLong(dectairip);
    }

    public void readFields(DataInput in) throws IOException {
        flag = in.readInt();
        dectairip = in.readLong();
    }

    public int compareTo(FlightWritableComparable o) {
        FlightWritableComparable is = (FlightWritableComparable) o;
        int is_flag = is.flag;
        long is_dectairip = is.dectairip;

        if (this.dectairip > is_dectairip) {
            return 1;
        }
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + flag;
        result = prime * result + (int) (dectairip ^ (dectairip >>> 32));
        return result
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
