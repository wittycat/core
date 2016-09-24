package com.chenxun.guawa.collect;

import java.util.Set;

import org.junit.Test;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

public class MultiCollect {
	/**
	 * Multimap<K, V>不是Map<K,Collection<V>>，虽然某些Multimap实现中可能使用了map。
	 * 它们之间的显著区别包括：Multimap.get(key)总是返回非null、但是可能空的集合。
	 */
	@Test
	public  void multimap() {
		Multimap<String, Long> multimap = LinkedHashMultimap.create();
		multimap.put("1", 1L);
		multimap.put("1", 2L);
		multimap.put("1", 3L);
		multimap.put("1", 4L);
		multimap.put("2", 5L);
		Set<String> keySet = multimap.keySet();
		for (String key : keySet) {
			System.out.println(multimap.get(key));;
//			[1, 2, 3, 4]
//			[5]
		}
	}
}
