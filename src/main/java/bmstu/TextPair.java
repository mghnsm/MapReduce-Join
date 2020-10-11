package bmstu;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class TextPair implements WritableComparable<TextPair> {
    private Text key;
    private Text value;

    public TextPair() {
        this.key = new Text();
        this.value = new Text();
    }

    public TextPair(String key, String value) {
        this.key = new Text(key);
        this.value = new Text(value);
    }

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
        int diff = 
    }

    @Override
    public String toString() {
        return "TextPair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
