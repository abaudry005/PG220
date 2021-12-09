import java.util.List;

public class Fournisseur {

    //Arguments
    int id;
    List<Panneau> panneau;

    //Constructeur
    Fournisseur(int id, List<Panneau> panneau){
        this.id = id;
        this.panneau = panneau;
    }
}
