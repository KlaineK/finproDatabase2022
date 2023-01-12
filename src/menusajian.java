/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author KESHIA JEAN DARMA
 */
public class menusajian<M> {
    M pangan;
    ArrayList<M> menu = new ArrayList();
    
    public void addmenu(M pangan){
        menu.add(pangan);
    }

    public ArrayList<M> getmenu(){
        return this.menu;
    }

    public void display(){
        //think about a way to display an objects attribute, despite different
        //type of objects.
        //Half-a-way : using a return method such as this :
        //<U> U cetak(){
        //    return (U) obj;
        //}
        //We can refer to a specific object in the arraylist.
    }
    
    public void mengedit(int index, M objek){
        this.menu.set(index,objek);
    }
}
