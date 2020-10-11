package bmstu;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirportMapper extends Mapper<LongWritable, Text, TextPair, Text> {
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        int separator = line.indexOf(",");

        int code = Integer.parseInt(line.substring(0, separator));
        String name = line.substring(separator + 2, line.length() - 1);

        TextPair airportCode = new TextPair(Integer.toString(code), "0");
        Text airportName = new Text(name);

        context.write(airportCode, airportName);
    }
}
