#!/usr/bin/python

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