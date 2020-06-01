package codes.nttuan.File;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Main {
    private static void printFile(int cal, String name){
        for(int i=0; i< cal; i++){
            System.out.printf("\t");
        }
        System.out.println(name);
    }
    public static void getListFile(File file, int cal){
        printFile(cal, file.getName());
        if(file.isDirectory()){
            for(File f: file.listFiles()){
                if(f.isDirectory())
                    getListFile(f, cal+1);
                else
                    printFile(cal, f.getName());
            }
        }
    }
    public static String getFileExtension(String fileName) {
        String extension = "";
        int i = fileName.lastIndexOf('.');
        if (i >= 0) { extension = fileName.substring(i+1); }
        return extension;
    }
    public static boolean deleteDir(File dir){
        File[] files = dir.listFiles();
        if(files != null){
            for(File file : files){
                if(file.isDirectory()){
                    deleteDir(file);
                } else {
                    file.delete();
                }
            }
        }
        return dir.delete();
    }
    public static void main(String[] args) {
//        File file = new File(System.getProperty("user.dir"));
//        for(File f : file.listFiles()){
//            if(f.getName().contains("script")){
//                deleteDir(f);
//            }
//            if(f.isDirectory()){
//                File scr = new File(f.getPath() + "/script");
//                scr.mkdir();
//                for(File _f : f.listFiles()){
//                    if(getFileExtension(_f.getName()).equals("srt")){
//                        _f.renameTo(new File(scr.getPath() + "\\" +  _f.getName()));
//
//                    }
//                }
//            }
//        }
        // Result is /home/joe
        try {
            Files.copy(Paths.get("usnumbers.txt"), Paths.get("data/xanadu.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
