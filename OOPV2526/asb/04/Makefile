all: zip

zip:
	zip -r ISBN.zip oop/isbn

check:
	checkstyle -c=checkstyle.xml oop/isbn

clean:
	rm -rdf ISBN.zip
