package com.findPhNum;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckIfIsPhoneNumber {

	 /**
     * ��õ绰�����������ʽ�������̶��绰���ƶ��绰
     * ���Ϲ���ĺ��룺
     *     1�����ƶ��绰
     *         86+��-��+11λ�绰����
     *         86+11λ�����ĵ绰����
     *         11λ�����绰����a
     *         (+86) + 11λ�绰����
     *         (86) + 11λ�绰����
     *     2�����̶��绰
     *         ���� + ��-�� + �̶��绰  + ��-�� + �ֻ���
     *         ���� + ��-�� + �̶��绰 
     *         ���� + �̶��绰
     * @return    �绰�����������ʽ
     */
    public static String isPhoneRegexp()
    {
        String regexp = "";
        
        //�������ƥ�䣬���޷���ɹ�������ź͵绰����֮���пո�����
        String mobilePhoneRegexp = "(?:(\\(\\+?86\\))((13[0-9]{1})|(15[0-9]{1})|(18[0,5-9]{1}))+\\d{8})|" +     
                "(?:86-?((13[0-9]{1})|(15[0-9]{1})|(18[0,5-9]{1}))+\\d{8})|" +
                "(?:((13[0-9]{1})|(15[0-9]{1})|(18[0,5-9]{1}))+\\d{8})";
        
        
        
        //    System.out.println("regexp = " + mobilePhoneRegexp);
        //�̶��绰������ʽ
        
        String landlinePhoneRegexp = "(?:(\\(\\+?86\\))(0[0-9]{2,3}\\-?)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?)|" +
                "(?:(86-?)?(0[0-9]{2,3}\\-?)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?)";    

        regexp += "(?:" + mobilePhoneRegexp + "|" + landlinePhoneRegexp +")"; 
    
        return regexp;
    }
    
    
    /**
     * ��dataStr�л�ȡ�����еĵ绰���루�̻����ƶ��绰�����������Set
     * @param dataStr    �����ҵ��ַ���
     * @param phoneSet    dataStr�еĵ绰����
     */
    public static void getPhoneNumFromStrIntoSet(String dataStr,Set<String> phoneSet)
    {
        //��ù̶��绰���ƶ��绰��������ʽ
        String regexp = isPhoneRegexp();
        
        System.out.println("Regexp = " + regexp);
        
        Pattern pattern = Pattern.compile(regexp); 
        Matcher matcher = pattern.matcher(dataStr); 

        //�����ģʽƥ����������е���һ��������
        while (matcher.find()) 
        { 
            //��ȡ��֮ǰ���ҵ����ַ����������������set��
            phoneSet.add(matcher.group());
        } 
        //System.out.println(phoneSet);
    }
    
}
