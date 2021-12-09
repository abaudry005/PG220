public class Dimension {

    //Arguments
    Double longeur;
    Double largeur;

    //Constructeur
    Dimension(Double longeur, Double largeur){
        this.longeur = longeur;
        this.largeur = largeur;
    }

    static boolean isValid(String lon,String lar){

        int cent_L = Character.getNumericValue(lon.charAt(lon.length()-2)) + Character.getNumericValue(lon.charAt(lon.length()-1));
        int cent_l = Character.getNumericValue(lar.charAt(lar.length()-2)) + Character.getNumericValue(lar.charAt(lar.length()-1));

        if((cent_L != 0) || (cent_l != 0)){
            return false;
        }

        Double lo = Double.parseDouble(lon);
        Double la = Double.parseDouble(lar);


        if((lo < la) || (lo < 0) || (la < 0)){
            return false;
        }

        return true;

    }
}