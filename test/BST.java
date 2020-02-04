package test;
import java.util.ArrayList;
import java.util.Scanner;
import test.BST.Node;
import test.Stack;

public class BST {
    public static class Node {
        Node Lchild;
        Node Rchild;
        long number;
        String name;
        String lastname;
        String email;
        String gender;
        int birthday;
        int age;
        ArrayList <Node> connection = new ArrayList <Node>(); 
        boolean favorite;

        public Node() {
        }

        public Node(long number) {
            this.number = number;
        }
        
        
        public Node(long Number1, String Name1, String LastName1, String Email1, String Gender1, int Birthday1, int Age1, boolean Favorite1) {
           number = Number1;
           Lchild = Rchild = null;
           name = Name1;
           lastname = LastName1;
           email = Email1;
           gender = Gender1;
           birthday = Birthday1;
           age = Age1;
           favorite = Favorite1;
        }
    }
    
   Node root; 
    BST() {
        root = null;
    }
    
    ArrayList<Node> result = new ArrayList<>();
    Stack undo = new Stack();
    Stack redo = new Stack();
    
    
    public Node Search (Node root , String number, String name){
        System.out.println("in search");
        if (root == null){
            System.out.println("You Have no contact in this device.");
        }
        else{
            for(int i = 0; i<inorder.size(); i++){
                if(inorder.get(i).name.equals(name)){
                    result.add(inorder.get(i));
                }
                else if(inorder.get(i).lastname.equals(name)){
                    result.add(inorder.get(i));
                }
                else if(inorder.get(i).number == Long.parseLong(number)){
                    result.add(inorder.get(i));
                }
                else if(inorder.get(i).birthday == Long.parseLong(number)){
                    result.add(inorder.get(i));
                }
                else if(inorder.get(i).age == Long.parseLong(number)){
                    result.add(inorder.get(i));
                }
                else if(inorder.get(i).gender.equals(name)){
                    result.add(inorder.get(i));
                }
                else if(inorder.get(i).email.equals(name)){
                    result.add(inorder.get(i));
                }
            }
        }
        return root;
    }
    
    public Node SearchNode(Node val){
        boolean z = false;
        for (int i = 0; i < inorder.size(); i++){
            if(inorder.get(i) == val){
                z = true;
                return inorder.get(i);
            }
        }
        if(z == false){
            return null;
        }
        return root;
    }

    public boolean SearchAnd(Node val){
        boolean z = false;
        for(int i = 0; i < inorder.size(); i++){
            if(val.name.equals(inorder.get(i).name) 
                    && val.lastname.equals(inorder.get(i).lastname) 
                    && val.email.equals(inorder.get(i).email) 
                    && val.gender.equals(inorder.get(i).gender) 
                    && val.number == inorder.get(i).number 
                    && val.birthday == inorder.get(i).birthday 
                    && val.age == inorder.get(i).age ){
                z = true;
                return true;
            }
        }
        if(z == false){
            return false;
        }
        return true;
    }
    public Node Insert(Node root,long number, String name,String lastname, String email, String gender, int birthday, int age, boolean favorite) {
        if (root == null) {
            root = new Node(number, name, lastname, email, gender, birthday, age, false);
            return root;
        }
        if (number < root.number) {
            root.Lchild = Insert(root.Lchild, number, name, lastname, email, gender, birthday, age, false);
        }
        else if (number > root.number) {
            root.Rchild = Insert(root.Rchild, number, name,lastname, email, gender, birthday, age, false);
        }
        return root;
    }
     
