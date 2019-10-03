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

package com.dz100.samples.charts.service.persistence.impl;

import com.dz100.samples.charts.exception.NoSuchChartException;
import com.dz100.samples.charts.model.Chart;
import com.dz100.samples.charts.model.impl.ChartImpl;
import com.dz100.samples.charts.model.impl.ChartModelImpl;
import com.dz100.samples.charts.service.persistence.ChartPersistence;
import com.dz100.samples.charts.service.persistence.impl.constants.DZPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the chart service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ChartPersistence.class)
@ProviderType
public class ChartPersistenceImpl
	extends BasePersistenceImpl<Chart> implements ChartPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ChartUtil</code> to access the chart persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ChartImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public ChartPersistenceImpl() {
		setModelClass(Chart.class);

		setModelImplClass(ChartImpl.class);
		setModelPKClass(String.class);
	}

	/**
	 * Caches the chart in the entity cache if it is enabled.
	 *
	 * @param chart the chart
	 */
	@Override
	public void cacheResult(Chart chart) {
		entityCache.putResult(
			entityCacheEnabled, ChartImpl.class, chart.getPrimaryKey(), chart);

		chart.resetOriginalValues();
	}

	/**
	 * Caches the charts in the entity cache if it is enabled.
	 *
	 * @param charts the charts
	 */
	@Override
	public void cacheResult(List<Chart> charts) {
		for (Chart chart : charts) {
			if (entityCache.getResult(
					entityCacheEnabled, ChartImpl.class,
					chart.getPrimaryKey()) == null) {

				cacheResult(chart);
			}
			else {
				chart.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all charts.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ChartImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the chart.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Chart chart) {
		entityCache.removeResult(
			entityCacheEnabled, ChartImpl.class, chart.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Chart> charts) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Chart chart : charts) {
			entityCache.removeResult(
				entityCacheEnabled, ChartImpl.class, chart.getPrimaryKey());
		}
	}

	/**
	 * Creates a new chart with the primary key. Does not add the chart to the database.
	 *
	 * @param name the primary key for the new chart
	 * @return the new chart
	 */
	@Override
	public Chart create(String name) {
		Chart chart = new ChartImpl();

		chart.setNew(true);
		chart.setPrimaryKey(name);

		return chart;
	}

	/**
	 * Removes the chart with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param name the primary key of the chart
	 * @return the chart that was removed
	 * @throws NoSuchChartException if a chart with the primary key could not be found
	 */
	@Override
	public Chart remove(String name) throws NoSuchChartException {
		return remove((Serializable)name);
	}

	/**
	 * Removes the chart with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the chart
	 * @return the chart that was removed
	 * @throws NoSuchChartException if a chart with the primary key could not be found
	 */
	@Override
	public Chart remove(Serializable primaryKey) throws NoSuchChartException {
		Session session = null;

		try {
			session = openSession();

			Chart chart = (Chart)session.get(ChartImpl.class, primaryKey);

			if (chart == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchChartException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(chart);
		}
		catch (NoSuchChartException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Chart removeImpl(Chart chart) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(chart)) {
				chart = (Chart)session.get(
					ChartImpl.class, chart.getPrimaryKeyObj());
			}

			if (chart != null) {
				session.delete(chart);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (chart != null) {
			clearCache(chart);
		}

		return chart;
	}

	@Override
	public Chart updateImpl(Chart chart) {
		boolean isNew = chart.isNew();

		Session session = null;

		try {
			session = openSession();

			if (chart.isNew()) {
				session.save(chart);

				chart.setNew(false);
			}
			else {
				chart = (Chart)session.merge(chart);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, ChartImpl.class, chart.getPrimaryKey(), chart,
			false);

		chart.resetOriginalValues();

		return chart;
	}

	/**
	 * Returns the chart with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the chart
	 * @return the chart
	 * @throws NoSuchChartException if a chart with the primary key could not be found
	 */
	@Override
	public Chart findByPrimaryKey(Serializable primaryKey)
		throws NoSuchChartException {

		Chart chart = fetchByPrimaryKey(primaryKey);

		if (chart == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchChartException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return chart;
	}

	/**
	 * Returns the chart with the primary key or throws a <code>NoSuchChartException</code> if it could not be found.
	 *
	 * @param name the primary key of the chart
	 * @return the chart
	 * @throws NoSuchChartException if a chart with the primary key could not be found
	 */
	@Override
	public Chart findByPrimaryKey(String name) throws NoSuchChartException {
		return findByPrimaryKey((Serializable)name);
	}

	/**
	 * Returns the chart with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param name the primary key of the chart
	 * @return the chart, or <code>null</code> if a chart with the primary key could not be found
	 */
	@Override
	public Chart fetchByPrimaryKey(String name) {
		return fetchByPrimaryKey((Serializable)name);
	}

	/**
	 * Returns all the charts.
	 *
	 * @return the charts
	 */
	@Override
	public List<Chart> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Chart> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Chart> findAll(
		int start, int end, OrderByComparator<Chart> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Chart> findAll(
		int start, int end, OrderByComparator<Chart> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Chart> list = null;

		if (retrieveFromCache) {
			list = (List<Chart>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CHART);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CHART;

				if (pagination) {
					sql = sql.concat(ChartModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Chart>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Chart>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the charts from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Chart chart : findAll()) {
			remove(chart);
		}
	}

	/**
	 * Returns the number of charts.
	 *
	 * @return the number of charts
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CHART);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "name";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CHART;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ChartModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the chart persistence.
	 */
	@Activate
	public void activate() {
		ChartModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ChartModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ChartImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ChartImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ChartImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = DZPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.dz100.samples.charts.model.Chart"),
			true);
	}

	@Override
	@Reference(
		target = DZPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = DZPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CHART =
		"SELECT chart FROM Chart chart";

	private static final String _SQL_COUNT_CHART =
		"SELECT COUNT(chart) FROM Chart chart";

	private static final String _ORDER_BY_ENTITY_ALIAS = "chart.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Chart exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		ChartPersistenceImpl.class);

}