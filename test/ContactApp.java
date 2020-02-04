package test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import test.BST.Node;

public class ContactApp {
    public static BST tree = new BST();
    static Node root = new Node(78, "Name", "LastName", "email", "gender", 000, 100, false);  
    static Stack poshte = new Stack();
        
    public static String[] OrChoise(String []or){
        Scanner input = new Scanner(System.in);
        System.out.println("Which info you gonna give me:"
                 + "\n1.Number"
                 + "\n2.Name"
                 + "\n3.Last Name"
                 + "\n4.Email"
                 + "\n5.Birthday"
                 + "\n6.Age"
                 + "\n7.Gender"
                + "\n8.Confirm the given info.");
        int choise = input.nextInt();
        long infoNumber;
        String infoName;
        String infoLastName;
        String infoEmail;
        int infoBirthday;
        int infoAge;
        String infoGender;
        switch (choise){
            case 1:
                infoNumber = input.nextInt();
                or[0] = Long.toString(infoNumber);
                OrChoise(or);
                break;
            case 2:
                infoName = input.next();
                or[1] = infoName;
                OrChoise(or);
                break;
            case 3:
                infoLastName =input.next();
                or[2] = infoLastName;
                OrChoise(or);
                break;
            case 4:
                infoEmail = input.next();
                or[3] = infoEmail;
                OrChoise(or);
                break;
            case 5:
                infoBirthday = input.nextInt();
                or[4] = Long.toString(infoBirthday);
                OrChoise(or);
                break;
            case 6:
                infoAge = input.nextInt();
                or[5] = Long.toString(infoAge);
                OrChoise(or);
                break;
            case 7:
                infoGender = input.next();
                or[6] = infoGender;
                OrChoise(or);
                break;
            case 8:
                return or;
                
                
        }
        return or;
    }
    
    
    public static void menu(){
        Scanner input = new Scanner(System.in);
        
        System.out.println("1.Insert"
                + "\n2.Search Contact"
                + "\n3.Show Contact"
                + "\n4.Delete Contact"
                + "\n5.Edit Contact"
                + "\n6.Undo" 
                + "\n7.Redo"
                + "\n8.And"
                + "\n9.Or"
                + "\n10.Similarity Search"
                + "\n11.Sorting"
                + "\n12.Conectivity"
                + "\n13.Conectivity"
                + "\n14.Add Someone in Favorite"
                + "\n15.Delete Someone From Favorite"
                + "\n16.Show Favorite List"
                + "\n17.Exit From App"
        );
        while(true){    
        int k = input.nextInt();
        switch(k){
            case 1:
                System.out.print("Enter Contact Number: ");
                long phoneNumber = input.nextLong();
                System.out.print("Enter Contact Name: ");
                String cName = input.next();
                System.out.print("Enter Contact LastName: ");
                String cLastName = input.next();
                System.out.println("Enter Contact Email: ");
                String cEmail = input.next();
                System.out.println("Enter Contact Gender: 1.Female 2.Male");
                int choise = input.nextInt();
                String cGender = null;
               
                
        switch (choise) {
            case 1:
                cGender = "Female";
                break;
            case 2:
                cGender = "Male";
                break;
            default:
                System.out.println("invalid input!");
                break;
        }
                System.out.println("Enter Conatct Birthday: ");
                int cBirthday = input.nextInt();
                System.out.println("Enter Contact Age: ");
                int cAge = input.nextInt();
                tree.insert(phoneNumber, cName, cLastName, cEmail, cGender, cBirthday, cAge, false);
                tree.inorder(); 
                break;

                
            case 2:
                String SearchKey = input.next();
                String sPhoneNumber;
                boolean a;
                try{
                    Long.parseLong(SearchKey);
                    a = true;
                }
                catch(NumberFormatException e){
                    a = false;
                }
                
                if(a){
                    sPhoneNumber = SearchKey;
                }
                else{
                    sPhoneNumber = "0";
                }
                
                tree.search(sPhoneNumber , SearchKey);
                tree.inorder();
                break;
            case 3:
                System.out.println("Contact Info:");
                tree.Show();
                break;
            case 4:
                String DelKey = input.next();
                String DelNumber;
                boolean z;
                try{
                    Long.parseLong(DelKey);
                    z = true;
                }
                catch(NumberFormatException e){
                    z = false;
                }
                
                if(z){
                    DelNumber = DelKey;
                }
                else{
                    DelNumber = "0";
                }
                tree.delete(DelNumber, DelKey);
                tree.inorder();
                break;
                
            case 5:
                System.out.print("Enter Name or Phone Number to edit: ");
                String Edit = input.next();
                String ENumber;
                boolean ed;
                try{
                    Long.parseLong(Edit);
                    ed = true;
                }
                catch(NumberFormatException e){
                    ed = false;
                }
                
                if(ed){
                    ENumber = Edit;
                }
                else{
                    ENumber = "0";
                }
                tree.edit(ENumber , Edit);
                tree.inorder();
                break;
                
            case 6:
                tree.undo();
                tree.inorder();
                break;
            case 7:
                tree.redo();
                tree.inorder();
                break;
            case 8: 
                tree.And();
                tree.printRes();
                break;
            case 9:
                String [] or = new String[] {"0", "0","0","0","0","0","0"};
                or = OrChoise(or);
                tree.OR(or);
                tree.printRes();
                break;
            case 10:
                tree.SimilaritySearch();
                tree.printRes();
                break;
            case 11:
                tree.sort();
                tree.inorder();
                break;
            case 12:
                System.out.println("enter first number and name");
                String numtest1= input.next();
                String nametest1 =input.next();
                System.out.println("enter seconde number and name");
                String numtest2= input.next();
                String nametest2 = input.next();
                Node test1 =tree.Search(root,numtest1 , nametest1);
                Node test2 =tree.Search(root,numtest2 , nametest2);
                if(tree.Conectivity(test1, test2) == true )
                {
                    System.out.println("first contact is conected with second contact");
                }
                else
                    System.out.println("first contact is not conected with second contact");
                
            case 13:
                System.out.println("enter first number and name");
                String w= input.next();
                String namew =input.next();
                System.out.println("enter seconde number and name");
                String q= input.next();
                String nameq = input.next();
                tree.Search(root, w, namew).connection.add(tree.Search(root, q, nameq));
                tree.Search(root, q, nameq).connection.add(tree.Search(root, w, namew));
                break;
            case 14:
                System.out.println("Enter Name or Number of Who Shoud Put in Favorite: ");
                String FavoritKey = input.next();
                String FavoNumber;
                boolean v;
                try{
                    Long.parseLong(FavoritKey);
                    v = true;
                }
                catch(NumberFormatException e){
                    v = false;
                }
                
                if(v){
                    FavoNumber = FavoritKey;
                }
                else{
                    FavoNumber = "0";
                }
                tree.favorite(FavoNumber, FavoritKey);
                tree.inorder();
                break;
            case 15:
                System.out.println("Enter Name or Number of Who Shoud Get Out of Favorite List: ");
                String NotFavoritKey = input.next();
                String NotFavoNumber;
                boolean o;
                try{
                    Long.parseLong(NotFavoritKey);
                    o = true;
                }
                catch(NumberFormatException e){
                    o = false;
                }
                
                if(o){
                    NotFavoNumber = NotFavoritKey;
                }
                else{
                    NotFavoNumber = "0";
                }
                tree.deleteFavorite(NotFavoNumber, NotFavoritKey);
                tree.inorder();
                break;
            case 16:
                tree.showFList();
                break;
            case 17:
                System.exit(0);
            default:
                System.out.println("Enter a number from the list: ");
        }
        }
    }

    public static void main(String[] args) {
        
         menu();
  

    }
    
}
