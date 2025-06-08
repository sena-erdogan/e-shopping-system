import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public interface IUserService {
    public int getID();
    public String getPassword();
    public boolean changePassword(String password);
    public boolean logIn(int ID, String password);
    public boolean signUp(String password);
}
