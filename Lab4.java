/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;


/**
 *
 * @author maukhan.bscs13seecs
 */
public class Lab4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  throws Exception{
          //ArrayList<File> files = null;
         List<File> files = new ArrayList<File>();
         HashMap<String, List<String> > hmap = new HashMap<String, List<String> >();
          //File[] fileList = getFileList("C:\\Users\\maukhan.bscs13seecs\\Desktop\\ahmed", files);
          files = getFileList("C:\\Users\\maukhan.bscs13seecs\\Desktop\\ahmed", files,hmap);
            for(File file : files) {
                System.out.println(file.getName());
            }
            System.out.println(": ");
            String keyword="";
            JOptionPane.showInputDialog(keyword, "enter keyword to search: ");
            keySearch(keyword,hmap);
        }

        private static List<File> getFileList(String dirPath, List<File> files, HashMap<String,List<String>> hmap) throws FileNotFoundException, IOException {
            File dir = new File(dirPath);   
            File[] fileList=dir.listFiles();
            
        for (File file : fileList) {
            List<String> path = new ArrayList<String>();
        if (file.isFile()) {
            files.add(file);
            path.add(file.getAbsolutePath());
            hmap.put(file.getName(),path);
            
            // file reading for keywords
            
  /*          FileReader fileRead = new FileReader(file.getName());
            BufferedReader reader = new BufferedReader(fileRead);
            String text = "";
            String line = reader.readLine();*/
            Scanner sc2 = null;
    try {
        sc2 = new Scanner(new File(file.getName()));
         while (sc2.hasNextLine()) {
            Scanner s2 = new Scanner(sc2.nextLine());
        while (s2.hasNext()) {
            String s = s2.next();
           String[] str_array = s.split(" ");
            for (String si:str_array){
            List<String> path1 = new ArrayList<String>();
            path1.add(file.getAbsolutePath());
            hmap.put(si,path1);   
            }
        }
    }
    } catch (FileNotFoundException e) {
        e.printStackTrace();  
    }
   
            
            
        } else if (file.isDirectory()) {
            path.add(file.getAbsolutePath());
            hmap.put(file.getName(),path);
            getFileList(file.getAbsolutePath(), files,hmap);
        }
    }
/*       System.out.println("printing map\n");
    for (Entry<String,List<String>> e: hmap.entrySet()){
        System.out.println(e.getKey()+" "+e.getValue());
    }
       System.out.println("printing map end\n");
       //return fileList;
*/        return files;
        }
        
        public static void keySearch(String key,HashMap<String,List<String>> hmap)
        {
                //  System.out.println("printing map\n");
    for (Entry<String,List<String>> e: hmap.entrySet()){
        if (e.getKey()==key)
        {
            System.out.println("keyword found: ");
            System.out.println(e.getKey()+" "+e.getValue());
        }
        else
            System.out.println("keyword not found\n");
    }
       System.out.println("printing map end\n");
       //return fileList;

            
        }
    }
    
