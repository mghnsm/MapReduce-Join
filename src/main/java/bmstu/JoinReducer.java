package bmstu;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class JoinReducer extends Reducer<TextPair, Text, Text, Text> {
    @Override
    protected void reduce(TextPair key, Iterable<Text> values, Context context) throws
            IOException, InterruptedException {
        Iterator<Text> iter = values.iterator();
        Text airportName = new Text(iter.next());

        int min = Integer.MAX_VALUE;
        int max = 0;

        while (iter.hasNext()) {
            int delayTime = Integer.parseInt(iter.next().toString());

            min = Math.min(delayTime, min);
            max = Math.max(delayTime, max);
        }
        context.write(airportName, new Text(Integer.toString(min)));
    }
}
