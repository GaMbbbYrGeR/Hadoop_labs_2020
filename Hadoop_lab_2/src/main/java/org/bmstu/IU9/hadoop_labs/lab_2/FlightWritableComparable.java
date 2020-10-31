package org.bmstu.IU9.hadoop_labs.lab_2;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlightWritableComparable implements WritableComparable<FlightWritableComparable> {

    private int flightFlag;
    private int destAirID;

    public int getFlag() {
        return flightFlag;
    }

    public int getDestAirID() {
        return destAirID;
    }

    public FlightWritableComparable() {
    }

    public FlightWritableComparable(int flag, int destAirID) {
        super();
        this.flightFlag = flag;
        this.destAirID = destAirID;
    }

    public void write(DataOutput out) throws IOException {
        out.writeInt(flightFlag);
        out.writeInt(destAirID);
    }

    public void readFields(DataInput in) throws IOException {
        flightFlag = in.readInt();
        destAirID = in.readInt();
    }

    @Override
    public int compareTo(FlightWritableComparable o) {
        FlightWritableComparable is = o;
        int isFlag = is.getFlag();
        int isDestAirID = is.getDestAirID();

        if (this.getDestAirID() > isDestAirID) {
            return 1;
        }
        if (this.getDestAirID() < isDestAirID) {
            return -1;
        }

        if (this.getFlag() > isFlag) {
            return 1;
        }
        if (this.getFlag() < isFlag) {
            return -1;
        }
        return 0;
    }

    public int hashCode() {
        return this.getDestAirID();
    }

    @Override
    public String toString() {
        return "[" + getDestAirID() + " " + getFlag() + "]";
    }

}
