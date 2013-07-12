/*
Author: Jayant Singh
Website: http://www.j4jayant.com
Description:
This Hadoop MapReduce code extends wordcount example & counts different trigger events(MSH_9) present in HL7 file
*/

package jayant.hadoop.mapreduce.HL7Test;

import org.apache.hadoop.fs.Path;
//import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

import java.io.IOException;
import java.util.*;

public class EventCount {
 	   public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
 	     private final static IntWritable one = new IntWritable(1);
 	     private Text word = new Text();
 	    final String MSH_SEG_START = "MSH|^~\\&";
 	    
 	     public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
 	      String line = value.toString();
 	      //check if line starts with MSH
 	      if(line.startsWith(MSH_SEG_START))
 	      {
 	          final String FIELD_SEPARATOR = "|";
 	          final String[] splitStr = splitTokens(line, FIELD_SEPARATOR);
 	          
 	          //check 12 fields in MSH
 	          if(splitStr.length >= 12)
 	          {
	 	          word.set(splitStr[8]);
	 	          output.collect(word, one);
 	          }
 	       }
 	     }
 	   }
 	
 	   public static class Reduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {
 	     public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
 	       int sum = 0;
 	       while (values.hasNext()) {
 	         sum += values.next().get();
 	       }
 	       output.collect(key, new IntWritable(sum));
 	     }
 	   }
 	
 	   public static void main(String[] args) throws Exception {
 	     JobConf conf = new JobConf(EventCount.class);
 	     conf.setJobName("EventCount");
 	
 	     conf.setOutputKeyClass(Text.class);
 	     conf.setOutputValueClass(IntWritable.class);
 	
 	     conf.setMapperClass(Map.class);
 	     conf.setCombinerClass(Reduce.class);
 	     conf.setReducerClass(Reduce.class);
 	
 	     conf.setInputFormat(TextInputFormat.class);
 	     conf.setOutputFormat(TextOutputFormat.class);
 	
 	     FileInputFormat.setInputPaths(conf, new Path(args[0]));
 	     FileOutputFormat.setOutputPath(conf, new Path(args[1]));
 	
 	     JobClient.runJob(conf);
 	   }
 	   
 	  //this function is copied from http://stackoverflow.com/questions/2708591/java-stringtokenizer-empty-null-tokens
 	  public static String[] splitTokens(String line, String delim){
 			String s = line;
 			int i=0;
 			
 			while(s.contains(delim)){
 				s = s.substring(s.indexOf(delim) + delim.length());
 				i++;
 			}
 			
 			String token = null;
 			String remainder = null;
 			String[] tokens = new String[i];
 			
 			for(int j = 0; j< i; j++){
 				token = line.substring(0, line.indexOf(delim));
 				tokens[j] = token;
 				remainder = line.substring(line.indexOf(delim) + delim.length());
 				line = remainder;
 			}
 			return tokens;
 		}
 	}