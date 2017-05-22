/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database.services.common;

import org.hibernate.Session;

/**
 * Batch update mechanizm class.
 * 
 * @author Michał 'Wicia' Wietecha
 */
public class Batcher {
    
    private final int BATCH_SIZE;
    private int number;
    
    public Batcher(int batchSize){
        this.BATCH_SIZE = batchSize;
        this.number = 0;
    }
    
    public void batchUpdate(Session session){
        if (number % BATCH_SIZE == 0 && number > 0) {
            session.flush();
            session.clear();
        }
        number++;
    }
    
    public void beginWork(){
       this.number = 0; 
    }
}
