package net.enset.ext;

import net.enset.dao.IDao;

public class DaoImplV2 implements IDao {

    @Override
    public double getData() {
        System.out.println("Version capteurs");
        double t = 3;
        return t;
    }
}
