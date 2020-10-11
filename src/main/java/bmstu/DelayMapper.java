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

        if (key.get() != 0) {
            if (value.toString().isEmpty()) {
                return;
            }

            String[] line = value.toString().split(",", -1);
            String delay = line[ARR_DELAY_NEW];

            if (delay != null && !delay.isEmpty() && Float.parseFloat(delay) > 0) {
                TextPair airportCode = new TextPair(line[DEST_AIRPORT_ID], "1");
                Text delayTime = new Text(line[ARR_DELAY_NEW]);
                context.write(airportCode, delayTime);
            }
        }
    }
}
