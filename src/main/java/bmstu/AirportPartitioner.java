package bmstu;

import org.apache.hadoop.mapreduce.Partitioner;

public class AirportPartitioner extends Partitioner<K, V> {
    public int getPartition(K, V, numPartitions) {
        return (key.hashCode() & Integer.MAX_VALUE) % numReduceTasks;
    }
}
