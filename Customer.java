public class Customer {
    private UserService userService = new UserService(); 

    public Customer(){
        userService = new UserService();
    }

    public Customer(int ID){
        userService = new UserService(ID);
    }

    public Customer(String name, String password){
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
}
