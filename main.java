/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;//genrating exception for IO classes
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.*;

/**
 *
 * @author KESHIA JEAN DARMA
 */

public class main {

    /**
     * @param args the command line arguments
     */
    public static Scanner in = new Scanner(System.in);
    
    //menu arraylist
    public static menusajian <food> menubread = new menusajian();
    public static menusajian <food> menucake = new menusajian();
    public static menusajian <food> menupast = new menusajian();
    public static menusajian <drink> menuice = new menusajian();
    public static menusajian <drink> menuhot = new menusajian();
    
    //order arraylist
    //public static menusajian<drink> pesenombe = new menusajian();
    //public static menusajian<food> pesenmangan = new menusajian();
    public static order <food,drink> orderan = new order();
    
    public static void payment(){
        String custom_name;
        System.out.print("Customer Name : ");
        custom_name = in.nextLine();
        int counter = orderan.getPorder().size();
        int counter1 = orderan.getOorder().size();

        double total = displaysub();
        double paying = 0;
        while(paying < total){
            System.out.print("Please insert sufficient amount :");
            paying = in.nextDouble();
            in.nextLine();
        }

        try{
            FileWriter cetak = new FileWriter("D:\\Computer\\KULIAH\\Kuliah"
                    + "\\Semester 3\\Object Oriented Programming"
                    + "\\Assignment\\TUGAS_OOP\\src\\test\\java\\receipt.txt");
            cetak.write("-=-=-=-=-=-=-=-=DoaIbu=-=-=-=-=-=-=-=-\n");
            cetak.write("\tMx. " + custom_name + "\n");
            for(int i = 0 ; i < counter; i++){
                cetak.write("\t" + orderan.getPorder().get(i).getname() + 
                        "\t" + orderan.getPorder().get(i).getprice() + "\n");
            }
            
            for(int i = 0 ; i < counter1; i++){
                cetak.write("\t" + orderan.getOorder().get(i).getname() + 
                        "\t" + orderan.getOorder().get(i).getprice()+ "\n");
            }
            cetak.write("Total : " + total + "\n");
            cetak.write("Payment : " + paying + "\n");
            cetak.write("Change :" + (paying-total) + "\n");
            cetak.close();
            System.out.println("Receipt generated.");
        }
        catch(IOException e){
            System.out.println("An Error occured.");
        }
    }
    
    public static void remove(){
        System.out.println("Which menu would you like to remove?");
        System.out.println("Enter 99 to exit edit menu");
        double subtotal = displaysub();
        int choice = -1;
        int countorder = orderan.getOorder().size() + orderan.getPorder().size();
        while(choice < 1 || choice > countorder && choice != 99){
            System.out.println("Choose 1");
            //when choice refer to makan menu
            if(choice > orderan.getOorder().size() && choice < countorder) {
                choice = choice - 1 - orderan.getOorder().size();
                for(int i = choice ; i < orderan.getPorder().size() - 1; i++){
                    orderan.getPorder().set(i, 
                            orderan.getPorder().get(i+1));
                }
            }
            //when choice refer to minum menu
            else if(choice < orderan.getOorder().size() && choice < countorder){
                for(int i = 0 ; i < orderan.getOorder().size() - 1; i++){
                    orderan.getOorder().set(i, 
                            orderan.getOorder().get(i+1));
                }
            }
        }
    }
    
    public static double displaysub(){
        double subtotal = 0;
        int limitMinum = orderan.getOorder().size();
        for(int i = 0 ; i < limitMinum; i++){
            System.out.print((i+1) + ". ");
            System.out.println(orderan.getOorder().get(i).getname()
            + " || Price : " + orderan.getOorder().get(i).getprice());
            subtotal += orderan.getOorder().get(i).getprice();
        }
        int limitMakan = orderan.getPorder().size();
        for(int i = limitMinum ; i < limitMakan; i++){
            System.out.print((i+1) + ". ");
            System.out.println(orderan.getPorder().get(i).getname()
            + " || Price : " + orderan.getPorder().get(i).getprice());
            subtotal += orderan.getPorder().get(i).getprice();
        }
        return subtotal;
    }
    
    public static void breads(){
        int pesen = -1;
        while(pesen < 1 || pesen > 7){
            System.out.println("||Breads||");
            for(int i = 0; i < menubread.getmenu().size(); i++){
                System.out.print((i+1) + ". ");
                System.out.println(menubread.getmenu().get(i).getname()+
                        " || Price : " + menubread.getmenu().get(i).getprice());
            }
            System.out.println("Choose your option [1-7] : ");
            pesen = in.nextInt();
            in.nextLine();
        }
        pesen -= 1;
        food smentara = menubread.getmenu().get(pesen);
        orderan.setPorder(smentara);
    }
    
