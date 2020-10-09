package bmstu;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class TextPair implements WritableComparable<TextPair> {
    private Text key;
    private Text value;

    public Text getKey() { return key; }
    public Text getValue() { return value; }

    public void write() {}

    public void readFields() {}

    public int compareTo() {}

    public int hashCode() {}
}
