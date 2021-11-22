class Main {

	public static void main(String[] args) {
        
        //Client client = new Client("-3","11");
        //String largeur = client.getLargeur();
        //String longeur = client.getLongeur();

        //test dimension
        //Client.testDimension(longeur, largeur);

        try {
            XmlReaderPerso.Reader();
        } catch(Exception e) {
            System.out.println("fichier introuvable");
        }
        

	}

}