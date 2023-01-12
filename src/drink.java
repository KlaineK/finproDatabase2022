/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author KESHIA JEAN DARMA
 */
public class drink extends dish{
    String asize;
    String atype;
    
    public drink(String dname, int dprice, String did){
        super(dname, dprice, did);
    }

    //Overloading method from superclass
    public void setsize(String dsize){
        this.asize = dsize;
    }
    
    //Overloading method from superclass
    public void settype(String dtype){
        this.atype = dtype;
    }

    public String getsize(){
        return this.asize;
    }
    
    public String gettype(){
        return this.atype;
    }
}
