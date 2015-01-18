import java.util.ArrayList;

/**
 * Created by sce on 15.01.2015.
 */
public class PaysList {

    private ArrayList<Pays> pays = new ArrayList<Pays>(){
        {
            add(new Pays("Suisse","1222"));
            add(new Pays("Allemagne","3321"));
        }
    };

}
