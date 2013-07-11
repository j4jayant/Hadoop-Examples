This examples extends WordCount Example
Here we will provide an input file with HL7 messages
This MapReduce will list different MSH_9_2 (Trigger Events) in HL7 file with count

This example uses Hadoop Streaming API

example command to run this Map Reduce job 

hduser@jayant-pc:~$ hadoop jar /home/hduser/hadoop/contrib/streaming/hadoop-streaming-1.1.2.jar -file /home/hduser/python/eventcount/mapper.py -mapper ./mapper.py -file /home/hduser/python/eventcount/reducer.py -reducer ./reducer.py -input /home/hduser/hadoop/hl7eventcount/input/* -output /home/hduser/hadoop/hl7eventcount/output

Output
------

packageJobJar: [/home/hduser/python/eventcount/mapper.py, /home/hduser/python/eventcount/reducer.py, /home/hduser/tmp/hadoop-unjar1397608400024094301/] [] /tmp/streamjob3276271105870771026.jar tmpDir=null
13/07/09 17:54:08 INFO util.NativeCodeLoader: Loaded the native-hadoop library
13/07/09 17:54:08 WARN snappy.LoadSnappy: Snappy native library not loaded
13/07/09 17:54:08 INFO mapred.FileInputFormat: Total input paths to process : 1
13/07/09 17:54:08 INFO streaming.StreamJob: getLocalDirs(): [/home/hduser/tmp/mapred/local]
13/07/09 17:54:08 INFO streaming.StreamJob: Running job: job_201307091539_0013
13/07/09 17:54:08 INFO streaming.StreamJob: To kill this job, run:
13/07/09 17:54:08 INFO streaming.StreamJob: /home/hduser/hadoop/libexec/../bin/hadoop job  -Dmapred.job.tracker=localhost:54311 -kill job_201307091539_0013
13/07/09 17:54:08 INFO streaming.StreamJob: Tracking URL: http://localhost:50030/jobdetails.jsp?jobid=job_201307091539_0013
13/07/09 17:54:09 INFO streaming.StreamJob:  map 0%  reduce 0%
13/07/09 17:54:21 INFO streaming.StreamJob:  map 100%  reduce 0%
13/07/09 17:54:29 INFO streaming.StreamJob:  map 100%  reduce 33%
13/07/09 17:54:32 INFO streaming.StreamJob:  map 100%  reduce 100%
13/07/09 17:54:35 INFO streaming.StreamJob: Job complete: job_201307091539_0013
13/07/09 17:54:35 INFO streaming.StreamJob: Output: /home/hduser/hadoop/hl7eventcount/output
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