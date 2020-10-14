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

        int count = 0;
        float min = Integer.MAX_VALUE;
        float max = 0;

        while (iter.hasNext()) {
            float delayTime = Float.parseFloat(iter.next().toString());
            min = Math.min(delayTime, min);
            max = Math.max(delayTime, max);
            count++;
        }

        if (count > 0) {
            context.write(new Text("Airport: " + airportName),
                    new Text("Min delay time: " + Float.toString(min) + " Max delay time: " + Float.toString(max)));
        }
    }
}
