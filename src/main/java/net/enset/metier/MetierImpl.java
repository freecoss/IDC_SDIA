package net.enset.metier;
import net.enset.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier {
    //@Autowired // Injection directe
    //@Qualifier("d")

    //private IDao dao; couplage forte
    private IDao dao;//couplage faible

    //Injection dans l'attribut dao un objet de classe qui implemente
    //l'interface IDao au moment de l'instanciation du classe MetierImpl
    //(Plus rapide et preferable)
    public MetierImpl(@Qualifier("d2") IDao dao) {
        this.dao = dao;
    }

//    public MetierImpl() {
//    }

    @Override
    public double calcul() {
        double t = dao.getData();
        double res = t*20;
        return res;
    }

    //Injection dans l'attribut dao un objet de classe qui implemente
    //l'interface IDao apres l'instanciation (mauvaise pratique)

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
