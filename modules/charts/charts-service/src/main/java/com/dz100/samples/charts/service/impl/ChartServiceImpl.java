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

package com.dz100.samples.charts.service.impl;

import com.dz100.samples.charts.model.Chart;
import com.dz100.samples.charts.service.base.ChartServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * The implementation of the chart remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.dz100.samples.charts.service.ChartService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChartServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=dz",
		"json.web.service.context.path=Chart"
	},
	service = AopService.class
)
public class ChartServiceImpl extends ChartServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.dz100.samples.charts.service.ChartServiceUtil</code> to access the chart remote service.
	 */
	@JSONWebService(value = "/v1/chart/data")
	public JSONArray getChartData(){
		JSONArray res = JSONFactoryUtil.createJSONArray();
		JSONArray title = JSONFactoryUtil.createJSONArray(new String[]{"product", "2015", "2016", "2017"});
		res.put(title);
		List<Chart> data = chartPersistence.findAll();
		for (Chart row : data){
			JSONArray rows = JSONFactoryUtil.createJSONArray();
			rows.put(row.getName());
			rows.put(row.getYear_2015());
			rows.put(row.getYear_2016());
			rows.put(row.getYear_2017());
			res.put(rows);
		}
		return res;
	}
}