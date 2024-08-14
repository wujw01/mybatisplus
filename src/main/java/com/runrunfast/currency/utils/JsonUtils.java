package com.runrunfast.currency.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * @Description: 自定义响应结构, 转换类
 */
public class JsonUtils {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /*** \_____________________________/
     * <p>@author       |   James</p>
     * <p>@param        |   data  </p>
     * <p>@return       |   java.lang.String</P>
     * <p>@date         |   2018/11/22 9:51</P>
     * <p>@description  |   将对象转换成json字符串。</p>
     ***/
    public static String objectToJson(Object data) {
    	try {
			String string = MAPPER.writeValueAsString(data);
			return string;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    /*** \_____________________________/
     * <p>@author       |   James</p>
     * <p>@param        |   jsonData  </p>
     * <p>@param        |   beanType  </p>
     * <p>@return       |   T</P>
     * <p>@date         |   2018/11/22 9:52</P>
     * <p>@description  |   将json结果集转化为对象</p>
     ***/
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
    
    /*** \_____________________________/
     * <p>@author       |   James</p>
     * <p>@param        |   jsonData  </p>
     * <p>@param        |   beanType  </p>
     * <p>@return       |   java.util.List<T></P>
     * <p>@date         |   2018/11/22 9:52</P>
     * <p>@description  |   将json数据转换成pojo对象list</p>
     ***/
    public static <T>List<T> jsonToList(String jsonData, Class<T> beanType) {
    	JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
    	try {
    		List<T> list = MAPPER.readValue(jsonData, javaType);
    		return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
    
}
