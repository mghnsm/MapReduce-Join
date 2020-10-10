package bmstu;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.join.TupleWritable;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirportMapper extends Mapper<LongWritable, Text, TextPair, Text> {
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException {
        String line = value.toString();
        int separator = line.indexOf(",");

        int code = Integer.parseInt(line.substring(1, separator - 1));
        String name = line.substring(separator + 1, line.length() - 1);

        TextPair airportCode = new TextPair(code, "0");
        Text airportName = new Text(name);

        context.write(code, name);
    }
}
