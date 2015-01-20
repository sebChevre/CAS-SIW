package xml;

import dao.ClientDAO;
import dao.CommandeDAO;
import dao.LigneCommandeDAO;
import dao.ProduitDAO;
import data.Commande;
import data.LigneCommande;
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
import java.util.Date;
import java.util.List;

/**
 * Created by seb on 10.09.14.
 */
public class CommandeToXml {

    public static void main(String[] args) throws Exception {

        new CommandeToXml().writeXmlFile();

    }

    void writeXmlFile() throws Exception{
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("commandes");
        doc.appendChild(rootElement);

        for(Commande c : loadCommandesFromDb()){

            Element commande = doc.createElement("commande");
            rootElement.appendChild(commande);

            Attr id = doc.createAttribute("id");
            id.setValue(String.valueOf(c.getCmdeId()));
            commande.setAttributeNode(id);

            Element date = doc.createElement("date");
            commande.appendChild(date);
            date.appendChild(doc.createTextNode(new Date(c.getCmdeDate().getTime()).toString()));

            Element client = doc.createElement("client");
            commande.appendChild(client);
            Attr clientId = doc.createAttribute("id");
            clientId.setValue(String.valueOf(new ClientDAO().getById((c.getClientClieId())).getClieId()));
            client.setAttributeNode(clientId);

            Element produits = doc.createElement("produits");
            commande.appendChild(produits);

            for(LigneCommande lcom : new LigneCommandeDAO().findByCommandeId(c.getCmdeId())){
                Element produit = doc.createElement("produit");
                produits.appendChild(produit);

                Attr prodId = doc.createAttribute("id");
                prodId.setValue(String.valueOf(lcom.getProduitProdId()));
                produit.setAttributeNode(prodId);

                Element nombre = doc.createElement("quantite");
                nombre.appendChild(doc.createTextNode(String.valueOf(lcom.getLncmProduitNombre())));
                produit.appendChild(nombre);

            }

        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("xml/commande.xml"));
        transformer.transform(source, result);
    }

    List<Commande> loadCommandesFromDb(){
        CommandeDAO cdao = new CommandeDAO();
        return cdao.findAll();
    }




}
