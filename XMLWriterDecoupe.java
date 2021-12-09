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
import java.util.*; 

public class XMLWriterDecoupe {

    public static void writer(List<Decoupe> listDecoupe) {
        
        try {
            
            List<Decoupe> decoupes = new ArrayList<Decoupe>();

            Decoupe a = new Decoupe(1,3,170,17,0,0);
            decoupes.add(a);

            Decoupe b = new Decoupe(4,5,80,50,0,0);

            decoupes.add(b);


            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();

            // élément de racine
            Document doc = docBuilder.newDocument();
            Element racine = doc.createElement("decoupes");
            doc.appendChild(racine);

            for (int i = 0; i <= decoupes.size()-1; i++){
                Decoupe dec =  decoupes.get(i);

                // l'élément contact
                Element decoupe = doc.createElement("decoupe");
                racine.appendChild(decoupe);

                Element client = doc.createElement("client");
                decoupe.appendChild(client);

                // attributs de l'élément id
                Attr attr1 = doc.createAttribute("id");
                attr1.setValue(Integer.toString(dec.client_id));
                client.setAttributeNode(attr1);

                Attr attr2 = doc.createAttribute("planche");
                attr2.setValue(Integer.toString(dec.planche_id));
                client.setAttributeNode(attr2);

                Element fournisseur = doc.createElement("fournisseur");
                decoupe.appendChild(fournisseur);

                Attr attrA = doc.createAttribute("id");
                attrA.setValue(Integer.toString(dec.four_id));
                fournisseur.setAttributeNode(attrA);

                Attr attrB = doc.createAttribute("panneau");
                attrB.setValue(Integer.toString(dec.panneau_id));
                fournisseur.setAttributeNode(attrB);

                Element position = doc.createElement("position");
                decoupe.appendChild(position);

                Attr attrD = doc.createAttribute("x");
                attrD.setValue(Integer.toString(dec.x));
                position.setAttributeNode(attrD);

                Attr attrE = doc.createAttribute("y");
                attrE.setValue(Integer.toString(dec.y));
                position.setAttributeNode(attrE);
            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult resultat = new StreamResult(new File("decoupe_X.xml"));
    
            transformer.transform(source, resultat);
    
            System.out.println("Fichier sauvegardé avec succès!");
   
       } catch (ParserConfigurationException pce) {
           pce.printStackTrace();
       } catch (TransformerException tfe) {
           tfe.printStackTrace();
       }
    }
  }