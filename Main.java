import java.util.*; 

class Main {

	public static void main(String[] args) {
        
        //Client client = new Client("-3","11");
        //String largeur = client.getLargeur();
        //String longeur = client.getLongeur();

        //test dimension
        //Client.testDimension(longeur, largeur);

        // Liste des clients
        List<Client> Clients = new ArrayList<Client>();

        // Liste des fournisseurs
        List<Fournisseur> Fournisseurs = new ArrayList<Fournisseur>();

        try {
            Clients = XmlReaderClient.Reader();
        } catch(Exception e) {
            System.out.println("fichier introuvable");
        }

        try {
            Fournisseurs = XmlReaderFournisseur.Reader();
        } catch(Exception e) {
            System.out.println("fichier introuvable");
        }

	}

}