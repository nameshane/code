package com.nameshane.beanUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;

public class App {

	public static void main(String[] args) {

	}

	@Test
	public void testProperties() throws Exception {
		 Persion person = new Persion();  
	        try {  
	            //simple property  
	            PropertyUtils.setSimpleProperty(person, "username", "李四");  
	            PropertyUtils.setSimpleProperty(person, "age", 22);  
	            PropertyUtils.setSimpleProperty(person, "stature", 173.5f);  
	            PropertyUtils.setSimpleProperty(person, "sex", new Boolean(false));  
	              
	            //index property  
	            //List  
	            List list = new ArrayList();  
	            list.add("list value 0");  
	            list.add("list value 1");  
	            String listValue2 = "new list value 1";  
	            PropertyUtils.setSimpleProperty(person, "list", list);  
	            //将list设置到person之后，可以对里面的值进行修改  
	            PropertyUtils.setIndexedProperty(person, "list[1]", listValue2);  
	  
	            //数组  
	            String[] str = {"张三", "王五", "赵钱"};  
	            person.setFriendsNames(str);  
	            PropertyUtils.setIndexedProperty(person, "friendsNames[2]", "new赵钱");  
	              
	            //Map  
	            Map<String, String> map = new HashMap<String, String>();  
	            map.put("key1", "vlaue1");  
	            map.put("key2", "vlaue2");  
	            map.put("key3", "vlaue3");  
	            person.setMaps(map);  
	            PropertyUtils.setMappedProperty(person, "maps", "key1", "new value1");  
	            PropertyUtils.setMappedProperty(person, "maps(key2)", "maps(key2) value");  
	              
	            //nest property  
	            Address address = new Address();  
	            address.setEmail("jhlishero@163.com");  
	            List<String> telephoneList = new ArrayList<String>();  
	            telephoneList.add("12345678911");  
	            telephoneList.add("92345678911");  
	            address.setTelephone(telephoneList);  
	            person.setAddress(address);  
	            PropertyUtils.setNestedProperty(person, "address.telephone[1]", "nest 11111111");  
	            PropertyUtils.setNestedProperty(person, "address.email", "new_jhlishero@163.com");  
	            PropertyUtils.setNestedProperty(person, "address.city", "city");  
	              
	            System.out.println(PropertyUtils.getSimpleProperty(person, "username"));  
	            System.out.println(PropertyUtils.getSimpleProperty(person, "age"));  
	            System.out.println(PropertyUtils.getSimpleProperty(person, "stature"));  
	            System.out.println(PropertyUtils.getSimpleProperty(person, "sex"));  
	            System.out.println(PropertyUtils.getSimpleProperty(person, "list"));  
	            //list  
	            System.err.println(PropertyUtils.getIndexedProperty(person, "list[0]"));  
	            System.err.println(PropertyUtils.getIndexedProperty(person, "list", 1));  
	            //数组  
	            System.out.println(PropertyUtils.getIndexedProperty(person, "friendsNames[0]"));  
	            System.out.println(PropertyUtils.getIndexedProperty(person, "friendsNames", 1));  
	            System.out.println(PropertyUtils.getIndexedProperty(person, "friendsNames[2]"));  
	              
	            //Map  
	            System.err.println(PropertyUtils.getMappedProperty(person, "maps(key1)"));  
	            System.err.println(PropertyUtils.getMappedProperty(person, "maps", "key2"));  
	            System.err.println(PropertyUtils.getMappedProperty(person, "maps(key3)"));  
	              
	            //nest--嵌套输出   
	            System.out.println(PropertyUtils.getNestedProperty(person, "address.email"));  
	            System.out.println(PropertyUtils.getNestedProperty(person, "address.city"));  
	            System.out.println(PropertyUtils.getNestedProperty(person, "address.telephone[0]"));  
	            System.out.println(PropertyUtils.getNestedProperty(person, "address.telephone[1]"));  
	              
	            //也可以使用如下方法获取值  
	            System.out.println(PropertyUtils.getProperty(person, "address.telephone[1]"));  
	        } catch (Exception e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
	}

}