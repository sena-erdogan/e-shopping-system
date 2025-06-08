import java.io.*;
import java.util.Scanner; 

public class Trader {
    private UserService userService;

    public Trader(){
        userService = new UserService();
    }

    public Trader(int ID){
        userService = new UserService(ID);
    }

    public Trader(String name, String password){
        userService = new UserService(name, password);
    }

    public void changePassword(String password){
        userService.changePassword(password);
    }

    public boolean logIn(int ID, String password){
        return userService.logIn(ID, password);
    }

    public String getPassword(){
        return userService.getPassword();
    }

    public boolean signUp(String password){
        return userService.signUp(password);
    }

    public String getName() {   return userService.getName();}

    public boolean removeProduct(String target){
        try {
            Scanner ps = new Scanner(new File("Product.txt"));
            BufferedWriter pw = new BufferedWriter(new FileWriter("newProduct.txt", true));

            String buffer;

            while(ps.hasNextLine()){
                buffer = ps.nextLine();
                if(!buffer.equals(target)){
                    pw.append(buffer + '\n');
                    pw.append(ps.nextLine());
                    pw.append(ps.nextLine());
                    pw.append(ps.nextLine());
                    pw.append(ps.nextLine());
                    pw.append(ps.nextLine());
                    pw.append(ps.nextLine());
                }else{
                    ps.nextLine();
                    ps.nextLine();
                    ps.nextLine();
                    ps.nextLine();
                    ps.nextLine();
                    ps.nextLine();
                }

            }

            ps.close();
            pw.close();

            File r = new File("Product.txt");
            r.delete();

            File w = new File("newProduct.txt");
            File t = new File("Product.txt");
            w.renameTo(t);

            return true;
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }

    }
}
