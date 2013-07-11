This examples extends WordCount Example
Here we will provide an input file with HL7 messages
This MapReduce will list different MSH_9_2 (Trigger Events) in HL7 file with count

This example uses Hadoop Streaming API

example command to run this Map Reduce job 

hduser@jayant-pc:~$ hadoop jar /home/hduser/eventcount.jar jayant.hadoop.mapreduce.HL7Test.EventCount /home/hduser/hadoop/hl7eventcount/input /home/hduser/hadoop/hl7eventcount/output

output
------

13/07/08 15:57:32 WARN mapred.JobClient: Use GenericOptionsParser for parsing the arguments. Applications should implement Tool for the same.
13/07/08 15:57:33 INFO util.NativeCodeLoader: Loaded the native-hadoop library
13/07/08 15:57:33 WARN snappy.LoadSnappy: Snappy native library not loaded
13/07/08 15:57:33 INFO mapred.FileInputFormat: Total input paths to process : 1
13/07/08 15:57:34 INFO mapred.JobClient: Running job: job_201307081500_0006
13/07/08 15:57:35 INFO mapred.JobClient:  map 0% reduce 0%
13/07/08 15:57:48 INFO mapred.JobClient:  map 100% reduce 0%
13/07/08 15:57:57 INFO mapred.JobClient:  map 100% reduce 33%
13/07/08 15:57:58 INFO mapred.JobClient:  map 100% reduce 100%
13/07/08 15:58:00 INFO mapred.JobClient: Job complete: job_201307081500_0006
13/07/08 15:58:00 INFO mapred.JobClient: Counters: 30
13/07/08 15:58:00 INFO mapred.JobClient:   Job Counters 
13/07/08 15:58:00 INFO mapred.JobClient:     Launched reduce tasks=1
13/07/08 15:58:00 INFO mapred.JobClient:     SLOTS_MILLIS_MAPS=22864
13/07/08 15:58:00 INFO mapred.JobClient:     Total time spent by all reduces waiting after reserving slots (ms)=0
13/07/08 15:58:00 INFO mapred.JobClient:     Total time spent by all maps waiting after reserving slots (ms)=0
13/07/08 15:58:00 INFO mapred.JobClient:     Launched map tasks=2
13/07/08 15:58:00 INFO mapred.JobClient:     Data-local map tasks=2
13/07/08 15:58:00 INFO mapred.JobClient:     SLOTS_MILLIS_REDUCES=10388
13/07/08 15:58:00 INFO mapred.JobClient:   File Input Format Counters 
13/07/08 15:58:00 INFO mapred.JobClient:     Bytes Read=87014854
13/07/08 15:58:00 INFO mapred.JobClient:   File Output Format Counters 
13/07/08 15:58:00 INFO mapred.JobClient:     Bytes Written=130
13/07/08 15:58:00 INFO mapred.JobClient:   FileSystemCounters
13/07/08 15:58:00 INFO mapred.JobClient:     FILE_BYTES_READ=286
13/07/08 15:58:00 INFO mapred.JobClient:     HDFS_BYTES_READ=87015104
13/07/08 15:58:00 INFO mapred.JobClient:     FILE_BYTES_WRITTEN=154658
13/07/08 15:58:00 INFO mapred.JobClient:     HDFS_BYTES_WRITTEN=130
13/07/08 15:58:00 INFO mapred.JobClient:   Map-Reduce Framework
13/07/08 15:58:00 INFO mapred.JobClient:     Map output materialized bytes=292
13/07/08 15:58:00 INFO mapred.JobClient:     Map input records=1075055
13/07/08 15:58:00 INFO mapred.JobClient:     Reduce shuffle bytes=292
13/07/08 15:58:00 INFO mapred.JobClient:     Spilled Records=40
13/07/08 15:58:00 INFO mapred.JobClient:     Map output bytes=724632
13/07/08 15:58:00 INFO mapred.JobClient:     Total committed heap usage (bytes)=459800576
13/07/08 15:58:00 INFO mapred.JobClient:     CPU time spent (ms)=10040
13/07/08 15:58:00 INFO mapred.JobClient:     Map input bytes=87014283
13/07/08 15:58:00 INFO mapred.JobClient:     SPLIT_RAW_BYTES=250
13/07/08 15:58:00 INFO mapred.JobClient:     Combine input records=60386
13/07/08 15:58:00 INFO mapred.JobClient:     Reduce input records=20
13/07/08 15:58:00 INFO mapred.JobClient:     Reduce input groups=11
13/07/08 15:58:00 INFO mapred.JobClient:     Combine output records=20
13/07/08 15:58:00 INFO mapred.JobClient:     Physical memory (bytes) snapshot=557441024
13/07/08 15:58:00 INFO mapred.JobClient:     Reduce output records=11
13/07/08 15:58:00 INFO mapred.JobClient:     Virtual memory (bytes) snapshot=2116161536
13/07/08 15:58:00 INFO mapred.JobClient:     Map output records=60386
hduser@jayant-pc:~$ hadoop fs -cat /home/hduser/hadoop/hl7eventcount/output/part-00000
ADT^A01	6251
ADT^A02	2181
ADT^A03	2346
ADT^A04	5271
ADT^A05	248
ADT^A06	95
ADT^A07	1
ADT^A08	43607
ADT^A13	4
ADT^A18	16
ADT^A17	366


For more information

http://www.j4jayant.com/articles/hl7/34-hl7-analysis-hadoop