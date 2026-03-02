package net.enset.presentation;

import net.enset.ext.DaoImplV2;
import net.enset.metier.MetierImpl;

public class Presentation1 {
    public static void main(String[] args) {
        DaoImplV2 d = new DaoImplV2();
        MetierImpl metier = new MetierImpl(d);
        //metier.setDao(d); Injection avec le setter
        System.out.println("Res : "+metier.calcul());
    }
}
