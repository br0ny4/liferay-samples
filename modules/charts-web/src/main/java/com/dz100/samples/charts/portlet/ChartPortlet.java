package com.dz100.samples.charts.portlet;

import com.dz100.samples.charts.constants.ChartPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author kiana
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.config-template=/configuration.jsp",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Chart",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ChartPortletKeys.CHART,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ChartPortlet extends MVCPortlet {
}