/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author KESHIA JEAN DARMA
 */
public class dish {
    String dname;
    int dprice;
    private String did;
    String dsize;
    String dtype;
    
    public dish(String dname, int dprice, String did){
        this.dname = dname;
        this.dprice = dprice;
        this.did = did;
    }
    
    public String getname(){
        return this.dname;
    }
    
    public int getprice(){
        return this.dprice;
    }
    
    public String getid(){
        return this.did;
    }
    
    public void setsize(){
        this.dsize = "Medium";
    }
    
    public void settype(){
        this.dtype = "Purchaseable";
    }
}
