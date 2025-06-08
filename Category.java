import java.util.LinkedList;

public class Category {
    private LinkedList<String> categoryList;  

    public Category(){
        categoryList = new LinkedList<>();
    }

    public boolean addCategoryStep(String child){
        categoryList.add(child);
        return true;
    }
}
