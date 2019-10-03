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

package com.dz100.samples.charts.service.persistence;

import com.dz100.samples.charts.exception.NoSuchChartException;
import com.dz100.samples.charts.model.Chart;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the chart service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChartUtil
 * @generated
 */
@ProviderType
public interface ChartPersistence extends BasePersistence<Chart> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ChartUtil} to access the chart persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the chart in the entity cache if it is enabled.
	 *
	 * @param chart the chart
	 */
	public void cacheResult(Chart chart);

	/**
	 * Caches the charts in the entity cache if it is enabled.
	 *
	 * @param charts the charts
	 */
	public void cacheResult(java.util.List<Chart> charts);

	/**
	 * Creates a new chart with the primary key. Does not add the chart to the database.
	 *
	 * @param name the primary key for the new chart
	 * @return the new chart
	 */
	public Chart create(String name);

	/**
	 * Removes the chart with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param name the primary key of the chart
	 * @return the chart that was removed
	 * @throws NoSuchChartException if a chart with the primary key could not be found
	 */
	public Chart remove(String name) throws NoSuchChartException;

	public Chart updateImpl(Chart chart);

	/**
	 * Returns the chart with the primary key or throws a <code>NoSuchChartException</code> if it could not be found.
	 *
	 * @param name the primary key of the chart
	 * @return the chart
	 * @throws NoSuchChartException if a chart with the primary key could not be found
	 */
	public Chart findByPrimaryKey(String name) throws NoSuchChartException;

	/**
	 * Returns the chart with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param name the primary key of the chart
	 * @return the chart, or <code>null</code> if a chart with the primary key could not be found
	 */
	public Chart fetchByPrimaryKey(String name);

	/**
	 * Returns all the charts.
	 *
	 * @return the charts
	 */
	public java.util.List<Chart> findAll();

	/**
	 * Returns a range of all the charts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ChartModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of charts
	 * @param end the upper bound of the range of charts (not inclusive)
	 * @return the range of charts
	 */
	public java.util.List<Chart> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the charts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ChartModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of charts
	 * @param end the upper bound of the range of charts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of charts
	 */
	public java.util.List<Chart> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Chart>
			orderByComparator);

	/**
	 * Returns an ordered range of all the charts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ChartModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of charts
	 * @param end the upper bound of the range of charts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of charts
	 */
	public java.util.List<Chart> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Chart>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the charts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of charts.
	 *
	 * @return the number of charts
	 */
	public int countAll();

}