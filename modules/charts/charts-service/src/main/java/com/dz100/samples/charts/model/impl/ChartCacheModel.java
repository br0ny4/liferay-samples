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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Chart in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ChartCacheModel implements CacheModel<Chart>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ChartCacheModel)) {
			return false;
		}

		ChartCacheModel chartCacheModel = (ChartCacheModel)obj;

		if (name.equals(chartCacheModel.name)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, name);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{name=");
		sb.append(name);
		sb.append(", year_2015=");
		sb.append(year_2015);
		sb.append(", year_2016=");
		sb.append(year_2016);
		sb.append(", year_2017=");
		sb.append(year_2017);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Chart toEntityModel() {
		ChartImpl chartImpl = new ChartImpl();

		if (name == null) {
			chartImpl.setName("");
		}
		else {
			chartImpl.setName(name);
		}

		chartImpl.setYear_2015(year_2015);
		chartImpl.setYear_2016(year_2016);
		chartImpl.setYear_2017(year_2017);

		chartImpl.resetOriginalValues();

		return chartImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		name = objectInput.readUTF();

		year_2015 = objectInput.readInt();

		year_2016 = objectInput.readInt();

		year_2017 = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeInt(year_2015);

		objectOutput.writeInt(year_2016);

		objectOutput.writeInt(year_2017);
	}

	public String name;
	public int year_2015;
	public int year_2016;
	public int year_2017;

}