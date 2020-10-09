package bmstu;

import org.apache.hadoop.mapreduce.Mapper;

public class DelayMapper extends Mapper {
    @Override
    public void map(Text key, TupleWritable value,
                    OutputCollector<Text, Text> output,
                    Reporter reporter) throws IOException {
        Text call = (Text) value.get(0);
        Text system = (Text) value.get(1);
        output.collect(call, system);
    }
}
