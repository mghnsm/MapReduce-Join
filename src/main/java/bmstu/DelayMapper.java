package bmstu;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.join.TupleWritable;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class DelayMapper extends Mapper<LongWritable, Text, TextPair, Text> {
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        final int DEST_AIRPORT_ID = 14;
        final int ARR_DELAY_NEW = 18;

        String[] line = value.toString().split(",");
        String delay = line[ARR_DELAY_NEW];

        if(delay != null && !delay.isEmpty()) {
            TextPair code = new TextPair(line[DEST_AIRPORT_ID], "0");
            Text delayTime;
            context.write(code, delayTime);
        }
    }
}
