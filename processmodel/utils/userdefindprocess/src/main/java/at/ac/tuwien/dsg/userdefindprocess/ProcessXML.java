/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ac.tuwien.dsg.userdefindprocess;
import java.io.File;
import java.io.FileWriter;
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
 * @author Anindita
 */
public class ProcessXML {
   

 
	public static void main(String argv[]) {
 
	  try {
 
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                String processId="P1";
 
		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("process");
                doc.appendChild(rootElement);
                
                // set attribute to the root element
                Attr attr = doc.createAttribute("id");
		attr.setValue(processId);
		rootElement.setAttributeNode(attr);
 
		// activity elements
		Element activity = doc.createElement("activity");
		rootElement.appendChild(activity);
 
		// set attribute to activity element
		Attr attr1 = doc.createAttribute("name");
		attr1.setValue("Sampling");
		activity.setAttributeNode(attr1);
 
		
		// add the start element of edge of activity
		Element from = doc.createElement("from");
		from.appendChild(doc.createTextNode("start"));
		activity.appendChild(from);
 
		// add the end element of edge of activity
                Element to = doc.createElement("to");
		to.appendChild(doc.createTextNode("end"));
		activity.appendChild(to);
 
		
                //for xml file storage
                {
                File f=new File("./example3");
                   if(!f.exists())
                        {
                            f.mkdir();
                            System.out.println("file created");
                        }
                            else
                        {
                            System.out.println("file is exist");
                        }
                            TransformerFactory transformerFactory = TransformerFactory.newInstance();
                            Transformer transformer = transformerFactory.newTransformer();
                            DOMSource source = new DOMSource(doc);
                            StreamResult result = new StreamResult(new File("./example3/"+processId+".xml"));
                            transformer.transform(source, result);
                        
 
                            System.out.println("File saved!");
                }
 
	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	}
} 

