package com.findPhNum;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ImportFile {

	/**
     * 读取文件，将文件中的电话号码读取出来，保存在Set中。
     * @param filePath    文件的绝对路径
     * @return            文件中包含的电话号码
     */
    public static Set<String> getPhoneNumFromFile(String filePath)
    {
        Set<String> phoneSet = new HashSet<String>();
        
        try
        {
            String encoding = "UTF-8";
            File file = new File(filePath);
            if (file.isFile() && file.exists())
            { // 判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);// 考虑到编码格
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;

                while ((lineTxt = bufferedReader.readLine()) != null)
                {
                    //读取文件中的一行，将其中的电话号码添加到phoneSet中
                    CheckIfIsPhoneNumber.getPhoneNumFromStrIntoSet(lineTxt, phoneSet);
                }
                read.close();
            }
            else
            {
                System.out.println("找不到指定的文件");
            }
        }
        catch (Exception e)
        {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        
        return phoneSet;
    }
    
    
    public static void main(String argv[])
    {
        String filePath = "E:\\three.txt";    
        
        Set<String> phoneSet = getPhoneNumFromFile(filePath);
        
        System.out.println("电话集合：" + phoneSet);
    }
}
