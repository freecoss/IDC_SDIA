package net.enset.presentation;

import net.enset.dao.IDao;
import net.enset.metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Presentation2 {
    //FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("config.txt"));

        String daoClassName = sc.nextLine();
        Class cDao = Class.forName(daoClassName);
        //Object dao = cDao.newInstance();
        IDao d = (IDao) cDao.newInstance();//Pour specifier de quel objet s'agit il

        String metierClassName = sc.nextLine();
        Class cMetier = Class.forName(metierClassName);
        //Object dao = cDao.newInstance();
        //IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(d);
        IMetier metier = (IMetier) cMetier.getConstructor().newInstance();
        Method setDao = metier.getClass().getDeclaredMethod("setDao",IDao.class);//metier.getDeclaredMethod()
        setDao.invoke(metier,d);//execute setDao using invoke method in metier, with d parameter
        System.out.println("Res : "+metier.calcul());
    }
}