    public static void cakes(){
        int pesen = -1;
        while(pesen < 1 || pesen > 7){
            System.out.println("||Cakes||");
            for(int i = 0; i < menucake.getmenu().size(); i++){
                System.out.print((i+1) + ". ");
                System.out.println(menucake.getmenu().get(i).getname()+
                        " \\|\\| Price : " + menucake.getmenu().get(i).getprice());
            }
            System.out.println("Choose your option [1-7] : ");
            pesen = in.nextInt();
            in.nextLine();
        }
        pesen -= 1;
        food smentara = menucake.getmenu().get(pesen);
        orderan.setPorder(smentara);     
    }
    
    public static void pastries(){
        int pesen = -1;
        while(pesen < 1 || pesen > 7){
            System.out.println("||Pastries||");
            for(int i = 0; i < menupast.getmenu().size(); i++){
                System.out.print((i+1) + ". ");
                System.out.println(menupast.getmenu().get(i).getname()+
                        " || Price : " + menupast.getmenu().get(i).getprice());
            }
            System.out.println("Choose your option [1-7] : ");
            pesen = in.nextInt();
            in.nextLine();
        }
        pesen -= 1;
        food smentara = menupast.getmenu().get(pesen);
        orderan.setPorder(smentara);
    }
    
    public static void ice(){
        int pesen = -1;
        while(pesen < 1 || pesen > 7){
            System.out.println("||Iced Drinks||");
            for(int i = 0; i < menuice.getmenu().size(); i++){
                System.out.print((i+1) + ". ");
                System.out.println(menuice.getmenu().get(i).getname()+
                        " || Price : " + menuice.getmenu().get(i).getprice());
            }
            System.out.println("Choose your option [1-7] : ");
            pesen = in.nextInt();
            in.nextLine();
        } 
        pesen -= 1;        
        drink smentara = menuice.getmenu().get(pesen);
        orderan.setOorder(smentara);
    }
    
    public static void hot(){
        int pesen = -1;
        while(pesen < 1 || pesen > 7){
            System.out.println("||Hot Drinks||");
            for(int i = 0; i < menuhot.getmenu().size(); i++){
                System.out.print((i+1) + ". ");
                System.out.println(menuhot.getmenu().get(i).getname()+
                        " || Price : " + menuhot.getmenu().get(i).getprice());
            }
            System.out.println("Choose your option [1-7] : ");
            pesen = in.nextInt();
            in.nextLine();
        }
        pesen -= 1;
        drink smentara = menuhot.getmenu().get(pesen);
        orderan.setOorder(smentara);       
    }
    
    public static void confirmorder(){
        //editing order
        int conforder = -1;
        while (conforder < 1 || conforder > 2){
            System.out.println("This is the orders : ");
            double total = displaysub();
            System.out.println("Your subtotal is : " + total);            
            System.out.println("Is there anything unwanted? [1-2]");
            System.out.println("1. Yes");
            System.out.println("2. No");
            conforder = in.nextInt();
            in.nextLine();
        }
        if(conforder == 1) remove();
        else payment();        
    }
    
    public static void mainmenu(){ 
        int chosen = -1;
        while(chosen < 1 || chosen > 7){
            System.out.println("Choose our menu : ");
            System.out.println("1. Breads");
            System.out.println("2. Cakes");
            System.out.println("3. Pastries");
            System.out.println("4. Iced Drinks");
            System.out.println("5. Hot Drinks");
            System.out.println("6. Exit");
            System.out.println("7. Checkout");
            System.out.println("[Please enter a choice from 1 to 7]");
            chosen = in.nextInt();
            in.nextLine();
            
            if (chosen == 1) breads();
            else if(chosen == 2) cakes();
            else if(chosen == 3) pastries();
            else if(chosen == 4) ice();
            else if(chosen == 5)hot();
            else if(chosen == 6)return;
            else if(chosen == 7)confirmorder();
            chosen = 0;
        }
    }
    
