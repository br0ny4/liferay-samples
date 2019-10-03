/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.dz100.samples.charts.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link Chart}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Chart
 * @generated
 */
@ProviderType
public class ChartWrapper
	extends BaseModelWrapper<Chart> implements Chart, ModelWrapper<Chart> {

	public ChartWrapper(Chart chart) {
		super(chart);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("name", getName());
		attributes.put("year_2015", getYear_2015());
		attributes.put("year_2016", getYear_2016());
		attributes.put("year_2017", getYear_2017());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer year_2015 = (Integer)attributes.get("year_2015");

		if (year_2015 != null) {
			setYear_2015(year_2015);
		}

		Integer year_2016 = (Integer)attributes.get("year_2016");

		if (year_2016 != null) {
			setYear_2016(year_2016);
		}

		Integer year_2017 = (Integer)attributes.get("year_2017");

		if (year_2017 != null) {
			setYear_2017(year_2017);
		}
	}

	/**
	 * Returns the name of this chart.
	 *
	 * @return the name of this chart
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this chart.
	 *
	 * @return the primary key of this chart
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the year_2015 of this chart.
	 *
	 * @return the year_2015 of this chart
	 */
	@Override
	public int getYear_2015() {
		return model.getYear_2015();
	}

	/**
	 * Returns the year_2016 of this chart.
	 *
	 * @return the year_2016 of this chart
	 */
	@Override
	public int getYear_2016() {
		return model.getYear_2016();
	}

	/**
	 * Returns the year_2017 of this chart.
	 *
	 * @return the year_2017 of this chart
	 */
	@Override
	public int getYear_2017() {
		return model.getYear_2017();
	}

	/**
	 * Sets the name of this chart.
	 *
	 * @param name the name of this chart
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this chart.
	 *
	 * @param primaryKey the primary key of this chart
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the year_2015 of this chart.
	 *
	 * @param year_2015 the year_2015 of this chart
	 */
	@Override
	public void setYear_2015(int year_2015) {
		model.setYear_2015(year_2015);
	}

	/**
	 * Sets the year_2016 of this chart.
	 *
	 * @param year_2016 the year_2016 of this chart
	 */
	@Override
	public void setYear_2016(int year_2016) {
		model.setYear_2016(year_2016);
	}

	/**
	 * Sets the year_2017 of this chart.
	 *
	 * @param year_2017 the year_2017 of this chart
	 */
	@Override
	public void setYear_2017(int year_2017) {
		model.setYear_2017(year_2017);
	}

	@Override
	protected ChartWrapper wrap(Chart chart) {
		return new ChartWrapper(chart);
	}

}