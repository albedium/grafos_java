package grafo;

public class CreateXML {

	private String[] amigos = { "Samuel", "Alba", "Tux", "Mili", "Duke", "KK",
			"Sun", "Lua" };
	private String[] famosos = { "Dijk", "Tannen", "Linu", "Richard", "Bill",
			"C.S.Lewi" };

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

		for (int i = 0; i < amigos.length; i++)
			GenerateXML.gVertice(i * 100 + 1, amigos[i], i % 2 == 0 ? "M": "F");

		for (int i = 0; i < famosos.length; i++)
			GenerateXML.gVertice(i * 100 + 5, famosos[i], "M");
	}

	private void createEdge() {

		for (int i = 0; i < amigos.length; i++) {
			for (int j = 0; j < famosos.length; j++) {
				GenerateXML.gEdge(i * 100 + 1, j * 100 + 5);

			}
		}
	}

	public static void main(String[] args) {
		new CreateXML("grafo.xml");
		//new GraphVis("grafo.xml");
	}

}