    public static void edit(){
        String smensize;
        double smenprice;
        int opedit = -1;
        int klas = -1;
        while(opedit < 1 || opedit > 6){
            System.out.println("Which one would you like to edit? [1-5]");
            System.out.println("1. Breads");
            System.out.println("2. Cakes");
            System.out.println("3. Pastries");
            System.out.println("4. Iced Drinks");
            System.out.println("5. Hot Drinks");
            System.out.println("6. Exit");
            System.out.println("Enter your input : ");
            opedit = in.nextInt();
            in.nextLine();
            while(opedit != 6){
                if(opedit == 1) {
                    System.out.println("||Bread||");
                    while(klas < 1 || klas > 7){
                        for(int i = 0; i < menubread.getmenu().size(); i++){
                        System.out.print((i+1) + ". ");
                        System.out.println(menubread.getmenu().get(i).getname()+
                                " \\|\\| Price : " + menubread.getmenu().get(i).getprice() + 
                                " \\|\\| Size : " + menubread.getmenu().get(i).gettype());
                        }
                        System.out.println("Choose your option [1-7] : ");
                        klas = in.nextInt();
                        in.nextLine();
                    }
                    klas -= 1;
                    System.out.println("Specify new size : ");
                    smensize = in.nextLine();
                    System.out.println("Specify new price : ");
                    smenprice = in.nextDouble();
                    in.nextLine();
                    food smen = new food(menubread.getmenu().get(klas).getname(), 
                            smenprice,
                            menubread.getmenu().get(klas).getid());
                    menubread.fedit(klas, smen);
                }
                else if(opedit == 2) {
                    System.out.println("||Cakes||");
                    while(klas < 1 || klas > 7){
                        for(int i = 0; i < menucake.getmenu().size(); i++){
                        System.out.print((i+1) + ". ");
                        System.out.println(menucake.getmenu().get(i).getname()+
                                " \\|\\| Price : " + menucake.getmenu().get(i).getprice() + 
                                " \\|\\| Size : " + menucake.getmenu().get(i).gettype());
                        }
                        System.out.println("Choose your option [1-7] : ");
                        klas = in.nextInt();
                        in.nextLine();
                    }
                    klas -= 1;
                    System.out.println("Specify new size : ");
                    smensize = in.nextLine();
                    System.out.println("Specify new price : ");
                    smenprice = in.nextDouble();
                    in.nextLine();
                    food smen = new food(menucake.getmenu().get(klas).getname(), 
                            smenprice,
                            menucake.getmenu().get(klas).getid());
                    menucake.fedit(klas, smen);
                }
                else if(opedit == 3) {
                    System.out.println("||Pastries||");
                    while(klas < 1 || klas > 7){
                        for(int i = 0; i < menupast.getmenu().size(); i++){
                        System.out.print((i+1) + ". ");
                        System.out.println(menupast.getmenu().get(i).getname()+
                                " \\|\\| Price : " + menupast.getmenu().get(i).getprice() + 
                                " \\|\\| Size : " + menupast.getmenu().get(i).gettype());
                        }
                        System.out.println("Choose your option [1-7] : ");
                        klas = in.nextInt();
                        in.nextLine();
                    }
                    klas -= 1;
                    System.out.println("Specify new size : ");
                    smensize = in.nextLine();
                    System.out.println("Specify new price : ");
                    smenprice = in.nextDouble();
                    in.nextLine();
                    food smen = new food(menupast.getmenu().get(klas).getname(), 
                            smenprice,
                            menupast.getmenu().get(klas).getid());
                    menupast.fedit(klas, smen);
                }
                else if(opedit == 4) {
                    System.out.println("||Iced Drinks||");
                    while(klas < 1 || klas > 7){
                        for(int i = 0; i < menuice.getmenu().size(); i++){
                        System.out.print((i+1) + ". ");
                        System.out.println(menuice.getmenu().get(i).getname()+
                                " \\|\\| Price : " + menuice.getmenu().get(i).getprice() + 
                                " \\|\\| Size : " + menuice.getmenu().get(i).gettype());
                        }
                        System.out.println("Choose your option [1-7] : ");
                        klas = in.nextInt();
                        in.nextLine();
                    }
                    klas -= 1;
                    System.out.println("Specify new size : ");
                    smensize = in.nextLine();
                    System.out.println("Specify new price : ");
                    smenprice = in.nextDouble();
                    in.nextLine();
                    drink smen = new drink(menuice.getmenu().get(klas).getname(), 
                            smenprice,
                            menuice.getmenu().get(klas).getid());
                    menuice.fedit(klas, smen);                
                }
                else if(opedit == 5){
                    System.out.println("||Hot Drinks||");
                    while(klas < 1 || klas > 7){
                        for(int i = 0; i < menuhot.getmenu().size(); i++){
                        System.out.print((i+1) + ". ");
                        System.out.println(menuhot.getmenu().get(i).getname()+
                                " \\|\\| Price : " + menuhot.getmenu().get(i).getprice() + 
                                " \\|\\| Size : " + menuhot.getmenu().get(i).gettype());
                        }
                        System.out.println("Choose your option [1-7] : ");
                        klas = in.nextInt();
                        in.nextLine();
                    }
                    klas -= 1;
                    System.out.println("Specify new size : ");
                    smensize = in.nextLine();
                    System.out.println("Specify new price : ");
                    smenprice = in.nextDouble();
                    in.nextLine();
                    drink smen = new drink(menuhot.getmenu().get(klas).getname(), 
                            smenprice,
                            menuhot.getmenu().get(klas).getid());
                    menuhot.fedit(klas, smen);            
                }
            }       
        }
    }
    
