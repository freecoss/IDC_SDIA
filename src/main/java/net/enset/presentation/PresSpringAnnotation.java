package net.enset.presentation;

import net.enset.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresSpringAnnotation {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("net.enset");
                //new AnnotationConfigApplicationContext("net.enset.dao","net.enset.metier");
        IMetier metier = applicationContext.getBean(IMetier.class);
        System.out.println("Rest = "+metier.calcul());
    }
}
