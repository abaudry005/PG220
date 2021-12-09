import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.*; 
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XmlReaderClients
{
    public static List<Client> reader(){

        // Liste des clients
        List<Client> listClients = new ArrayList<Client>();
        
        try {
            File inputFile = new File("clients.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            Element root = doc.getDocumentElement();
            NodeList clientsXml = root.getElementsByTagName("client");
            for (int i = 0; i < clientsXml.getLength(); i++){
                Element clientXml = (Element) clientsXml.item(i);
                NodeList planchesXml = clientXml.getElementsByTagName("planche");

                // Liste des planches des clients
                List<Planche> listPlanches = new ArrayList<Planche>();

                int id = Integer.parseInt(clientXml.getAttribute("id"));
                System.out.println("Client: " + id);

                for (int j = 0; j < planchesXml.getLength(); j++){
                    Element plancheXml = (Element) planchesXml.item(j);
                    Element dimXml = (Element) plancheXml.getElementsByTagName("dim").item(0);
                    

                    if (Planche.isValid(plancheXml.getAttribute("prix"),plancheXml.getAttribute("date"),dimXml.getAttribute("L"),dimXml.getAttribute("l"))){
                        int idPlanche = Integer.parseInt(plancheXml.getAttribute("id"));
                        String date  = plancheXml.getAttribute("date");
                        Double prix  = Double.parseDouble(plancheXml.getAttribute("prix"));
                        
                        Dimension dimension  = new Dimension(Double.parseDouble(dimXml.getAttribute("L")),Double.parseDouble(dimXml.getAttribute("l")));
                        Planche planche = new Planche(idPlanche,date,prix,dimension);
                        System.out.println(" - nouvelle planche: " + idPlanche);
                        listPlanches.add(planche);
                    }
                    else{
                        int idPlanche = Integer.parseInt(plancheXml.getAttribute("id"));
                        System.out.println("Le planche " + idPlanche + " du client " + id + "n'est pas correct");
                        System.exit(1);
                        
                    }

                }
    
                Client client = new Client(id, listPlanches);
                listClients.add(client);

            }


        } catch(Exception e){
            System.out.println("erreur client" + e);
        }
        return listClients;

    } 
}