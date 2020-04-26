package com.fantasy.easy.sys;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fantasy on 2020/4/14.
 */
public class PackageScaner {

    private List<Class<?>> classes;
    private String packagePath = null;

    /*
    * 实现，调用fileScanner进行目录扫描和加载
    *
    * @param String 传入需要扫描的包
    *
    * @throw classNotFound
    */
    public void PackageScanner(String basePackage) throws ClassNotFoundException {
        packagePath = System.getProperty("user.dir") + "\\easy-core\\src\\main\\java\\";
        String filePath = packagePath + basePackage.replace(".", "\\");
        classes = new ArrayList<Class<?>>();
        fileScanner(new File(filePath));
    }

    private void fileScanner(File file) throws ClassNotFoundException {
        if (file.isFile() && file.getName().lastIndexOf(".java") == file.getName().length() - 5) {//5是".java"的长度
            String filePath = file.getAbsolutePath();
            String qualifiedName = filePath.substring(packagePath.length(), filePath.length() - 5).replace("\\", ".");
            System.out.println(qualifiedName);
            classes.add(Class.forName(qualifiedName));
            return;
        } else if (file.isDirectory()) {
            for (File f : file.listFiles())
                fileScanner(f);
        }
    }

    public static void main(String[] args){
        PackageScaner ps = new PackageScaner();
        try{
            ps.PackageScanner("com.fantasy");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
