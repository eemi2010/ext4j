/**
 Ext4j UI Library
 Copyright 2014, Alain Ekambi, and individual contributors as indicated
 by the @authors tag. See the copyright.txt in the distribution for a
 full listing of individual contributors.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.eemi.ext4j.client.core;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

@SuppressWarnings("serial")
public class FastSet extends AbstractSet<String> implements Serializable {
	private Map<String, String> map;
	private static final String PRESENT = "";

	public FastSet() {
		map = new FastMap<String>();
	}

	@Override
	public boolean add(String s) {
		return map.put(s, PRESENT) == null;
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public boolean contains(Object o) {
		return map.containsKey(o);
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public Iterator<String> iterator() {
		return map.keySet().iterator();
	}

	@Override
	public boolean remove(Object o) {
		String s = map.remove(o);
		return s != null && s.equals(PRESENT);
	}

	@Override
	public int size() {
		return map.size();
	}

}
