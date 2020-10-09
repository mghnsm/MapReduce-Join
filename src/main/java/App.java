import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class App {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: App ");
            System.exit(-1);
        }
    }
}
