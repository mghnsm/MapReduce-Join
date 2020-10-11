package bmstu;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import javax.naming.Context;
import java.io.IOException;
import java.util.Iterator;

public class JoinReducer extends Reducer<TextPair, Text, Text, Text> {
    @Override
    protected void reduce(TextPair key, Iterable<Text> values, Context context) throws
            IOException, InterruptedException {
        Iterator<Text> iter = values.iterator();
        Text airportName = new Text(iter.next());
        while (iter.hasNext()) {
            Text delayTime = iter.next();
        }
    }
}
