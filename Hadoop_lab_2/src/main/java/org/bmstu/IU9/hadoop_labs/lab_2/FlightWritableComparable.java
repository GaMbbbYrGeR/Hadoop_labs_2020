package org.bmstu.IU9.hadoop_labs.lab_2;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlightWritableComparable implements WritableComparable<FlightWritableComparable> {

    private int flag;
    private int dectairip;

    public int get_flag() {
        return flag;
    }

    public int get_dectairip() {
        return dectairip;
    }

    public FlightWritableComparable() {
    }

    public FlightWritableComparable(int flag, int dectairip) {
        this.flag = flag;
        this.dectairip = dectairip;
    }

    public void write(DataOutput out) throws IOException {
        out.writeInt(flag);
        out.writeLong(dectairip);
    }

    public void readFields(DataInput in) throws IOException {
        flag = in.readInt();
        dectairip = in.readInt();
    }

    @Override
    public int compareTo(FlightWritableComparable o) {
        FlightWritableComparable is = o;
        int is_flag = is.get_flag();
        long is_dectairip = is.get_dectairip();

        if (this.get_dectairip() > is_dectairip) {
            return 1;
        }
        if (this.get_dectairip() < is_dectairip) {
            return -1;
        }

        if (this.get_flag() > is_flag) {
            return 1;
        }
        if (this.get_flag() < is_flag) {
            return -1;
        }
        return 0;
    }

    public int hashCode() {
        return this.get_dectairip();
    }

    @Override
    public String toString() {
        return "[" + get_dectairip() + " " + get_flag() + "]";
    }

}
