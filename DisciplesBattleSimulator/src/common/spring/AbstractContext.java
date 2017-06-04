/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package common.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class AbstractContext implements ApplicationContextAware{
    
    public static final String FILE_NAME = "spring-config.xml";
    private ClassPathXmlApplicationContext context;
    
    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = (ClassPathXmlApplicationContext)context;
        ((ConfigurableApplicationContext)this.context).registerShutdownHook();
    }

    public boolean hasContext() {
        return context != null;
    }
    
    public static String getFullPath(String path){
        return path + "/" + FILE_NAME;
    }
    
    public Object getBean(Class clazzName){
        return context.getBean(clazzName);
    }
}
