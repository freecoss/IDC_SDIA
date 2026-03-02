package net.enset.dao;

public class DaoImpl implements IDao {
    @Override
    public double getData() {
        System.out.println("Version base de donnees");
        double t = 20;
        return t;
    }
}
