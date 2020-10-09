package bmstu;

import org.apache.hadoop.mapreduce.Partitioner;

public class AirportPartitioner extends Partitioner<K, V> {

    @Override
    public int getPartition(key, value, numReduceTasks) {
        return (key.hashCode() & Integer.MAX_VALUE) % numReduceTasks;
    }
}
