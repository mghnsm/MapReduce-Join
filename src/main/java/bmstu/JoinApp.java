package bmstu;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class JoinApp {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: JoinApp ...");
            System.exit(-1);
        }
        Job job = Job.getInstance();
        job.setJarByClass(JoinApp.class);
        job.setJobName("");
        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, CallsJoinMapper.class);
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, SystemsJoinMapper.class);
        FileOutputFormat.setOutputPath(job, new Path(args[2]));
        job.setPartitionerClass(AirportPartitioner.class);
        job.setGroupingComparatorClass(AirportComparator.class);
        job.setReducerClass(JoinReducer.class);
        job.setMapOutputKeyClass(TextPair.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        job.setNumReduceTasks(2);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
