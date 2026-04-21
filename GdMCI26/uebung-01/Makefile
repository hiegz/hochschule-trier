default: clean
	@python plot.py
	@typst compile main.typ
	@rm -rdf plot.pdf
	@mv main.pdf MCI_But_Volodymyr_1.pdf

clean:
	@rm -rdf MCI_But_Volodymyr_1.pdf
