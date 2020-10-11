package bmstu;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class DelayMapper extends Mapper<LongWritable, Text, TextPair, Text> {
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        final int DEST_AIRPORT_ID = 14;
        final int ARR_DELAY_NEW = 18;

        TextPair airportCode = new TextPair();
        Text delayTime = new Text();

        if (key.get() != 0) {
            String[] line = value.toString().split(",");
            String delay = line[ARR_DELAY_NEW];

            if (delay != null && !delay.isEmpty()) {
                airportCode = new TextPair(line[DEST_AIRPORT_ID], "0");
                delayTime = new Text(line[ARR_DELAY_NEW]);
            }
        }

        context.write(airportCode, delayTime);
    }
}
