public class Panneau {

    //Arguments
    String id;
    String date;
    String prix;
    String nombre;
    Dimension dimension;

    //Constructeur
    Panneau(String id, String date, String prix, String nombre, Dimension dimension){
        this.id = id;
        this.date = date;
        this.prix = prix;
        this.nombre = nombre;
        this.dimension = dimension;
    }
}