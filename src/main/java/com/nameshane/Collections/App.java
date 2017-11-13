package com.nameshane.Collections;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.OrderedMap;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.collections.bidimap.TreeBidiMap;
import org.apache.commons.collections.list.PredicatedList;
import org.apache.commons.collections.map.LinkedMap;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.ChainedClosure;
import org.junit.Test;

import junit.framework.Assert;

public class App {
	public static void main(String[] args) {

	}

	@Test
	public void testCollections() {
		OrderedMap map = new LinkedMap();
		map.put("one", 1);
		map.put("two", 2);
		Assert.assertEquals("one", map.firstKey());
		Assert.assertEquals("two", map.nextKey("one"));

		BidiMap bidi = new TreeBidiMap();
		bidi.put("six", 6);
		Assert.assertEquals(6, bidi.get("six"));
		Assert.assertEquals("six", bidi.getKey(6));

		List<String> a = new ArrayList<>();
		List<String> b = new ArrayList<>();
		a.add("1");
		a.add("2");
		b.add("2");
		b.add("3");
		Collection<String> c = CollectionUtils.retainAll(a, b);
		System.out.println(c);// 2、

		// 自定义判断
		Predicate selfPre = new Predicate() {
			@Override
			public boolean evaluate(Object obj) {
				String object = (String) obj;
				return object.length() >= 5 && object.length() <= 20;

			}
		};
		Predicate notNull = PredicateUtils.notNullPredicate();
		Predicate all = PredicateUtils.andPredicate(notNull, selfPre);
		List<String> list = PredicatedList.decorate(new ArrayList<String>(), all);
		// list.add("a");//IllegalArgumentException
		list.add("aaaaaa");
		// list.add(null);
		System.out.println(list.toString());

		Predicate uniquePre = PredicateUtils.uniquePredicate();
		PredicateUtils.nullPredicate();
	}

	// https://www.cnblogs.com/Eddyer/p/6025356.html
	@Test
	public void format() {
		// 类型转换器
		Transformer<Long, String> trans = new Transformer<Long, String>() {

			@Override
			public String transform(Long input) {
				return new SimpleDateFormat("yyyy年MM月dd日").format(input);
			}
		};
		List<Long> list = new ArrayList<Long>();
		list.add(999999999999L);
		list.add(300000000L);

		Collection<String> result = CollectionUtils.collect(list, trans);
		System.out.println(result);
	}

	@Test
	public void chainClosure() {
		List<Goods> goodsList = new ArrayList<Goods>();
		goodsList.add(new Goods("javase视频", 120, true));
		goodsList.add(new Goods("javaee视频", 100, false));
		goodsList.add(new Goods("高新技术视频", 80, false));

		// 满百减20
		Closure<Goods> subtract = new Closure<Goods>() {

			@Override
			public void execute(Goods goods) {
				if (goods.getPrice() >= 100) {
					goods.setPrice(goods.getPrice() - 20);
				}
			}
		};
		// 打折
		Closure<Goods> discount = new Closure<Goods>() {
			public void execute(Goods goods) {
				if (goods.isDiscount()) {
					goods.setPrice(goods.getPrice() * 0.9);
				}
			}
		};
		// 链式操作
		Closure<Goods> chainClo = ChainedClosure.chainedClosure(discount, subtract);
		// 关联
		// CollectionUtils.forAllDo(goodsList,chainClo);
		IterableUtils.forEach(goodsList, chainClo);
		System.out.println(goodsList);

		// false 表示 while结构 先判断后执行 true do..while 先执行后判断
		// Closure<Employee> whileCols =WhileClosure.whileClosure(empPre, cols, false);

		// IfClosure.ifClosure(pre, discount,subtract);

	}

	@Test
	public void testTwo() {
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(1);
		set1.add(2);
		set1.add(3);

		Set<Integer> set2 = new HashSet<Integer>();
		set2.add(2);
		set2.add(3);
		set2.add(4);

		// 并集
		System.out.println("=========并集============");
		Collection<Integer> col = CollectionUtils.union(set1, set2);
		for (Integer temp : col) {
			System.out.println(temp);
		}
		// 交集
		System.out.println("=========交集============");
		// col =CollectionUtils.intersection(set1, set2);
		col = CollectionUtils.retainAll(set1, set2);
		for (Integer temp : col) {
			System.out.println(temp);
		}
		// 差集
		System.out.println("=========差集============");
		col = CollectionUtils.subtract(set1, set2);
		for (Integer temp : col) {
			System.out.println(temp);
		}

	}

}
