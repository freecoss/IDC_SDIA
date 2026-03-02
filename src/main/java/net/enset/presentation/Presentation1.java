package net.enset.presentation;

import net.enset.dao.DaoImpl;
import net.enset.metier.MetierImpl;

public class Presentation1 {
    public static void main(String[] args) {
        DaoImpl d = new DaoImpl();
        MetierImpl metier = new MetierImpl(d);
        //metier.setDao(d); Injection avec le setter
        System.out.println("Res : "+metier.calcul());
    }
}
