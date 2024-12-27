package com.cydeo.bean_annotation;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.config.ComputerConfig;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {                            //Basically we are testing PC here. But to create the PC we need
    public static void main(String[] args) {           //Case,Monitor,and Motherboard objects which are not yet created
                                                       //To create the PC we need to 1st create the container but at this
                                                       //point we don't have ApplicationContext Interface since it doesn't
                                                       //come with JDK. So you shoul add it to your pom as a dependency.
       //Creating container by using Application Context-We use this one
       ApplicationContext container=new AnnotationConfigApplicationContext(ComputerConfig.class);

       //Creating container by using BeanFactory  -Just for your refereance.
       BeanFactory context=new AnnotationConfigApplicationContext(ComputerConfig.class);
       Case theCase=container.getBean(Case.class);

       Monitor theMonitor=container.getBean(Monitor.class);
       Motherboard theMotherboard=container.getBean(Motherboard.class);
       PC myPC=new PC(theCase,theMonitor,theMotherboard);


       myPC.powerUp();

    }
}
