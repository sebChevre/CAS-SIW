package xml;

import dao.ClientDAO;
import data.Client;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

/**
 * Created by seb on 10.09.14.
 */
public class ClientToXml {

    public static void main(String[] args) throws Exception {

        new ClientToXml().writeXmlFile();

    }

    void writeXmlFile() throws Exception{
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("clients");
        doc.appendChild(rootElement);

        for(Client c : loadClientFromDb()){
            Element client = doc.createElement("client");
            rootElement.appendChild(client);

            Attr id = doc.createAttribute("id");
            id.setValue(String.valueOf(c.getClieId()));
            client.setAttributeNode(id);

            Element nom = doc.createElement("nom");
            nom.appendChild(doc.createTextNode(c.getClieNom()));
            client.appendChild(nom);

            Element prenom = doc.createElement("prenom");
            prenom.appendChild(doc.createTextNode(c.getCliePrenom()));
            client.appendChild(prenom);

            Element rue = doc.createElement("rue");
            rue.appendChild(doc.createTextNode(c.getClieRue()));
            client.appendChild(rue);

            Element localite = doc.createElement("localite");
            localite.appendChild(doc.createTextNode(c.getClieLocalite()));
            client.appendChild(localite);

        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("xml/client.xml"));
        transformer.transform(source, result);
    }

    List<Client> loadClientFromDb(){
        ClientDAO cdao = new ClientDAO();
        return cdao.findAll();
    }




}
