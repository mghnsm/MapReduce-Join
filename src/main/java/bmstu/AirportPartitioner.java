package bmstu;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class AirportPartitioner extends Partitioner<TextPair, Text> {
    @Override
    public int getPartition(TextPair key, Text value, int numReduceTasks) {
        return (Integer.parseInt(key.getKey().toString()) & Integer.MAX_VALUE) % numReduceTasks;
    }
}
