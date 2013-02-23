package Problem2;
        
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
        
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.MapFileOutputFormat;
import org.apache.hadoop.mapred.lib.MultipleOutputFormat;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
        
public class WordCount {
        
 public static class Map extends Mapper<LongWritable, Text, Text, PrintableMap> {
    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();
        
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        StringTokenizer tokenizer = new StringTokenizer(line);
        String docnum = tokenizer.nextToken();
        while (tokenizer.hasMoreTokens()) {
            word.set(tokenizer.nextToken());
            PrintableMap mw = new PrintableMap();
            mw.put(new IntWritable(Integer.parseInt(docnum)), new IntWritable(1));
            context.write(word, mw);
        }
    }
 } 
        
 public static class Reduce extends Reducer<Text, PrintableMap, Text, PrintableMap> {

    public void reduce(Text key, Iterable<PrintableMap> values, Context context) 
      throws IOException, InterruptedException {
        int sum = 0;
        PrintableMap m = new PrintableMap();
        for (PrintableMap val : values) {
        	for(Writable k : val.keySet())
        		if(m.get(k) == null)
        			m.put(k, new IntWritable(1));
        		else
        			m.put(k, new IntWritable(1 +((IntWritable)m.get(k)).get()));
        }
        context.write(key, m);
    }
 }
        
 public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    conf.set("mapred.textoutputformat.separator","-");
    Job job = new Job(conf, "wordcount");
    
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(PrintableMap.class);
    job.setMapperClass(Map.class);
    job.setReducerClass(Reduce.class);
    
    job.setJarByClass(WordCount.class);    
    job.setInputFormatClass(TextInputFormat.class);
    job.setOutputFormatClass(TextOutputFormat.class);
    
    Path outfile=new Path(args[1]);
    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, outfile);
    
    job.waitForCompletion(true);
    
 }
}
        