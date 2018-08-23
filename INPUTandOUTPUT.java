import java.io.*;
import java.util.Arrays;

public class INPUTandOUTPUT {

    public static void main(String[] args) {
        int count = 0;
        int tmp = 0;
        int tmp1 = 0;

        
        try(FileReader reader = new FileReader("INPUT.txt"))
        {
            char[] buf = new char[100];
            int c;
            
            while((c = reader.read(buf))>0){
                if(c < 100){
                    buf = Arrays.copyOf(buf, c);
                }
           }
            
            for (int i = 0; i < buf.length; i++ ) {
            	if (buf[i]=='1') {
            		count++;
            	}
            	
            	else if ((i!=0 && buf[i]=='0' && buf[i-1]=='1')) {
            		tmp = count;
                	if (tmp1<tmp) {
                		tmp1 =tmp;
                	}

            		count = 0;
            	}
            	
            	if (i==buf.length-1 && tmp1<count) {
            		tmp1 = count;
            	}
            }
        }
        
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        try(FileWriter writer = new FileWriter("OUTPUT.txt", false))
        {
            String str = Integer.toString(tmp1);
            writer.write(str); 
            writer.flush();
        }
        catch(IOException ex){ 
            System.out.println(ex.getMessage());
        } 
 
    }
        
}