    ArrayList<Node> inorder = new ArrayList<>();
    public void Inorder(Node root) {
        if (root != null) {
            Inorder(root.Lchild);
            inorder.add(root);
            Inorder(root.Rchild);
            
        }
    }
    void sort(){
        Sort(root);
    }
    public void Sort(Node root){
        System.out.println("Sort by which field?"
                + "\n1.Number"
                + "\n2.Name"
                + "\n3.LastName"
                + "\n4.Email"
                + "\n5.Birthday"
                + "\n6.Age");
        int choise =input.nextInt();
        
        //ArrayList of names
        ArrayList <String> sortName = new ArrayList<String>();
        ArrayList <String> sortLastName = new ArrayList<String>();
        ArrayList <String> sortEmail = new ArrayList<String>();
        ArrayList <Integer> sortBirthday = new ArrayList<Integer>();
        ArrayList <Integer> sortAge = new ArrayList<Integer>();
        for(int i = 0; i<inorder.size(); i++){
            sortName.add(inorder.get(i).name);
            sortLastName.add(inorder.get(i).name);    
            sortEmail.add(inorder.get(i).name);
        }

        int nameSize = inorder.size();
        
        //ArrayList of lastname
        
        for(int i = 0; i<inorder.size(); i++){
            sortLastName.add(inorder.get(i).lastname);
            sortName.add(inorder.get(i).lastname);  
            sortEmail.add(inorder.get(i).lastname);
        }

        int lastnameSize = inorder.size();
        
        //ArrayList of emails
        
        for(int i = 0; i<inorder.size(); i++){
            sortLastName.add(inorder.get(i).email);
            sortName.add(inorder.get(i).email);  
            sortEmail.add(inorder.get(i).email);
        }
            
        int emailSize = inorder.size();
        
        //ArrayList of birthdays
        
        for(int i = 0; i<inorder.size(); i++){
            sortBirthday.add(inorder.get(i).birthday);
            sortAge.add(inorder.get(i).birthday);
        }
            
        int birthdaySize = inorder.size();
        
        //ArrayList of ages
        
        for(int i = 0; i<inorder.size(); i++){
            sortAge.add(inorder.get(i).age);
            sortBirthday.add(inorder.get(i).age);
        }
            
        int ageSize = inorder.size();
        
        switch(choise){
            case 1:
                Show();
                break;
            case 2:
              for(int i = 0; i < nameSize - 1; i++){
                  for(int j = i+1; j < nameSize; j++){
                      if(sortName.get(i).compareTo(sortName.get(j))>0){
                          String temp = sortName.get(i); 
                          sortName.remove(i);
                          sortName.add(i, sortName.get(j));
                          sortName.remove(i);
                          sortName.add(j, temp);
                      }
                     }
                    }
                   for(int a = 0; a < inorder.size(); a++){
                       System.out.println(sortName.get(a));
                   }
                break;
            case 3:
                for(int k = 0; k < lastnameSize-1; k++){
                  for(int z = k+1; z < lastnameSize; z++){
                      if(sortLastName.get(k).compareTo(sortLastName.get(z))>0){
                          String temp = sortLastName.get(k); 
                          sortLastName.remove(k);
                          sortLastName.add(k, sortLastName.get(z));
                          sortLastName.remove(k);
                          sortLastName.add(z, temp);
                      }
                     }
                    }
                   for(int b = 0; b < inorder.size(); b++){
                       System.out.println(sortLastName.get(b));
                   }
                break;
            case 4:
                for(int m = 0; m < emailSize-1; m++){
                  for(int n = m+1; n < emailSize; n++){
                      if(sortEmail.get(m).compareTo(sortEmail.get(n))>0){
                          String temp = sortLastName.get(m); 
                          sortEmail.remove(m);
                          sortEmail.add(m, sortEmail.get(n));
                          sortEmail.remove(m);
                          sortEmail.add(n, temp);
                      }
                     }
                    }
                   for(int c = 0; c < inorder.size(); c++){
                       System.out.println(sortLastName.get(c));
                   }
                break;
            case 5:
                for(int p = 0; p < birthdaySize-1; p++){
                    for(int q = p+1; q < birthdaySize; q++){
                        if(sortBirthday.get(p).compareTo(sortBirthday.get(q))>0){
                            int temp1 = sortBirthday.get(p);
                            sortBirthday.remove(p);
                            sortBirthday.add(p, sortBirthday.get(q));
                            sortBirthday.remove(p);
                            sortBirthday.add(q, temp1);
                    }
                }
                }
                for(int d =0; d < inorder.size(); d++){
                    System.out.println(sortBirthday.get(d));
                }
                break;
            case 6:
                for(int x = 0; x < ageSize-1; x++){
                    for(int y = x+1; y < ageSize; y++){
                        if(sortAge.get(x).compareTo(sortAge.get(y))>0){
                            int temp2 = sortAge.get(x);
                            sortAge.remove(x);
                            sortAge.add(x, sortAge.get(y));
                            sortAge.remove(x);
                            sortAge.add(x, temp2);
                    }
                }
                }
                for(int e =0; e < inorder.size(); e++){
                    System.out.println(sortAge.get(e));
                }
                break;
                   }
       
        
    }
    
    public boolean Conectivity(Node p1 ,Node p2){
        
         
        for(int i = 0; i < p1.connection.size(); i++){
           if(p1.connection.get(i).number == p2.number)
               return true;
        }
        return false;
    }
   
    
    
