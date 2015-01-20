package xml;

import dao.ClientDAO;
import dao.ProduitDAO;
import data.Client;
import data.Produit;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
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
public class ProduitToXml {

    public static void main(String[] args) throws Exception {

        new ProduitToXml().writeXmlFile();

    }

    void writeXmlFile() throws Exception{
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("produits");
        doc.appendChild(rootElement);

        for(Produit p : loadProduitFromDb()){
            Element produit = doc.createElement("produit");
            rootElement.appendChild(produit);

            Attr id = doc.createAttribute("id");
            id.setValue(String.valueOf(p.getProdId()));
            produit.setAttributeNode(id);

            Element description = doc.createElement("description");
            description.appendChild(doc.createTextNode(p.getProdDesc()));
            produit.appendChild(description);

            Element prix = doc.createElement("prix");
            prix.appendChild(doc.createTextNode(String.valueOf(p.getProdPrix())));
            produit.appendChild(prix);



        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("xml/produit.xml"));
        transformer.transform(source, result);
    }

    List<Produit> loadProduitFromDb(){
        ProduitDAO pdao = new ProduitDAO();
        return pdao.findAll();
    }




}
