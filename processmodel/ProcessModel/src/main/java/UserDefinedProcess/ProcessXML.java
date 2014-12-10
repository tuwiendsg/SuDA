/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserDefinedProcess;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
 
/**
 *
 * @author dsg
 */
public class ProcessXML {
   

 
	public static void main(String argv[]) {
 
	  try {
 
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("process");
                doc.appendChild(rootElement);
                
                // set attribute to the root element
                Attr attr = doc.createAttribute("id");
		attr.setValue("1rty");
		rootElement.setAttributeNode(attr);
 
		// activity elements
		Element activity = doc.createElement("activity");
		rootElement.appendChild(activity);
 
		// set attribute to activity element
		Attr attr1 = doc.createAttribute("name");
		attr1.setValue("Sampling");
		activity.setAttributeNode(attr1);
 
		// shorten way
		// staff.setAttribute("id", "1");
 
		// firstname elements
		Element from = doc.createElement("from");
		from.appendChild(doc.createTextNode("start"));
		activity.appendChild(from);
 
		// lastname elements
		Element to = doc.createElement("to");
		to.appendChild(doc.createTextNode("end"));
		activity.appendChild(to);
 
		// nickname elements
		/*Element nickname = doc.createElement("nickname");
		nickname.appendChild(doc.createTextNode("mkyong"));
		activity.appendChild(nickname);
 
		// salary elements
		Element salary = doc.createElement("salary");
		salary.appendChild(doc.createTextNode("100000"));
		activity.appendChild(salary);*/
 
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("./example3/file.xml"));
 
		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);
 
		transformer.transform(source, result);
 
		System.out.println("File saved!");
 
	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	}
} 

