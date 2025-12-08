run:
	java Program.java input.txt actual-output.txt false false
	java TransformerThingy.java input.txt expected-output.txt false false

sort:
	java Program.java input.txt actual-output.txt false true
	java TransformerThingy.java input.txt expected-output.txt false true

count:
	java Program.java input.txt actual-output.txt true false | sort > actual-count.txt
	java TransformerThingy.java input.txt expected-output.txt true false | sort > expected-count.txt

sort_and_count:
	java Program.java input.txt actual-output.txt true true | sort > actual-count.txt
	java TransformerThingy.java input.txt expected-output.txt true true | sort > expected-count.txt

clean:
	rm -rdf actual-output.txt
	rm -rdf actual-count.txt
	rm -rdf expected-output.txt
	rm -rdf expected-count.txt
