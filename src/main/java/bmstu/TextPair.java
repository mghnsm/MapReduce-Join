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

    @Override
    public void write(DataOutput out) throws IOException {
        key.write(out);
        value.write(out);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        key.readFields(in);
        value.readFields(in);
    }

    @Override
    public int compareTo(TextPair o) {
        if (key.compareTo(o.getKey()) == 0) {
            return value.compareTo(o.getValue());
        }
        return key.compareTo(o.getKey());
    }

    
}
