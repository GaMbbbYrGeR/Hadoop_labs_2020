package org.bmstu.IU9.hadoop_labs.lab_2;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlightWritableComparable implements WritableComparable<FlightWritableComparable> {

    private int flag;
    private long dectairip;

    public void set_flag(int flag) {
        this.flag = flag;
    }

    public void set_dectairip(int dectairip) {
        this.dectairip = dectairip;
    }

    public long get_dectairip() {
        return dectairip;
    }

    public void write(DataOutput out) throws IOException {
        out.writeInt(flag);
        out.writeLong(dectairip);
    }

    public void readFields(DataInput in) throws IOException {
        flag = in.readInt();
        dectairip = in.readLong();
    }

    @Override
    public int compareTo(FlightWritableComparable o) {
        FlightWritableComparable is = o;
        int is_flag = is.flag;
        long is_dectairip = is.dectairip;

        if (this.dectairip > is_dectairip) {
            return 1;
        }
        if (this.dectairip < is_dectairip) {
            return -1;
        }

        if (this.flag > is_flag) {
            return 1;
        }
        if (this.flag < is_flag) {
            return -1;
        }

        return 0;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + flag;
        result = prime * result + (int) (dectairip ^ (dectairip >>> 32));
        return result;
    }


}
