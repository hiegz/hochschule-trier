release: prepare compile biber
	pdflatex -output-directory=out main.tex

compile: prepare
	pdflatex -output-directory=out main.tex

biber: compile
	biber out/main

prepare:
	mkdir -p out
