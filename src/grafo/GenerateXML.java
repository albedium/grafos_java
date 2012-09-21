package grafo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.File;


public class GenerateXML {
	
	//absolute path
	static String pathXML = "/home/luiz-varela/work/prefuse-beta/data/";

	// Add XML header
	public static StringBuffer file = new StringBuffer(
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<!--  An excerpt of an egocentric social network  -->\n<graphml xmlns=\"")
			.append("http://graphml.graphdrawing.org/xmlns\">\n\t<graph edgedefault=\"undirected\">\n\n\t\t<!-- data schema -->\n\t\t<key id=\"name\" for=\"node\"")
			.append(" attr.name=\"name\" attr.type=\"string\"/>\n\t\t<key id=\"gender\" for=\"node\" attr.name=\"gender\" attr.type=\"string\"/>\n\n\t\t<!-- nodes -->  ");

	// create nodes
	public static void gVertice(long userId, String name, String gender) {
		file.append("\n\t\t<node id=\"").append(userId).append("\">\n\t\t\t")
				.append("<data key=\"name\">").append(name)
				.append("</data>\n\t\t\t<data key=\"gender\">").append(gender)
				.append("</data>\n\t\t</node>");
	}

	// create Edges
	public static void gEdge(int idSource, int idTarget) {
		file.append("\n\t\t<edge source=\"").append(idSource)
				.append("\" target=\"").append(idTarget)
				.append("\"></edge>\n\t\t\t");
	}
	
	//open and close xml file
	public static void closeXML() {

		file.append("\n\n\t</graph>\n</graphml>");
	}
	
	//here we save all contents 
	public static void saveXML(String path) {
		
		try {
			
			//file path
			String fullPath = pathXML+path;
			
			File file_test = new File(fullPath);
			file_test.createNewFile();
			
			//write XML file e save it
			BufferedWriter out = new BufferedWriter(new FileWriter(fullPath));
			out.write(file.toString());
			out.flush();
			out.close();
			//Test for print XML
			System.out.print(file.toString());

		} catch (IOException e) {

			e.printStackTrace();
			System.err.println("Erro ao salvar arquivo...Saindo");
			System.exit(0);

		}

	}

}
