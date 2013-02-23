package Problem3;

import java.io.IOException;
import java.util.*;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class GalaxyCount {

	public static class Map extends
			Mapper<LongWritable, Text, GalaxyName, GalaxyObj> {
		private final static IntWritable one = new IntWritable(1);
		private Text word = new Text();

		public void map(LongWritable key, Text value, Context context)
				throws IOException, InterruptedException {
			String line = value.toString();
			String name = line.split(" ")[1];
			String[] masses = line.split("distance: ")[0].split("mass: ")[1]
					.split("\\ ");
			String[] distances = line.split("diameter: ")[0]
					.split("distance: ")[1].split("\\ ");
			String[] diameters = line.split("rotation: ")[0]
					.split("diameter: ")[1].split("\\ ");
			String[] rotations = line.split("rotation: ")[1].split("\\ ");
			for (String k : masses) {
				GalaxyObj o = new GalaxyObj();
				o.setMass(Float.parseFloat(k));
				o.setMassCount(1);
				context.write(new GalaxyName(name), o);
			}
			for (String k : distances) {
				GalaxyObj o = new GalaxyObj();
				o.setDistance(Float.parseFloat(k));
				o.setDistanceCount(1);
				context.write(new GalaxyName(name), o);
			}
			for (String k : diameters) {
				GalaxyObj o = new GalaxyObj();
				o.setDiameter(Float.parseFloat(k));
				o.setDiameterCount(1);
				context.write(new GalaxyName(name), o);
			}
			for (String k : rotations) {
				GalaxyObj o = new GalaxyObj();
				o.setRotation(Float.parseFloat(k));
				o.setRotationCount(1);
				context.write(new GalaxyName(name), o);
			}
		}
	}

	public static class Reduce extends
			Reducer<GalaxyName, GalaxyObj, GalaxyName, GalaxyObj> {

		public void reduce(GalaxyName key, Iterable<GalaxyObj> values, Context context) 
      throws IOException, InterruptedException {
        GalaxyObj o = new GalaxyObj();
        for (GalaxyObj galaxy : values) {
           	if(galaxy.getDiameterCount() != 0)
    		{
	    		o.setDiameter( (o.getDiameter()*o.getDiameterCount() + 
	    				(galaxy.getDiameter()*galaxy.getDiameterCount()))
	    				/(galaxy.getDiameterCount()+o.getDiameterCount()));
	    		o.setDiameterCount(o.getDiameterCount()+galaxy.getDiameterCount());
    		}
           	if(galaxy.getMassCount() != 0)
    		{
	    		o.setMass( (o.getMass()*o.getMassCount() + 
	    				(galaxy.getMass()*galaxy.getMassCount()))
	    				/(galaxy.getMassCount()+o.getMassCount()));
	    		o.setMassCount(o.getMassCount()+galaxy.getMassCount());
    		}
           	if(galaxy.getDistanceCount() != 0)
    		{
	    		o.setDistance( (o.getDistance()*o.getDistanceCount() + 
	    				(galaxy.getDistance()*galaxy.getDistanceCount()))
	    				/(galaxy.getDistanceCount()+o.getDistanceCount()));
	    		o.setDistanceCount(o.getDistanceCount()+galaxy.getDistanceCount());
    		}
           	if(galaxy.getRotationCount() != 0)
    		{
	    		o.setRotation( (o.getRotation()*o.getRotationCount() + 
	    				(galaxy.getRotation()*galaxy.getRotationCount()))
	    				/(galaxy.getRotationCount()+o.getRotationCount()));
	    		o.setRotationCount(o.getRotationCount()+galaxy.getRotationCount());
    		}
        		
        }
        context.write(key, o);
    }
	}

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		conf.set("mapred.textoutputformat.separator", " ");
		Job job = new Job(conf, "wordcount");

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);

		job.setJarByClass(GalaxyCount.class);
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		job.waitForCompletion(true);
	}

}