    public void Show(){
        for(int i =0; i< inorder.size(); i++){
            System.out.println((i+1) + "." + inorder.get(i).name+ " " + inorder.get(i).lastname +  " " + inorder.get(i).number +  " " + inorder.get(i).email +  " " + inorder.get(i).birthday +  " " + inorder.get(i).gender +  " " + inorder.get(i).age + " " + (inorder.get(i).favorite ? " Favorite ":" Not Favorite ") +  "Founded :D");
        }
        
    } 
    
    

    
    Node Delete(Node root, long number){
     
        if (root == null)  return root; 
        if (number < root.number) 
            root.Lchild = Delete(root.Lchild, number); 
        else if (number > root.number) 
            root.Rchild = Delete(root.Rchild, number); 
        else
        { 
            if (root.Lchild == null) {
                Node temp = root.Rchild;
                return temp; 
            }
            else if (root.Rchild == null) {
                Node temp = root.Lchild;
                return temp;
            }
            
            Node temp = minValue(root.Rchild); 
            root.number = temp.number;
            root.Rchild = Delete(root.Rchild, temp.number); 
        } 
        return root; 
    } 
        Node minValue(Node root) 
    { 
        Node minv = root; 
        while (root.Lchild != null) 
        { 
            minv = minv.Lchild; 
        } 
        return minv; 
    } 
    
    void insert(long number, String name, String lastname, String email, String gender, int birthday, int age, boolean favorite) {
        root = Insert(root, number, name, lastname, email, gender, birthday, age, false);
    }
    
    Scanner input = new Scanner(System.in);
    
    Node select(ArrayList<Node> res){
        if(res.isEmpty()){
            System.out.println("No Matched Contact!");
        }
        else if(res.size() == 1){
            return res.get(0);
        }
        else if (res.size() > 1){
            System.out.println("Select item to delete: ");
            for(int i = 0; i < result.size(); i++){
                System.out.println((i+1) + "." + result.get(i).name+ " " + result.get(i).lastname +  " " + result.get(i).number +  " " + result.get(i).email +  " " + result.get(i).birthday +  " " + result.get(i).gender +  " " + result.get(i).age + " " + (inorder.get(i).favorite ? " Favorite ":" Not Favorite ") +   " Founded :D");
            }
            int val = input.nextInt() - 1;
            return res.get(val);
        }
        return null;
    }
    

    public Node copy(Node bst1){
        if (bst1 == null) {
            return null;
        }
        Node copy = new Node(bst1.number, bst1.name,bst1.lastname, bst1.email, bst1.gender, bst1.birthday, bst1.age, bst1.favorite );
        copy.Lchild = copy(bst1.Lchild);
        copy.Rchild = copy(bst1.Rchild);
        return copy;
    }
    
    void printRes(){
        if (result.size()>0){
            for(int i = 0; i < result.size(); i++){
                System.out.println(result.get(i).name+ " " + result.get(i).lastname +  " " + result.get(i).number +  " " + result.get(i).email +  " " + result.get(i).birthday +  " " + result.get(i).gender +  " " + result.get(i).age + " " + (inorder.get(i).favorite ? " Favorite ":" Not Favorite ") +   " Founded :D");
            }
            result.clear();
        }
        else{
            System.out.println("Not Found :( ");
        }
    }
    
    void search (String number, String name){
        root = Search(root, number, name);
        printRes();
        result.clear();
    }
    Node delete (String number, String name){
        Search(root, number, name);
        Node res = select(result);
        if(res != null){
            undo.push(res);
            root = Delete(root, res.number);
            result.clear();
            return root;
        }
        result.clear();
        return root;
    }
    
    
    Node favorite(String number, String name){
        Search(root, number, name);
        Node res = select(result);
        System.out.println("res: " + res.number);
        if(res != null){
            undo.push(res);
            res.favorite = true;
            result.clear();
            return root;
        }
        result.clear();
        return root;
    }
    
    
    Node deleteFavorite(String number, String name){
        Search(root, number, name);
        Node res = select(result);
        System.out.println("res: " + res.number);
        if(res != null){
            undo.push(res);
            res.favorite = false;
            result.clear();
            return root;
        }
        result.clear();
        return root;
    }

    
    void showFList(){
        boolean s = false;
        for(int i =0; i< inorder.size(); i++){
            if(inorder.get(i).favorite){
                System.out.println((i+1) + "." + inorder.get(i).name+ " " + inorder.get(i).lastname +  " " + inorder.get(i).number +  " " + inorder.get(i).email +  " " + inorder.get(i).birthday +  " " + inorder.get(i).gender +  " " + inorder.get(i).age + " " + (inorder.get(i).favorite ? " Favorite ":" Not Favorite ") +  "Founded :D");    
                s = true;
            }
        }
        if(s == false){
            System.out.println("No One in Favorite List!");
        }
    }
    
