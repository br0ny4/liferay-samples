<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%@ page contentType="text/html; charset=UTF-8" %>
<%
    String bargap = portletPreferences.getValue("bargap", "30");
    String title = portletPreferences.getValue("title", "标题");
    String chartTheme = portletPreferences.getValue("chart_theme", "vintage");
    String source = portletPreferences.getValue("source", "/dz.v1/chart/data");
%>