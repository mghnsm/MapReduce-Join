package bmstu;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class TextPair implements WritableComparable<TextPair> {
    private Text key;
    private Text value;

    public Text getKey() { return key; }
    public Text getValue() { return value; }

    public void write(DataOutput out) {
        key.write(out);
        value.write(out);
    }

    public void readFields(DataInput in) throws IOException {
        key.readFields(in);
        value.readFields(in);
    }

    public int compareTo(TextPair text) {
        
    }

    public int hashCode() {}
}