     Node undo(){
        if(undo.isEmpty()){
            System.out.println("Nothing to undo!");
        }
        else{
            Node undoNode = undo.pop();
            System.out.println("UndoNode: " + undoNode);
            Node res = SearchNode(undoNode);
            System.out.println("Resualt: " + res);
            if(res == null){
                System.out.println("in Undo delete");
                redo.push(undoNode);
                root = Insert(root, undoNode.number, undoNode.name, undoNode.lastname, undoNode.email, undoNode.gender, undoNode.birthday, undoNode.age, undoNode.favorite);
                return root;
            }
            else{
                Node copyNode = undo.pop();
                redo.push(copyNode);
                redo.push(undoNode);
                System.out.println("Undo Delete: " + undoNode);
                System.out.println("Undo Insert: " + copyNode);
                root = Delete(root, undoNode.number);
                root = Insert(root, copyNode.number, copyNode.name, copyNode.lastname, copyNode.email, copyNode.gender, copyNode.birthday, copyNode.age, undoNode.favorite);
                return root;
            }
        }

        return null;
    }
     
     Node redo(){
         if(redo.isEmpty()){
             System.out.println("Nothing to redo!");
         }
         else{
            Node redoNode = redo.pop();
            System.out.println("RedoNode: " + redoNode);
            boolean res = SearchAnd(redoNode);
            if(res){            
                delete(Long.toString(redoNode.number), redoNode.name);
                return root;
            }
            else{
                Node copyNode = redo.pop();
                undo.push(copyNode);
                undo.push(redoNode);
                System.out.println("redo Delete: " + copyNode);
                System.out.println("redo Insert: " + redoNode);
                root = Delete(root, copyNode.number);
                root = Insert(root, redoNode.number, redoNode.name, redoNode.lastname, redoNode.email, redoNode.gender, redoNode.birthday, redoNode.age, redoNode.favorite);
                return root;
            }     
         }
        return root;
     }
     
     Node And(){
         
         String Input;
         System.out.println("Which info you gonna give me:"
                 + "\n1.Number"
                 + "\n2.Name"
                 + "\n3.Last Name"
                 + "\n4.Email"
                 + "\n5.Birthday"
                 + "\n6.Age"
                 + "\n7.Gender");
         int choise = input.nextInt();
         System.out.println("Enter the info:");
         Input = input.next();
         for(int i = 0; i < inorder.size(); i++){
            if(choise == 1){
            if(inorder.get(i).number == Long.parseLong(Input))
               result.add(inorder.get(i));}
            
            else if(choise == 2){
                if(inorder.get(i).name.equals(Input))
                result.add(inorder.get(i));}
            else if(choise == 3){
                if(inorder.get(i).lastname.equals(Input))
                result.add(inorder.get(i));}
            else if(choise == 4){
                if(inorder.get(i).email.equals(Input))
                result.add(inorder.get(i));}
            else if(choise == 5){
                if(inorder.get(i).birthday == Integer.parseInt(Input))
                result.add(inorder.get(i));}
            else if(choise == 6){
                if(inorder.get(i).age == Integer.parseInt(Input))
                result.add(inorder.get(i));}
            else if(choise == 7){
                if(inorder.get(i).gender.equals(Input))
                result.add(inorder.get(i));}
         }
        
        return root;
         
    }
     
     public Node OR(String []or){
        for(int i = 0; i < inorder.size(); i++){
            if(inorder.get(i).gender.equals(or[6]) || inorder.get(i).number == Long.parseLong(or[0]) || inorder.get(i).name.equals(or[1]) || inorder.get(i).lastname.equals(or[2]) || inorder.get(i).email.equals(or[3]) || inorder.get(i).birthday == Integer.parseInt(or[4]) || inorder.get(i).age == Integer.parseInt(or[5]))
                result.add(inorder.get(i));
        }
      return root;
}
    
