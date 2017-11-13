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
		p.setName("test");
		p.setAge(2);
		String name = (String) PropertyUtils.getSimpleProperty(p, "name");
		Assert.assertEquals("test", name);
	}

}