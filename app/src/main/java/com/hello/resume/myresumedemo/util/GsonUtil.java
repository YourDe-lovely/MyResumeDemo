//package com.hello.resume.myresumedemo.util;
//
//import com.google.gson.ExclusionStrategy;
//import com.google.gson.FieldAttributes;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//
//public class GsonUtil {
//
//    private static Gson gson ;
//
//    public static Gson getGson(){
//        if(gson == null){
//            // android 6.0   can't make field constructor accessible
//            GsonBuilder builder = new GsonBuilder();
//            ExclusionStrategy exclusionStrategy = new ExclusionStrategy() {
//
//                @Override
//                public boolean shouldSkipField(FieldAttributes fieldAttributes) {
//                    return false;
//                }
//
//                @Override
//                public boolean shouldSkipClass(Class<?> clazz) {
//                    return clazz == Field.class || clazz == Method.class;
//                }
//            };
//
//            //只有标注注解的属性才会生效
////            builder.excludeFieldsWithoutExposeAnnotation();
////            builder.excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC);
////            gson = builder.create();
//
//            gson = new GsonBuilder()
//                    .setDateFormat("yyyy-MM-dd HH:mm:ss")
//                    .addSerializationExclusionStrategy(exclusionStrategy)
//                    .addDeserializationExclusionStrategy(exclusionStrategy)
//                    .create();
//        }
//        return gson ;
//    }
//}
