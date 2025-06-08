import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserService { 
    private int ID;
    private String password;
    private String name;

    public UserService(){

    }
    public UserService(int ID) {
        Scanner t = null;
        String buffer;
        try{
            t = new Scanner(new File("Trader.txt"));
        }catch (FileNotFoundException e) { System.out.println(e);}
        while(t.hasNextLine()){
            buffer = t.nextLine();
            if(t.nextLine().equals(String.valueOf(ID))){
                name = buffer;
                password = t.nextLine();
                break;
            }
        }

        ID++;

        t.close();
    }

    public UserService(String name, String password) {
        this.name = name;
        if(password.length() != 6)  throw new IllegalStateException("Your password needs to have 6 characters");
        else    this.password = password;
        setID();

        System.out.println("Your ID is " + ID);
        System.out.println("Your password is " + password);
    }

    public int getID() {
        return ID;
    }

    public String getName(){
        return name;
    }

    private void setID(){
        Scanner t = null;
        try{
            t = new Scanner(new File("Trader.txt"));
        }catch (FileNotFoundException e) { System.out.println(e);}
        while(t.hasNextLine()){
            t.nextLine();
            ID = Integer.valueOf(t.nextLine());
            t.nextLine();
        }

        ID++;

        t.close();
    }

    public String getPassword() {
        return password;
    }

    public boolean changePassword(String password){
        if(password.length() != 6)  throw new IllegalStateException();
        else{
            this.password = password;
            return true;
        }
    }

    public boolean logIn(int ID, String password){
        if(this.ID == ID && this.password == password)  return true;
        else    throw new IllegalStateException();
    }

    public boolean signUp(String password){
        return changePassword(password);
    }
}
