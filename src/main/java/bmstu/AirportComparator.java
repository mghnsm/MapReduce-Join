package bmstu;

import org.apache.hadoop.io.WritableComparator;

public class AirportComparator extends WritableComparator {
    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        return a.compareTo(b);
    }
}
