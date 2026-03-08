package net.enset.presentation;

import net.enset.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresSpringXml {
    public static void main(String[] args) {
        ApplicationContext springContext = new ClassPathXmlApplicationContext("config.xml");
        //IMetier metier = (IMetier) springContext.getBean("metier");
        IMetier metier = springContext.getBean(IMetier.class);//pas besoin de faire le cast(meiux)
        System.out.println("res : "+metier.calcul());
    }
}
