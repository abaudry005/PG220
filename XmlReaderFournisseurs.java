import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.*; 
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XmlReaderFournisseurs
{
    public static List<Fournisseur> reader(){

        // Liste des fournisseurs
        List<Fournisseur> listFournisseurs = new ArrayList<Fournisseur>();
        
        try {
            File inputFile = new File("fournisseurs.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            Element root = doc.getDocumentElement();
            NodeList fournisseursXml = root.getElementsByTagName("fournisseur");
            for (int i = 0; i < fournisseursXml.getLength(); i++){
                Element fournisseurXml = (Element) fournisseursXml.item(i);
                NodeList panneauxXml = fournisseurXml.getElementsByTagName("panneau");

                // Liste des panneaux des fournisseurs
                List<Panneau> listPanneaux = new ArrayList<Panneau>();

                int id = Integer.parseInt(fournisseurXml.getAttribute("id"));
                System.out.println("Fournisseur: " + id);

                for (int j = 0; j < panneauxXml.getLength(); j++){
                    Element panneauXml = (Element) panneauxXml.item(j);
                    Element dimXml = (Element) panneauXml.getElementsByTagName("dim").item(0);
                    

                    if (Panneau.isValid(panneauXml.getAttribute("prix"),panneauXml.getAttribute("date"),dimXml.getAttribute("L"),dimXml.getAttribute("l"))){
                        int idPanneau = Integer.parseInt(panneauXml.getAttribute("id"));
                        int nombre  = Integer.parseInt(panneauXml.getAttribute("nombre"));
                        String date  = panneauXml.getAttribute("date");
                        Double prix  = Double.parseDouble(panneauXml.getAttribute("prix"));
                        
                        Dimension dimension  = new Dimension(Double.parseDouble(dimXml.getAttribute("L")),Double.parseDouble(dimXml.getAttribute("l")));
                        Panneau panneau = new Panneau(idPanneau,date,prix,nombre,dimension);
                        System.out.println(" - nouveau panneau: " + idPanneau);
                        listPanneaux.add(panneau);
                    }
                    else{
                        int idPanneau = Integer.parseInt(panneauXml.getAttribute("id"));
                        System.out.println("Le panneau " + idPanneau + " du fournisseur " + id + "n'est pas correct");
                        System.exit(1);
                        
                    }

                }
    
                Fournisseur fournisseur = new Fournisseur(id, listPanneaux);
                listFournisseurs.add(fournisseur);

            }


        } catch(Exception e){
            System.out.println("erreur fournisseur" + e);
        }
        return listFournisseurs;

    } 
}