
import java.io.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class FileTransformation {
    public static Map<String , String> readFile(String filePath){
        FileReader file = null;
        Map<String, String> map = new HashMap();
        String line;
        try {
            file = new FileReader(filePath);
            BufferedReader br =new BufferedReader(file);
            while ((line=br.readLine())!=null){
                String[] words = line.split("\\s");
                for (int i=0;i<words.length;i++) {
                    int count=0;
                    for (int j=0; j<=words.length-1; j++){
                        if(words[i].equals(words[j]) && !words[j].equals("0")){
                            count++;
                            String word =words[i].replaceAll("[,.$]","");
                            word = word.toLowerCase(Locale.ROOT);
                            if(!map.containsKey(word)){
                                map.put(word,String.valueOf(count));
                            }else if(map.containsKey(word)){
                                int count1 = Integer.parseInt(map.get(word));
                                count1++;
                                map.replace(word,String.valueOf(count1));
                            }
                            words[j]="0";
                        }
                    }
                }
                map.remove("");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        TreeMap<String,String> tm=new  TreeMap<String,String> (map);
        return tm;
    }
    public static void main(String[] args) {
       Map<String,String> output = FileTransformation.readFile("src/main/java/inputfile");
        System.out.println("\nMap List: "+output);
    }
}