    public static void scanmenu(){
        try{
            File dmenu = new File("D:\\Computer\\KULIAH\\Kuliah"
                    + "\\Semester 3\\Object Oriented Programming"
                    + "\\Assignment\\TUGAS_OOP\\src\\test\\java\\dishmenu.txt");
            Scanner baca = new Scanner(dmenu);
            while(baca.hasNextLine()){
                String temp_file = baca.nextLine();

                //using pattern-match with delimiter |
                //determine dishcode, dishname, dishprice,dishsize,dishtype(5 coloumn)
                /*Dish code reference :
                F0_ : Breads
                F1_ : Cakes
                F2_ : Pastries
                D0_ : Iced Drinks
                D1_ : Hot drinks
                Make sure the file doesn't have any typo in it.
                */
                
                //Pipe (|) is a special character in regex.
                //To escape it, you need to prefix it with backslash (\).
                //But in java, backslash is also an escape character.                 
                //So again you need to escape it with another backslash. 
                //Your regex should be \\|
                
                //temporary attributes for dishes 
                Pattern pola = Pattern.compile("\\|");
                String[] hasil = pola.split(temp_file); 
                String id = hasil[0];
                String name = hasil[1];
                double price = Double.parseDouble(hasil[2]);
                String size = hasil[3];
                String type = hasil[4];
                Arrays.fill(hasil,null);

                //categorizing food and drinks
                if(id.startsWith("F")) {
                    
                    food roti = new food(name, price, id);
                    roti.setsize(size);
                    roti.settype(type);

                    //listing menu
                    if(id.startsWith("F0")) menubread.addmenu(roti);
                    else if(id.startsWith("F1")) menucake.addmenu(roti);
                    else if(id.startsWith("F2")) menupast.addmenu(roti);
                }
                else {
                    drink air = new drink(name, price, id);
                    air.setsize(size);
                    air.settype(type);      

                    //listing menu
                    if(id.startsWith("D0")) menuice.addmenu(air);
                    else if(id.startsWith("D1")) menuhot.addmenu(air);
                }
            }
            baca.close();
        }catch(Exception e) {
            System.out.println("An error occured.");
        }
    }    
    
    public static void main(String[] args) {
        //declarations
        String check_name = "";
        String check_pass = "";
        employee raden = new employee();
        int login = -1;
        scanmenu();
        //exit-validation 
        while(login < 1 || login > 3){
            System.out.println("Do you want to login?");
            System.out.println("1. Yes.");
            System.out.println("2. No.");
            System.out.println("3. Edit");
            System.out.println("[Enter your input]");
            login = in.nextInt();
            in.nextLine();
            if(login == 2) return;
            else if (login == 3);
        }
        
        /*Cari cara supaya dia bisa baca dari file, masuk ke variabel, variabel->initialization*/
        
        while(!check_name.equals(raden.getname()) || !check_pass.equals(raden.getpass())){
            //log in page
            System.out.println("||===================||");
            System.out.print("Name : ");
            check_name = in.nextLine();
            System.out.print("Password : ");
            check_pass = in.nextLine();
            System.out.println("||===================||");

            //validation
            if(!check_name.equals(raden.getname()) || !check_pass.equals(raden.getpass())){
                System.out.println("Wrong Password!");
            }
            else System.out.println("Welcome!");
        }
        
        //displaying menu
        mainmenu();
        
        //generating receipt
        try{
            File bon = new File("D:\\Computer\\KULIAH\\Kuliah"
                    + "\\Semester 3\\Object Oriented Programming\\Assignment"
                    + "\\TUGAS_OOP\\src\\test\\java\\receipt.txt");
            //if file created UNsuccessfully
            if(bon.createNewFile()){
                System.out.println("File created.");
            }
            else{
                System.out.println("Error in File Creation.");
            }
        }
        catch(Exception e){
            System.out.println("An error occured.");
        }
    }   
}
