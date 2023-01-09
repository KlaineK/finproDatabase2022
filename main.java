/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner;

/**
 *
 * @author KESHIA JEAN DARMA
 */
public class main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        //declarations
        Scanner in = new Scanner(System.in);
        String check_name = "";
        String check_pass = "";
        employee raden = new employee();
        
        while(!check_name.equals(raden.getname()) && !check_pass.equals(raden.getpass())){
            //log in page
            System.out.println("||=================||");
            System.out.println("Name : ");
            check_name = in.nextLine();
            System.out.println("Password : ");
            check_pass = in.nextLine();
            System.out.println("||=================||");

            //validation
            if(!check_name.equals(raden.getname()) && !check_pass.equals(raden.getpass())){
                System.out.println("Wrong Password!");
            }            
        }
        
        
    }
    
}
