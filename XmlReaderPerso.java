import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.util.*; 

public class XmlReaderPerso
{
    public static void Reader() throws ParserConfigurationException, SAXException 
    { 
        /*-------------------Clients-------------------*/

        // Liste des clients
        List<Client> Clients = new ArrayList<Client>();

        try {
            File file = new File("clients.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            document.getDocumentElement().normalize();
            System.out.println("\nRoot Element :" + document.getDocumentElement().getNodeName());

            // Listes par tags
            NodeList nListClient = document.getElementsByTagName("client");
            NodeList nListPlanche = document.getElementsByTagName("planche");
            NodeList nListDim = document.getElementsByTagName("dim");

            // affichage
            System.out.println("----------------------------");
            System.out.println("Commandes");
            System.out.println("----------------------------");

            // Parcours des listes
            for (int temp = 0; temp < nListClient.getLength(); temp++) {

                // Noeud Principal
                Node nNodeClient = nListClient.item(temp);
                Node nNodePlanche = nListPlanche.item(temp);
                Node nNodeDim = nListDim.item(temp);

                System.out.println("\nCurrent Element :" + nNodeClient.getNodeName());
                if (nNodeClient.getNodeType() == Node.ELEMENT_NODE) {

                    // Cast
                    Element eElementClient = (Element) nNodeClient;
                    Element eElementPlanche = (Element) nNodePlanche;
                    Element eElementDim = (Element) nNodeDim;

                    // Affichage
                    System.out.println("Client id : " + eElementClient.getAttribute("id"));
                    System.out.println("    Planches id     : " + eElementPlanche.getAttribute("id"));
                    System.out.println("    Planches nombre : " + eElementPlanche.getAttribute("nombre"));
                    System.out.println("    Planches date   : " + eElementPlanche.getAttribute("date"));
                    System.out.println("    Planches prix   : " + eElementPlanche.getAttribute("prix"));
                    System.out.println("        dim longueur   : " + eElementDim.getAttribute("L"));
                    System.out.println("        dim largeur    : " + eElementDim.getAttribute("l"));

                    // creation arguments du client (Planche) + (dimensions)
                    Dimension dimension = new Dimension(eElementDim.getAttribute("L"),eElementDim.getAttribute("l"));
                    Planche planche = new Planche(eElementPlanche.getAttribute("id"),eElementPlanche.getAttribute("date"),eElementPlanche.getAttribute("prix"),dimension);

                    // Creation client
                    Client client = new Client(eElementClient.getAttribute("id"), planche);
                    
                    //ajout client à la liste
                    Clients.add(client);

                }
            }
        }
        catch(IOException e) {
            System.out.println(e);
        } 

        /*-------------------Fournisseurs-------------------*/
        try {
            File file = new File("fournisseurs.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            document.getDocumentElement().normalize();
            System.out.println("\nRoot Element :" + document.getDocumentElement().getNodeName());

            // Listes par tags
            NodeList nListFournisseurs = document.getElementsByTagName("fournisseur");
            NodeList nListPanneaux = document.getElementsByTagName("panneau");
            NodeList nListDimBis = document.getElementsByTagName("dim");

            // affichage
            System.out.println("----------------------------");
            System.out.println("Stock");
            System.out.println("----------------------------");

            // Parcours des listes
            for (int tempBis = 0; tempBis < nListFournisseurs.getLength(); tempBis++) {

                // Noeud Principal
                Node nNodeFournisseurs = nListFournisseurs.item(tempBis);
                Node nNodePanneaux = nListPanneaux.item(tempBis);
                Node nNodeDimBis = nListDimBis.item(tempBis);

                System.out.println("\nCurrent Element :" + nNodeFournisseurs.getNodeName());
                if (nNodeFournisseurs.getNodeType() == Node.ELEMENT_NODE) {

                    // Cast
                    Element eElementFournisseurs = (Element) nNodeFournisseurs;
                    Element eElementPanneaux = (Element) nNodePanneaux;
                    Element eElementDimBis = (Element) nNodeDimBis;

                    System.out.println("Fournisseur id : " + eElementFournisseurs.getAttribute("id"));
                    System.out.println("    Panneaux id     : " + eElementPanneaux.getAttribute("id"));
                    System.out.println("    Panneaux nombre : " + eElementPanneaux.getAttribute("nombre"));
                    System.out.println("    Panneaux date   : " + eElementPanneaux.getAttribute("date"));
                    System.out.println("    Panneaux prix   : " + eElementPanneaux.getAttribute("prix"));


                    System.out.println("        dim longueur   : " + eElementDimBis.getAttribute("L"));//pb
                    System.out.println("        dim largeur    : " + eElementDimBis.getAttribute("l"));

                }
            }
        }
        catch(IOException e) {
            System.out.println(e);
        } 
    }
}