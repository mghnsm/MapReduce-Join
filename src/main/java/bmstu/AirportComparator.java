package bmstu;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class AirportComparator extends WritableComparator {
    public AirportComparator

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        TextPair a1 = (TextPair) a;
        TextPair b1 = (TextPair) b;
        return a1.getKey().compareTo(b1.getKey());
    }
}
