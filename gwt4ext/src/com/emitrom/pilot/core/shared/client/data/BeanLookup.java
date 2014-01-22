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
package com.emitrom.pilot.core.shared.client.data;

import com.google.gwt.core.client.GWT;

/**
 * Returns <code>BeanModelFactories</code> for java beans. Java beans can be
 * converted to "models" via 2 methods. The first method requires a new
 * interface that extends <code>BeanMarker</code> and uses annotations.
 * This method does not require the JavaBean to be modified. With the second
 * method, your Java Bean implements the <code>BeanTag</code> interface.
 * 
 * @see BeanMarker
 * @see BeanTag
 */
public abstract class BeanLookup {

	private static BeanLookup instance;

	/**
	 * Returns the singleton bean model lookup.
	 * 
	 * @return the singleton instance
	 */
	public static BeanLookup get() {
		if (instance == null) {
			if (GWT.isClient()) {
				instance = GWT.create(BeanLookup.class);
			}
		}
		return instance;
	}

	/**
	 * Returns the factory for the given bean.
	 * 
	 * @param bean
	 *            the bean class
	 * @return the factory
	 */
	public abstract BeanFactory getFactory(Class<?> bean);

}
