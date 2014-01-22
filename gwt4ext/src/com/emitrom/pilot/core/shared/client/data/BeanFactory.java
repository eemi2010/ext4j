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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * BeanModelFactores are responsible for creating new <code>Bean</code>
 * instances from Java POJOs. <code>BeanModels</code> are GXT models and can be
 * used with the GXT data API. BeanModelFactories are obtained from @link
 * {@link BeanLookup}.
 * 
 * @see BeanLookup
 */
public abstract class BeanFactory {

	protected abstract Bean newInstance();

	/**
	 * Creates a new bean model instance.
	 * 
	 * @param bean
	 *            creates a new model
	 * @return the new model
	 */
	public Bean createModel(Object bean) {
		Bean model = newInstance();
		model.setBean(bean);
		return model;
	}

	/**
	 * Creates a list new bean model instances.
	 * 
	 * @param beans
	 *            the list of beans
	 * @return the list of models
	 */
	public List<Bean> createModel(Collection<?> beans) {
		List<Bean> models = new ArrayList<Bean>();
		for (Object obj : beans) {
			models.add(createModel(obj));
		}
		return models;
	}

}
