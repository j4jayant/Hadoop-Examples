#!/usr/bin/python
"""
Author: Jayant Singh
Website: http://www.j4jayant.com
Description:
This Hadoop Mapper code extends wordcount example & extracts different trigger events(MSH_9) present in HL7 file and pass them to Reducer job
"""
import sys

strDelim = "|";
# input comes from STDIN (standard input)
for line in sys.stdin:
	#each line will be one segment of HL7 message
    # remove leading and trailing whitespace
	line = line.strip();
	
	# check if this one is MSH Segment
	if line.startswith('MSH|^~\&'):
		# split fields of segment
		words = line.split(strDelim);
		
		#check if all the 12 required fields in MSH are present
		if len(words) >= 12:
			event = words[8];
			print ('%s\t%s' % (event, 1));