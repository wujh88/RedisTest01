package com.findPhNum;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ImportFile {

	/**
     * ��ȡ�ļ������ļ��еĵ绰�����ȡ������������Set�С�
     * @param filePath    �ļ��ľ���·��
     * @return            �ļ��а����ĵ绰����
     */
    public static Set<String> getPhoneNumFromFile(String filePath)
    {
        Set<String> phoneSet = new HashSet<String>();
        
        try
        {
            String encoding = "UTF-8";
            File file = new File(filePath);
            if (file.isFile() && file.exists())
            { // �ж��ļ��Ƿ����
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);// ���ǵ������
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;

                while ((lineTxt = bufferedReader.readLine()) != null)
                {
                    //��ȡ�ļ��е�һ�У������еĵ绰������ӵ�phoneSet��
                    CheckIfIsPhoneNumber.getPhoneNumFromStrIntoSet(lineTxt, phoneSet);
                }
                read.close();
            }
            else
            {
                System.out.println("�Ҳ���ָ�����ļ�");
            }
        }
        catch (Exception e)
        {
            System.out.println("��ȡ�ļ����ݳ���");
            e.printStackTrace();
        }
        
        return phoneSet;
    }
    
    
    public static void main(String argv[])
    {
        String filePath = "E:\\three.txt";    
        
        Set<String> phoneSet = getPhoneNumFromFile(filePath);
        
        System.out.println("�绰���ϣ�" + phoneSet);
    }
}
