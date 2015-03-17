import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class FilePractice
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner in = new Scanner(System.in);
        System.out.println("u kno it");
        String name = in.next();
        
        File file = new File(name);
        Scanner sweg = new Scanner(file);
        
        sweg.useDelimiter("hail satan 666");//lets be real here
        
        String all = sweg.next();
        int numChar = all.length();
        
        Scanner swag = new Scanner(all);
        
        swag.useDelimiter("[^A-Za-z]+");
        int numWords = -1;
        while(swag.hasNext())
        {
            numWords++;
            swag.next();
        }
        
        
        Scanner dillon = new Scanner(all);
        dillon.useDelimiter("\n");
        int numLines = 1;
        while(dillon.hasNext())
        {
            numWords++;
            dillon.next();
        }
        
        System.out.println("chars:" +numChar);
        System.out.println("words:" + numWords);
        System.out.println("lines:"+numLines);
        
       
    }
}
