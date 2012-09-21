package grafo;

public class CreateXML {

	private String[] singer = { "Bruce", "Ozzy", "Eddie" };
	private String[] band = { "Iron Maiden", "Black Sabath", "Pearl Jam" };

	public CreateXML(String graphName) {

		createVertice();
		createEdge();
		createXMLFile(graphName);

	}

	private void createXMLFile(String fileName) {

		GenerateXML.closeXML();
		GenerateXML.saveXML(fileName);

	}

	private void createVertice() {

		for (int i = 0; i < singer.length; i++)
			GenerateXML.gVertice(i * 100 + 1, singer[i], i % 2 == 0 ? "M": "F");

		for (int i = 0; i < band.length; i++)
			GenerateXML.gVertice(i * 100 + 5, band[i], "M");
	}

	private void createEdge() {

		for (int i = 0; i < singer.length; i++) {
			for (int j = 0; j < band.length; j++) {
				GenerateXML.gEdge(i * 100 + 1, j * 100 + 5);

			}
		}
	}

	public static void main(String[] args) {
		new CreateXML("grafo.xml");
		
	}

}
