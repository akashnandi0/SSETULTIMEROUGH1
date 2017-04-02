package com.a2j.ssetultimerough;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseJSON {
    public static String[] BOOKNAME;
    public static String[] AUTHOR;
    public static String[] STOCK;


    public static final String JSON_ARRAY = "result";
    public static final String KEY_BOOKNAME = "BOOKNAME";
    public static final String KEY_AUTHOR = "AUTHOR";
    public static final String KEY_STOCK = "STOCK";



    private JSONArray users = null;

    private String json;

    public ParseJSON(String json){
        this.json = json;
    }

    protected void parseJSON(){
        JSONObject jsonObject=null;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);

            BOOKNAME = new String[users.length()];
            AUTHOR = new String[users.length()];
            STOCK = new String[users.length()];


            for(int i=0;i<users.length();i++){
                JSONObject jo = users.getJSONObject(i);
                BOOKNAME[i] = jo.getString(KEY_BOOKNAME);
                AUTHOR[i] = jo.getString(KEY_AUTHOR);
                STOCK[i] = jo.getString(KEY_STOCK);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
