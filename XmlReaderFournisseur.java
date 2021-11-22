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

public class XmlReaderFournisseur
{
    public static List<Fournisseur> Reader() throws ParserConfigurationException, SAXException {

        // Liste des fournisseurs
        List<Fournisseur> Fournisseurs = new ArrayList<Fournisseur>();

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


                    System.out.println("        dim longueur   : " + eElementDimBis.getAttribute("L"));
                    System.out.println("        dim largeur    : " + eElementDimBis.getAttribute("l"));

                    // creation arguments du client (Planche) + (dimensions)
                    Dimension dimension = new Dimension(eElementDimBis.getAttribute("L"),eElementDimBis.getAttribute("l"));
                    Panneau panneau = new Panneau(eElementPanneaux.getAttribute("id"),eElementPanneaux.getAttribute("date"),eElementPanneaux.getAttribute("prix"),eElementPanneaux.getAttribute("nombre"),dimension);
                    
                    // Creation client
                    Fournisseur Fournisseur = new Fournisseur(eElementFournisseurs.getAttribute("id"), panneau);
                                        
                    //ajout client à la liste
                    Fournisseurs.add(Fournisseur);
                }
            }
        }
        catch(IOException e) {
            System.out.println(e);
        } 

        // Renvoie de la liste des fournisseurs
        return Fournisseurs;

    } 
}
    