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

import com.dz100.samples.charts.model.Chart;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the chart service. This utility wraps <code>com.dz100.samples.charts.service.persistence.impl.ChartPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChartPersistence
 * @generated
 */
@ProviderType
public class ChartUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Chart chart) {
		getPersistence().clearCache(chart);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Chart> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Chart> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Chart> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Chart> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Chart> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Chart update(Chart chart) {
		return getPersistence().update(chart);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Chart update(Chart chart, ServiceContext serviceContext) {
		return getPersistence().update(chart, serviceContext);
	}

	/**
	 * Caches the chart in the entity cache if it is enabled.
	 *
	 * @param chart the chart
	 */
	public static void cacheResult(Chart chart) {
		getPersistence().cacheResult(chart);
	}

	/**
	 * Caches the charts in the entity cache if it is enabled.
	 *
	 * @param charts the charts
	 */
	public static void cacheResult(List<Chart> charts) {
		getPersistence().cacheResult(charts);
	}

	/**
	 * Creates a new chart with the primary key. Does not add the chart to the database.
	 *
	 * @param name the primary key for the new chart
	 * @return the new chart
	 */
	public static Chart create(String name) {
		return getPersistence().create(name);
	}

	/**
	 * Removes the chart with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param name the primary key of the chart
	 * @return the chart that was removed
	 * @throws NoSuchChartException if a chart with the primary key could not be found
	 */
	public static Chart remove(String name)
		throws com.dz100.samples.charts.exception.NoSuchChartException {

		return getPersistence().remove(name);
	}

	public static Chart updateImpl(Chart chart) {
		return getPersistence().updateImpl(chart);
	}

	/**
	 * Returns the chart with the primary key or throws a <code>NoSuchChartException</code> if it could not be found.
	 *
	 * @param name the primary key of the chart
	 * @return the chart
	 * @throws NoSuchChartException if a chart with the primary key could not be found
	 */
	public static Chart findByPrimaryKey(String name)
		throws com.dz100.samples.charts.exception.NoSuchChartException {

		return getPersistence().findByPrimaryKey(name);
	}

	/**
	 * Returns the chart with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param name the primary key of the chart
	 * @return the chart, or <code>null</code> if a chart with the primary key could not be found
	 */
	public static Chart fetchByPrimaryKey(String name) {
		return getPersistence().fetchByPrimaryKey(name);
	}

	/**
	 * Returns all the charts.
	 *
	 * @return the charts
	 */
	public static List<Chart> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Chart> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Chart> findAll(
		int start, int end, OrderByComparator<Chart> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Chart> findAll(
		int start, int end, OrderByComparator<Chart> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the charts from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of charts.
	 *
	 * @return the number of charts
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ChartPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ChartPersistence, ChartPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ChartPersistence.class);

		ServiceTracker<ChartPersistence, ChartPersistence> serviceTracker =
			new ServiceTracker<ChartPersistence, ChartPersistence>(
				bundle.getBundleContext(), ChartPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}