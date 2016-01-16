package com.util.json;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;


public class JSONFormat {


    private String src;
    private int TABLength = 0;

    private final String BRACKET_LEFT = "[";
    private final String BRACKET_RIGHT = "]";
    private final String BRACE_LEFT = "{";
    private final String BRACE_RIGHT = "}";
    private final String COMMA = ",";
    private final String LINE_BREAK = "\n";
    private final String TAB = "\t";


    public JSONFormat(String src){
        this.src = src;
    }

    public String format() throws JSONException{
        try{
            JSONObject json = JSONObject.parseObject(src);
        }catch (JSONException e){
            //��json���м򵥵�У�飬��������ϸ�ʽ��ôjsonobject�ڽ�����ʱ��ᱨ��
            throw e;
        }
        return format(src);
    }

    private String format(String src) {
        StringBuffer result = new StringBuffer();
        char[] srcArray = src.toCharArray();
        for (int index = 0; index < src.length(); index++) {
            result.append(srcArray[index]);

            if (BRACE_LEFT.equals(String.valueOf(srcArray[index])))  //{
                result.append(appendLINE_BREAKAndTAB(++TABLength));

            if (BRACE_RIGHT.equals(String.valueOf(srcArray[index]))) //}
                result.insert(result.length() - 1, appendLINE_BREAKAndTAB(--TABLength));

            if (BRACKET_LEFT.equals(String.valueOf(srcArray[index])))    //[
                result.append(appendLINE_BREAKAndTAB(++TABLength));

            if (BRACKET_RIGHT.equals(String.valueOf(srcArray[index])))   //]
                result.insert(result.length() - 1, appendLINE_BREAKAndTAB(--TABLength));

            if (COMMA.equals(String.valueOf(srcArray[index])))   //,
                result.append(appendLINE_BREAKAndTAB(TABLength));
        }
        return result.toString();
    }

    //׷�ӻ��з���   ȷ�����ȵ��Ʊ��
    private String appendLINE_BREAKAndTAB(int TABTimes) {
        StringBuffer temp = new StringBuffer();
        temp.append(appendLINE_BREAK());
        temp.append(appendTAB(TABTimes));
        return temp.toString();
    }

    private String appendLINE_BREAK() {
        return LINE_BREAK;
    }

    private String appendTAB(int TABTimes) {
        StringBuffer temp = new StringBuffer();
        for (int i = 0; i < TABTimes; i++) {
            temp.append(TAB);
        }
        return temp.toString();
    }

    public static void main(String[] args) {
        String toFormat = "{\"status\": \"3\",\"message\": \"\",\"errCode\": \"0\",\"data\": [{\"time\": \"2013-02-26 16:47\",\"context\": \"�ͻ� ͬ���շ����� ��ǩ�� �ɼ�Ա ��xx\"},{\"time\": \"2013-02-26 07:33\",\"context\": \"����ʡxx��xx��˾ ���ɼ�Ա �Ž�� �ɼ��� �ɼ�Ա�绰15xxx73xx87\"},{\"time\": \"2013-02-26 06:02\",\"context\": \"xxʡxx��xx��˾ ������\"},{\"time\": \"2013-02-25 15:42\",\"context\": \"xxʡxxת�����Ĺ�˾�ѷ���\"},{\"time\":\"2013-02-25 14:59\",\"context\":\"xxʡxxת�����Ĺ�˾�Ѳ��\"},{\"time\": \"2013-02-24 18:11\",\"context\":\"����ʡ��������ɽ���Ĳ���˾ ���ռ�\"},{\"time\": \"2013-02-24 17:59\",\"context\":\"����ʡ�����й�˾ ������\"},{\"time\":\"2013-02-23 17:10\",\"context\":\"����ʡ��������ɽ��xxxx��˾ ���ռ�Ա ��xx ���ռ�\" }],\"html\":\"\",\"mailNo\":\"71xxxxx624\",\"expTextName\":\"Բͨ���\",\"expSpellName\":\"yuantong\",\"update\":\"1375155719\",\"cache\":\"33196560\",\"ord\":\"DESC\"}";
        JSONFormat jsonFormat = new JSONFormat(toFormat);
        System.out.println(jsonFormat.format());
    }

}
