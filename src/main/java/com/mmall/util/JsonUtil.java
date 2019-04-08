package com.mmall.util;

import com.google.common.collect.Lists;
import com.mmall.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;


import java.text.SimpleDateFormat;
import java.util.List;

@Slf4j
public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

        static {
            //对象的全部字段列入
            objectMapper.setSerializationInclusion(Inclusion.ALWAYS);

            //取消默认的转换timestamps形式
            objectMapper.configure(SerializationConfig.Feature.WRITE_DATE_KEYS_AS_TIMESTAMPS,false);

            //忽略空bean转json的错误
            objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS,false);

            //统一date的格式为一下样式:"yyyy-MM-dd HH:mm:ss"
            objectMapper.setDateFormat(new SimpleDateFormat(DateTimeUtil.STANDARD_FORMAT));

            //忽略在json字符串中存在，但在java对象中不存在对应属性的情况，防止错误
            objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        }

        public static <T> String objToString(T obj){
            if(obj == null){
                return null;
            }
            try {
                return obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
            } catch (Exception e) {
                log.warn("Parse object to String error",e);
                return null;
            }
        }

        public static <T> String objToStringPretty(T obj){
            if(obj == null){
                return null;
            }
            try {
                return obj instanceof String ? (String) obj : objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            } catch (Exception e) {
                log.warn("Parse object to String error",e);
            return null;
        }
        }

        public static <T> T stringToObj(String str,Class<T> clazz){
            if(StringUtils.isEmpty(str) || clazz == null){
                return null;
            }
            try {
                return clazz.equals(String.class)? (T) str : objectMapper.readValue(str,clazz);
            } catch (Exception e) {
                log.warn("Parse String to Object to String error",e);
                return null;
            }
        }

    public static <T> T stringToObj(String str, TypeReference<T> typeReference){
        if(StringUtils.isEmpty(str) || typeReference == null){
            return null;
        }
        try {
            return (T)(typeReference.getType().equals(String.class)? str : objectMapper.readValue(str,typeReference));
        } catch (Exception e) {
            log.warn("Parse String to Object error",e);
            return null;
        }
    }

    public static <T> T stringToObj(String str,Class<?> collectionClass,Class<?>... elementClasses){
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(collectionClass,elementClasses);
        try {
            return objectMapper.readValue(str,javaType);
        } catch (Exception e) {
            log.warn("Parse String to Object error",e);
            return null;
        }
    }

//    public static void main(String[] args) {
//        User user1 = new User();
//        User user2 = new User();
//        user1.setId(1);
//        user1.setEmail("48944646@qq.com");
//        user2.setId(2);
//        user2.setEmail("489f44646@qq.com");
//
//        List<User> userList = Lists.newArrayList();
//        userList.add(user1);
//        userList.add(user2);
//
//        String userListstr = JsonUtil.objToStringPretty(userList);
//
//
//        String user1Json = JsonUtil.objToString(user1);
//        String user1JsonPretty = JsonUtil.objToStringPretty(user1);
//        List<User> userListst = JsonUtil.stringToObj(userListstr,new TypeReference<List<User>>(){ });
//
//        List<User> userList2 = JsonUtil.stringToObj(userListstr,List.class,User.class);
//
//
//
//        log.info("user1Json:{}",user1Json);
//        log.info("user1JsonPretty:{}",user1JsonPretty);
//
//
//
//       System.out.println("d");
//
//
//
//
//    }

}
