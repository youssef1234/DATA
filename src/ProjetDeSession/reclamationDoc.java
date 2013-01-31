/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetDeSession;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author YOUSSEF
 */
public class reclamationDoc {
    
    private Document doc;
    public reclamationDoc(String documentFilePath)
            throws ParserConfigurationException, SAXException, IOException {
        parseXmlDocument(documentFilePath);
    }

    private void parseXmlDocument(String documentFilePath)
            throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory documentFactory = initializeDocumentFactory();
        DocumentBuilder parser = documentFactory.newDocumentBuilder();
        doc = parser.parse(documentFilePath);
    }
    private DocumentBuilderFactory initializeDocumentFactory() {
        DocumentBuilderFactory documentFactory 
                                    = DocumentBuilderFactory.newInstance();
        documentFactory.setIgnoringComments(true);
        documentFactory.setCoalescing(true);
        documentFactory.setNamespaceAware(true);
        return documentFactory;
    }
    
    public void execution() {
        System.out.println("Mon premier test commit .   .  . . ");
    }
     public void saveToFile(String filePath) throws Exception {
        Source domSource = new DOMSource(doc);
        File xmlFile = new File(filePath);
        Result serializationResult = new StreamResult(xmlFile);
        Transformer xmlTransformer = TransformerFactory.newInstance().newTransformer();
        xmlTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
        xmlTransformer.transform(domSource, serializationResult);
    }
    
}
    