     public Node SimilaritySearch(){
         String x = null;
         int y;
         System.out.println("Which info you gonna give me:"
                 + "\n1.Number"
                 + "\n2.Name"
                 + "\n3.Last Name"
                 + "\n4.Email"
                 + "\n5.Birthday"
                 + "\n6.Age"
                 + "\n7.Gender");
         y = input.nextInt();
         x = input.next();
         int xcounter = x.length();
         int ycounter;
         switch(y){
             case 1:
                 for(int i = 0; i < inorder.size(); i++){
                    String numberTostring = Long.toString(inorder.get(i).number);
                    String resNumber = numberTostring.substring(0, xcounter);
                    if(resNumber.equals(x))
                        result.add(inorder.get(i));
                 }
                 break;
                 
             case 2:
                 for(int j = 0; j < inorder.size(); j++){
                   String resName = inorder.get(j).name.substring(0,xcounter);
                   if(resName.equals(x))
                       result.add(inorder.get(j));
                    }
                 break;
             case 3:
                 for(int k = 0; k < inorder.size(); k++){
                   String resLastName = inorder.get(k).lastname.substring(0,xcounter);
                   if(resLastName.equals(x))
                       result.add(inorder.get(k));
                 }
                   break;
             case 4:
                 for(int l = 0; l < inorder.size(); l++){
                   String resEmail = inorder.get(l).email.substring(0,xcounter);
                   if(resEmail.equals(x))
                       result.add(inorder.get(l));
                 }
                   break;
             case 5:
                 for(int m = 0; m < inorder.size(); m++){
                    String birthdayTostring = Integer.toString(inorder.get(m).birthday);
                    String resBirthday = birthdayTostring.substring(0, xcounter);
                    if(resBirthday.equals(x))
                        result.add(inorder.get(m));
                 }
                 break;
             case 6:
                 for(int n = 0; n < inorder.size(); n++){
                    String ageTostring = Integer.toString(inorder.get(n).age);
                    String resAge = ageTostring.substring(0, xcounter);
                    if(resAge.equals(x))
                        result.add(inorder.get(n));
                 }
                 break;
             case 7:
                 for(int o = 0; o < inorder.size(); o++){
                   String resGender = inorder.get(o).gender.substring(0,xcounter);
                   if(resGender.equals(x))
                       result.add(inorder.get(o));
                 }
                   break;
                 
                 
                 
         }
         return root;
    }
   
    public Node edit (String ENumber , String Edit){
        Search(root, ENumber, Edit);
        Node changingNode;
        changingNode = select(result);

        undo.push(copy(changingNode));
        System.out.println("Copy: "+copy(changingNode));
        System.out.println("Orginal: "+changingNode);
        System.out.println("What u want to edit for "+changingNode.number+"? Please select an item.");
        System.out.println("1.Phone Number\n2.Name\n3.LastName\n4.Email\n5.Gender\n6.Birthdate\n7.Age");
        int n = input.nextInt();
        switch(n){
            case 1:
                System.out.print("Enter New Number: ");
                long newNumber = input.nextLong();
                changingNode.number = newNumber;
                undo.push(changingNode);
                result.clear();
                break;
            case 2:
                System.out.print("Enter New Name: ");

                String newName = input.next();
                changingNode.name = newName;
                undo.push(changingNode);
                result.clear();
                break;
            case 3:
                System.out.print("Enter New LastName: ");
                String newLastName = input.next();
                changingNode.lastname = newLastName;
                undo.push(changingNode);
                result.clear();
                break;
            case 4:
                System.out.print("Enter New Email: ");
                String newEmail = input.next();
                changingNode.email = newEmail;
                undo.push(changingNode);
                result.clear();
                break;
            case 5:
                System.out.print("Enter New Gender (Male or Femail): ");
                String newGender = input.next();
                changingNode.gender = newGender;
                undo.push(changingNode);
                result.clear();
                break;
            case 6:
                System.out.print("Enter New BirthDate: ");
                int newBirthdate = input.nextInt();
                changingNode.birthday = newBirthdate;
                undo.push(changingNode);
                result.clear();
                break;
            case 7:
                System.out.print("Enter New Age: ");
                int newAge = input.nextInt();
                changingNode.age = newAge;
                undo.push(changingNode);
                result.clear();
                break;
            default:
                System.out.print("Enter correct number: ");
        }
        result.clear();
        return null;
    }

    void inorder() {
        inorder.clear();
        Inorder(root);
        inorder = removeDuplicates(inorder);
    }
   public static <Node> ArrayList<Node> removeDuplicates(ArrayList<Node> list){ 
        ArrayList<Node> newList = new ArrayList<>(); 
        for (Node element : list) { 
            if (!newList.contains(element)) { 
                newList.add(element); 
            } 
        } 
        return newList; 
    } 
}
