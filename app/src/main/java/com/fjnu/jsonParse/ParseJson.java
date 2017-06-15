package com.fjnu.jsonParse;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import bean.ChatBean;
import bean.ItemBean;
import bean.WeatherBean;

/**
 * Created by Administrator on 2016/10/22.
 */

public class ParseJson {


//    {
//        "semantic": {
//        "slots": {
//            "name": "张三"
//        }
//    },
//        "rc": 0,
//            "operation": "CALL",
//            "service": "telephone",
//            "text": "打电话给张三。"
//    }

    public static ItemBean parseJsonApp(String content) {
        JSONObject object = null;
        try {
            object = new JSONObject(content);
            JSONObject semantic = object.getJSONObject("semantic");
            JSONObject  slots= semantic.getJSONObject("slots");
            ItemBean bean = new ItemBean();
            String answer = slots.getString("name");
            bean.setContent(answer);
            return bean;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }



    public static ItemBean parseJsonChat(String content) {
        JSONObject object = null;
        try {
            object = new JSONObject(content);
            JSONObject answers = object.getJSONObject("answer");
           ItemBean bean = new ItemBean();
            String answer = answers.getString("text");
            bean.setContent(answer);
            return bean;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static List<WeatherBean> parseJsonWeather(String content){
        List<WeatherBean>list=new ArrayList<>();
        try {
            JSONObject object=new JSONObject(content);
            JSONObject data=object.getJSONObject("data");
            JSONArray dataArr=data.getJSONArray("result");
            for (int i = 0; i <dataArr.length() ; i++) {
                JSONObject wether=  dataArr.getJSONObject(i);
                WeatherBean bean=new WeatherBean();
                bean.setCity(wether.getString("city"));
                bean.setDate(wether.getString("date"));
                bean.setTempRange(wether.getString("tempRange"));
                bean.setWeather(wether.getString("weather"));
                bean.setWind(wether.getString("wind"));
                list.add(bean);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }


}
