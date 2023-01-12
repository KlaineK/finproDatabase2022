/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
/**
 *
 * @author KESHIA JEAN DARMA
 */
public class order<P,O> extends menusajian{
    P pakan;
    O ombe;
    int subtotal = 0;
    ArrayList<O> ombengelist = new ArrayList();
    ArrayList<P> pakanngelist = new ArrayList();
    
    public void setOorder(O ombe){
        ombengelist.add(ombe);
    }

    public void setPorder(P pakan){
        pakanngelist.add(pakan);
    }

    public ArrayList<O> getOorder(){
        return this.ombengelist;
    }

    public ArrayList<P> getPorder(){
        return this.pakanngelist;
    }
    
    public void removingmn(){
        this.ombengelist.clear();
        this.pakanngelist.clear();
    }
}
