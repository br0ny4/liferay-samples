package com.dz100.samples.charts.constants;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

@Component(
        property = "javax.portlet.name=" + ChartPortletKeys.CHART,
        service = ConfigurationAction.class
)
public class ChartsConfigurationAction extends DefaultConfigurationAction {

    @Override
    public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        String bargap = ParamUtil.getString(actionRequest, "bargap");
        String title = ParamUtil.getString(actionRequest, "title");
        String chartTheme = ParamUtil.getString(actionRequest, "chart_theme");
        String source = ParamUtil.getString(actionRequest, "source");


        setPreference(actionRequest, "bargap", bargap);
        setPreference(actionRequest, "title", title);
        setPreference(actionRequest, "chart_theme", chartTheme);
        setPreference(actionRequest, "source", source);
        super.processAction(portletConfig, actionRequest, actionResponse);
    }
}
