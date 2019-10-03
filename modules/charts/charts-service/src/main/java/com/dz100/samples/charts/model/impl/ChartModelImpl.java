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

package com.dz100.samples.charts.model.impl;

import com.dz100.samples.charts.model.Chart;
import com.dz100.samples.charts.model.ChartModel;
import com.dz100.samples.charts.model.ChartSoap;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model implementation for the Chart service. Represents a row in the &quot;DZ_Chart&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>ChartModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ChartImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChartImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class ChartModelImpl extends BaseModelImpl<Chart> implements ChartModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a chart model instance should use the <code>Chart</code> interface instead.
	 */
	public static final String TABLE_NAME = "DZ_Chart";

	public static final Object[][] TABLE_COLUMNS = {
		{"name", Types.VARCHAR}, {"year_2015", Types.INTEGER},
		{"year_2016", Types.INTEGER}, {"year_2017", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("year_2015", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("year_2016", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("year_2017", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table DZ_Chart (name VARCHAR(75) not null primary key,year_2015 INTEGER,year_2016 INTEGER,year_2017 INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table DZ_Chart";

	public static final String ORDER_BY_JPQL = " ORDER BY chart.name ASC";

	public static final String ORDER_BY_SQL = " ORDER BY DZ_Chart.name ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Chart toModel(ChartSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Chart model = new ChartImpl();

		model.setName(soapModel.getName());
		model.setYear_2015(soapModel.getYear_2015());
		model.setYear_2016(soapModel.getYear_2016());
		model.setYear_2017(soapModel.getYear_2017());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Chart> toModels(ChartSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Chart> models = new ArrayList<Chart>(soapModels.length);

		for (ChartSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public ChartModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _name;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setName(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _name;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return Chart.class;
	}

	@Override
	public String getModelClassName() {
		return Chart.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Chart, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Chart, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Chart, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Chart)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Chart, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Chart, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Chart)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Chart, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Chart, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Chart>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Chart.class.getClassLoader(), Chart.class, ModelWrapper.class);

		try {
			Constructor<Chart> constructor =
				(Constructor<Chart>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<Chart, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Chart, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Chart, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Chart, Object>>();
		Map<String, BiConsumer<Chart, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Chart, ?>>();

		attributeGetterFunctions.put("name", Chart::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<Chart, String>)Chart::setName);
		attributeGetterFunctions.put("year_2015", Chart::getYear_2015);
		attributeSetterBiConsumers.put(
			"year_2015", (BiConsumer<Chart, Integer>)Chart::setYear_2015);
		attributeGetterFunctions.put("year_2016", Chart::getYear_2016);
		attributeSetterBiConsumers.put(
			"year_2016", (BiConsumer<Chart, Integer>)Chart::setYear_2016);
		attributeGetterFunctions.put("year_2017", Chart::getYear_2017);
		attributeSetterBiConsumers.put(
			"year_2017", (BiConsumer<Chart, Integer>)Chart::setYear_2017);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@JSON
	@Override
	public int getYear_2015() {
		return _year_2015;
	}

	@Override
	public void setYear_2015(int year_2015) {
		_year_2015 = year_2015;
	}

	@JSON
	@Override
	public int getYear_2016() {
		return _year_2016;
	}

	@Override
	public void setYear_2016(int year_2016) {
		_year_2016 = year_2016;
	}

	@JSON
	@Override
	public int getYear_2017() {
		return _year_2017;
	}

	@Override
	public void setYear_2017(int year_2017) {
		_year_2017 = year_2017;
	}

	@Override
	public Chart toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ChartImpl chartImpl = new ChartImpl();

		chartImpl.setName(getName());
		chartImpl.setYear_2015(getYear_2015());
		chartImpl.setYear_2016(getYear_2016());
		chartImpl.setYear_2017(getYear_2017());

		chartImpl.resetOriginalValues();

		return chartImpl;
	}

	@Override
	public int compareTo(Chart chart) {
		String primaryKey = chart.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Chart)) {
			return false;
		}

		Chart chart = (Chart)obj;

		String primaryKey = chart.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<Chart> toCacheModel() {
		ChartCacheModel chartCacheModel = new ChartCacheModel();

		chartCacheModel.name = getName();

		String name = chartCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			chartCacheModel.name = null;
		}

		chartCacheModel.year_2015 = getYear_2015();

		chartCacheModel.year_2016 = getYear_2016();

		chartCacheModel.year_2017 = getYear_2017();

		return chartCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Chart, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Chart, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Chart, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Chart)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Chart, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Chart, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Chart, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Chart)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, Chart>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();
	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private String _name;
	private int _year_2015;
	private int _year_2016;
	private int _year_2017;
	private Chart _escapedModel;

}