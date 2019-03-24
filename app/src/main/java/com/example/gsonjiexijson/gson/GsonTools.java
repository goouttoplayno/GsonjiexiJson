package com.example.gsonjiexijson.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class GsonTools {
    public GsonTools(){

    }
    public static <T>T getPerson(String jsonString, Class<T> cls){
        T t = null;
        try {
            Gson gson = new Gson();
            t = gson.fromJson(jsonString, cls);
        }catch (Exception e){

        }
        return t;
    }

    public static <T>List<T> getPersons(String jsonString, Class<T> cls){
        List<T> list = new ArrayList<T>();
        try {
            Gson gson = new Gson();
            list = gson.fromJson(jsonString, new TypeToken<List<T>>(){}.getType());
        }catch (Exception e){

        }
        return list;
    }
}
