public class Client {

    //Arguments
    String id;
    Planche planche;

    //Constructeur
    Client(String id, Planche planche){
        this.id = id;
        this.planche = planche;
    }

    //getteurs

    String getLargeur(){
        return this.planche.dimension.largeur;
    }

    String getLongeur(){
        return this.planche.dimension.longeur;
    }

    //methodes

    static boolean testDimension(String longeur, String largeur){

        boolean integerOrNotLongeur;
        boolean integerOrNotLargeur;
        //boolean dimensionValid;

        //test longeur
        try{
            Integer.parseInt(longeur);
            integerOrNotLongeur = true;

        } catch(Exception e){
            integerOrNotLongeur = false;
        }
        if (integerOrNotLongeur == false){
            System.out.println("longeur (" +longeur+ ") n'est pas un entier");
        } else {
            if (Integer.parseInt(longeur) >= 0){
                System.out.println("longeur ("+ longeur + ") est un entier positif");
            } else {
                System.out.println("longeur ("+ longeur + ") n'est pas un entier positif");
            }
        }

        //test largeur
        try{
            Integer.parseInt(largeur);
            integerOrNotLargeur = true;

        } catch(Exception e){
            integerOrNotLargeur = false;
        }
        if (integerOrNotLargeur == false){
            System.out.println("largeur (" +largeur+ ") n'est pas un entier");
        } else {
            if (Integer.parseInt(largeur) >= 0){
                System.out.println("largeur ("+ largeur + ") est un entier positif");
            } else {
                System.out.println("largeur ("+ largeur + ") n'est pas un entier positif");
            }
        }

        // test longeur > largeur
        


        return integerOrNotLongeur;
    }

}
