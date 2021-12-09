import java.util.ArrayList;

public class Planche {

    //Arguments
    int id;
    String date;
    Double prix;
    Dimension dimension;

    //Constructeur
    Planche(int id, String date, Double prix, Dimension dimension){
        this.id = id;
        this.date = date;
        this.prix = prix;
        this.dimension = dimension;
    }

    //Methode
    static boolean isValid(String p,String d, String lon, String lar){

        ArrayList<Character> list = new ArrayList<Character>();
        list.add('0');
        list.add('1');
        list.add('2');
        list.add('3');
        list.add('4');
        list.add('5');
        list.add('6');
        list.add('7');
        list.add('8');
        list.add('9');
        

        String date = d;
        String prix = p;
        int tmp = 0;
        Character str1 = '.';

        if(!(str1.equals(date.charAt(2)))){
            return false;
        }

        if(!(str1.equals(date.charAt(5)))){
            return false;
        }

        for (int i = 0; i < date.length(); i++){
            if((i != 2) || (i != 5)){
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).equals(date.charAt(i))){
                        tmp++;
                    }

                }
            }
        }

        if (tmp != date.length()-2){
            return false;
        }

        int year_cli = Character.getNumericValue(date.charAt(6))*10 + Character.getNumericValue(date.charAt(7)) ;

        int month_cli = Character.getNumericValue(date.charAt(3))*10 + Character.getNumericValue(date.charAt(4)) ;

        int day_cli = Character.getNumericValue(date.charAt(0))*10 + Character.getNumericValue(date.charAt(1)) ;

        if((20 > year_cli) || (year_cli > 99)){
            return false;
        }
        if((1 > month_cli) || (month_cli > 12)){
            return false;
        }
        if((1 > day_cli) || (day_cli > 31)){
            return false;
        }


        
        if(!(str1.equals(prix.charAt(prix.length() - 3)))){
            return false;
        }
        
        tmp = 0;
        for (int i = 0; i < prix.length(); i++){
            if(i != prix.length()-3){
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).equals(prix.charAt(i))){
                        tmp++;
                    }
                }
            }
        }

        if (tmp != prix.length()-1){
            return false;
        }

        if(false == Dimension.isValid(lon,lar)){
            System.out.println("dimmensions incorrectes");
            return false;
        }

        return true;
    }
}