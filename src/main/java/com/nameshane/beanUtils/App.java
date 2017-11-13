package com.nameshane.beanUtils;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;

import junit.framework.Assert;

public class App {

	public static void main(String[] args) {

	}
	

	@Test
	public void testProperties() throws Exception {
		Persion p = new Persion();
		Address ad = new Address();
		ad.setCity("st");
		p.setName("test");
		p.setAge(2);
		p.setAddress(ad);
		String name = (String) PropertyUtils.getSimpleProperty(p, "name");
		PropertyUtils.getMappedProperty(p, "address(city)");
		Assert.assertEquals("test", name);
	}

}