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
package com.ait.ext4j.client.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NestedModelUtil {

	@SuppressWarnings("unchecked")
	public static <X> X getNestedValue(BaseModel model, String property) {
		return (X) getNestedValue(model, getPath(property));
	}

	@SuppressWarnings("unchecked")
	public static <X> X getNestedValue(BaseModel model, List<String> paths) {
		Object obj = model.get(paths.get(0));
		if (paths.size() == 1) {
			return (X) obj;
		} else if (obj != null && obj instanceof BaseModel) {
			List<String> tmp = new ArrayList<String>(paths);
			tmp.remove(0);
			return (X) getNestedValue((BaseModel) obj, tmp);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static <X> X setNestedValue(BaseModel model, String property,
			Object value) {
		return (X) setNestedValue(model, getPath(property), value);
	}

	@SuppressWarnings("unchecked")
	public static <X> X setNestedValue(BaseModel model, List<String> paths,
			Object value) {
		int index = paths.size() - 1;
		String path = paths.get(index);
		paths.remove(index);
		BaseModel m = getNestedValue(model, paths);
		m.set(path, value);
		return (X) m.get(path);
	}

	public static boolean isNestedProperty(String property) {
		return property != null && property.contains(".");
	}

	private static List<String> getPath(String property) {
		return new ArrayList<String>(Arrays.asList(property.split("\\.")));
	}
}
