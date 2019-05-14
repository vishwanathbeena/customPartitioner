package com.practice.Partitioner;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Counters;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class VowelSplitMapper extends Mapper<LongWritable,Text,Text,IntWritable>{
	static enum VowelCounter{VOWEL,CONSONANT};
	private Text key_Val = new Text();
	private char fc;
	public void map(LongWritable key,Text value,Context context) throws IOException, InterruptedException{
		StringTokenizer strToken = new StringTokenizer(value.toString());
		while(strToken.hasMoreTokens()){
			key_Val.set(strToken.nextToken());
			fc=key_Val.toString().toLowerCase().charAt(0);
			if(fc=='a'||fc=='e'||fc=='i'||fc=='o'||fc=='u'){
				context.getCounter(VowelCounter.VOWEL).increment(1);
			}else{
				context.getCounter(VowelCounter.CONSONANT).increment(1);
			}
			context.write(key_Val, new IntWritable(1));
		}
	}
}
