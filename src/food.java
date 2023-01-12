/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author KESHIA JEAN DARMA
 */
public class food extends dish{
    String fsize;
    String ftype;
    
    public food(String dname, int dprice, String did){
        super(dname, dprice, did);
    }

    //Overloading method from superclass
    public void setsize(String dsize){
        this.fsize = dsize;
    }
    
    //Overloading method from superclass
    public void settype(String dtype){
        this.ftype = dtype;
    }

    public String getsize(){
        return this.fsize;
    }
    
    public String gettype(){
        return this.ftype;
    }
}