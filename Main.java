import java.util.*; 
class Main {

	public static void main(String[] args) {

        // Liste des clients
        List<Client> clients = new ArrayList<Client>();

        // Liste des fournisseurs
        List<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();

        // Lecture fichier XML
        clients = XmlReaderClients.reader();
        fournisseurs = XmlReaderFournisseurs.reader();

        System.out.println("fournisseur test    : " + clients.get(2).planche.get(0).date);
        System.out.println("fournisseur test    : " + fournisseurs.get(2).panneau.get(0).date);

        // Decoupe


        List<Decoupe> listDecoupe = new ArrayList<Decoupe>();

        // Ecriture du fichier SVG
        XMLWriterDecoupe.writer(listDecoupe);


	}

}