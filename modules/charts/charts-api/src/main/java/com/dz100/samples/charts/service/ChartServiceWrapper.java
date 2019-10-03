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

package com.dz100.samples.charts.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link ChartService}.
 *
 * @author Brian Wing Shun Chan
 * @see ChartService
 * @generated
 */
@ProviderType
public class ChartServiceWrapper
	implements ChartService, ServiceWrapper<ChartService> {

	public ChartServiceWrapper(ChartService chartService) {
		_chartService = chartService;
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getChartData() {
		return _chartService.getChartData();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _chartService.getOSGiServiceIdentifier();
	}

	@Override
	public ChartService getWrappedService() {
		return _chartService;
	}

	@Override
	public void setWrappedService(ChartService chartService) {
		_chartService = chartService;
	}

	private ChartService _chartService;

}