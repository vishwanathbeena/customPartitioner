package com.practice.Partitioner;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class VowelSplitPartitioner extends Partitioner<Text,IntWritable> {

	@Override
	public int getPartition(Text key, IntWritable value, int numReduceTasks) {
		char firstChar = key.toString().toLowerCase().charAt(0);
		if(firstChar=='a'||firstChar=='e'||firstChar=='i'||firstChar=='o'||firstChar=='u'){
			return 1;
		}else
			return 0;
	}

}
