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
            //对json进行简单的校验，如果不符合格式那么jsonobject在解析的时候会报错
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

    //追加换行符和   确定长度的制表符
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
        String toFormat = "{\"status\": \"3\",\"message\": \"\",\"errCode\": \"0\",\"data\": [{\"time\": \"2013-02-26 16:47\",\"context\": \"客户 同事收发家人 已签收 派件员 张xx\"},{\"time\": \"2013-02-26 07:33\",\"context\": \"吉林省xx市xx公司 的派件员 张金达 派件中 派件员电话15xxx73xx87\"},{\"time\": \"2013-02-26 06:02\",\"context\": \"xx省xx市xx公司 已收入\"},{\"time\": \"2013-02-25 15:42\",\"context\": \"xx省xx转运中心公司已发出\"},{\"time\":\"2013-02-25 14:59\",\"context\":\"xx省xx转运中心公司已拆包\"},{\"time\": \"2013-02-24 18:11\",\"context\":\"辽宁省大连市中山区四部公司 已收件\"},{\"time\": \"2013-02-24 17:59\",\"context\":\"辽宁省大连市公司 已收入\"},{\"time\":\"2013-02-23 17:10\",\"context\":\"辽宁省大连市中山区xxxx公司 的收件员 王xx 已收件\" }],\"html\":\"\",\"mailNo\":\"71xxxxx624\",\"expTextName\":\"圆通快递\",\"expSpellName\":\"yuantong\",\"update\":\"1375155719\",\"cache\":\"33196560\",\"ord\":\"DESC\"}";
        JSONFormat jsonFormat = new JSONFormat(toFormat);
        System.out.println(jsonFormat.format());
    }

}
