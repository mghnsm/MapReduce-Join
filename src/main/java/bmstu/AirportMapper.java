package bmstu;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirportMapper extends Mapper<LongWritable, Text, TextPair, Text> {
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if(key.get() != 0 && !value.toString().isEmpty()) {

            String line = value.toString();
            int separator = line.indexOf(",", 0);

            int code = Integer.parseInt(line.substring(1, separator - 1));
            String name = line.substring(separator + 2, line.length() - 1);

            context.write(new TextPair(Integer.toString(code), "0"), new Text(name));
        }
    }
}
