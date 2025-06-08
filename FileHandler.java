import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;  
public class FileHandler {
    public FileHandler(){
        readAndWrite("e-commerce-samples.csv");
    }
    public FileHandler(String filepath){
        readAndWrite(filepath);
    }
    public void readAndWrite(String filepath){
        try {
            Scanner sc = new Scanner(new File(filepath));
            BufferedWriter p = new BufferedWriter(new FileWriter("Product.txt", true)); // product writer
            BufferedWriter t = new BufferedWriter(new FileWriter("Trader.txt", true)); //trader writer
            sc.useDelimiter(";");

            ArrayList<String> traderList = new ArrayList<>();

            String pId;
            String pName;
            String pCategory;
            String pPrice;
            String pDisPrice;
            String pDescription;
            String pTraderName;
            String buffer;

            int flag;

            for(int i=0; i<6; i++)  sc.next();  // skipping the first line

            pId = sc.next(); // product Id
            pId = pId.substring(8,pId.length());

            int i=1;
            while (sc.hasNext())
            {
                System.out.println(i);

                p.append(pId + '\n');

                pName = sc.next(); // product name
                p.append(pName + '\n');

                pCategory = sc.next();
                p.append(pCategory + '\n');

                pPrice = sc.next();
                p.append(pPrice + '\n');

                pDisPrice = sc.next();
                p.append(pDisPrice + '\n');

                pDescription = sc.next();
                p.append(pDescription + '\n');

                buffer = sc.next();

                pTraderName = "";
                pId = "";

                int j=0;
                if(buffer.contains("\n")){
                    while(buffer.charAt(j) != '\n'){
                        pTraderName += buffer.charAt(j);
                        j++;
                    }
                    j++;
                    while(j < buffer.length()){
                        pId += buffer.charAt(j);
                        j++;
                    }
                }

                p.append(pTraderName + '\n');

                if(!traderList.contains(pTraderName))    traderList.add(pTraderName);

                i++;

            }

            i=0;
            int ID = 10000000;
            String password = "111111";
            while(traderList.size() != 0){
                t.append(traderList.get(0) + '\n');
                t.append(String.valueOf(ID) + '\n');
                t.append(password + '\n');
                ID++;
                traderList.remove(0);
            }
            p.close();
            t.close();
            sc.close();
        }catch(Exception e){    System.out.println(e);}
    }
}
