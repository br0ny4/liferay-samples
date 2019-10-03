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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link com.dz100.samples.charts.service.http.ChartServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ChartSoap implements Serializable {

	public static ChartSoap toSoapModel(Chart model) {
		ChartSoap soapModel = new ChartSoap();

		soapModel.setName(model.getName());
		soapModel.setYear_2015(model.getYear_2015());
		soapModel.setYear_2016(model.getYear_2016());
		soapModel.setYear_2017(model.getYear_2017());

		return soapModel;
	}

	public static ChartSoap[] toSoapModels(Chart[] models) {
		ChartSoap[] soapModels = new ChartSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ChartSoap[][] toSoapModels(Chart[][] models) {
		ChartSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ChartSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ChartSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ChartSoap[] toSoapModels(List<Chart> models) {
		List<ChartSoap> soapModels = new ArrayList<ChartSoap>(models.size());

		for (Chart model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ChartSoap[soapModels.size()]);
	}

	public ChartSoap() {
	}

	public String getPrimaryKey() {
		return _name;
	}

	public void setPrimaryKey(String pk) {
		setName(pk);
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getYear_2015() {
		return _year_2015;
	}

	public void setYear_2015(int year_2015) {
		_year_2015 = year_2015;
	}

	public int getYear_2016() {
		return _year_2016;
	}

	public void setYear_2016(int year_2016) {
		_year_2016 = year_2016;
	}

	public int getYear_2017() {
		return _year_2017;
	}

	public void setYear_2017(int year_2017) {
		_year_2017 = year_2017;
	}

	private String _name;
	private int _year_2015;
	private int _year_2016;
	private int _year_2017;

}