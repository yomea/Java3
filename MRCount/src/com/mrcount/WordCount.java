package com.mrcount;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class WordCount {
	
	/**
	 * Object输入数据的具体内容
	 * Text每行的文本数据
	 * Text每个单词分解后的统计结果
	 * IntWritable输出记录的结果
	 *  @author may
	 */
	private static class WordCountMapper extends Mapper<Object, Text, Text, IntWritable> {
		
		
		
		@Override
		protected void map(Object key, Text value, Mapper<Object, Text, Text, IntWritable>.Context context)
				throws IOException, InterruptedException {
			String lineContext = value.toString();//得到每行的数据
			String result[] = lineContext.split(" ");//拆分每行的数据
			for (String string : result) {
				if(!string.trim().equals("")) {
					context.write(new Text(string), new IntWritable(1));
					
				}
			}
		}
		
	}
	
	/**
	 * Text:map输出文本内容
	 * IntWritable：map处理个数
	 * Text：输出文本
	 * IntWritable：reduce输出个数
	 * @author may
	 *
	 */
	private static class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
		
		@Override
		protected void reduce(Text key, Iterable<IntWritable> values,
				Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
			
			int sum = 0;//保存每个单词出现的数据量
			
			for(IntWritable count : values) {
				sum += count.get();
			}
			
			context.write(key, new IntWritable(sum));
			
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		
		Configuration conf = new Configuration();
		
		String[] argArray = new GenericOptionsParser(conf, args).getRemainingArgs();
		
		Job job = Job.getInstance(conf, "hadoop");
		
		job.setJarByClass(WordCount.class);
		job.setMapperClass(WordCountMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setReducerClass(WordCountReducer.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.addInputPath(job, new Path(argArray[0]));
		
		FileOutputFormat.setOutputPath(job, new Path(argArray[1]));
		
		System.exit(job.waitForCompletion(true) ? 0 : 1);
		
		
	}

}
