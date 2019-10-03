<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ include file="/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="liferay-frontend" uri="http://liferay.com/tld/frontend" %>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL"/>
<liferay-portlet:renderURL portletConfiguration="true" var="configurationRenderURL"/>

<liferay-frontend:edit-form action="<%= configurationActionURL%>" method="post">

    <aui:input name="<%= Constants.CMD%>" type="hidden" value="<%= Constants.UPDATE%>"/>
    <aui:input name="redirect" type="hidden" value="<%= configurationRenderURL%>"/>

    <liferay-frontend:edit-form-body>

        <liferay-frontend:fieldset>
            <aui:input name="source" label="资源" type="text" value="<%= source%>"/>
            <aui:input name="bargap" label="间隙" type="number" value="<%= bargap%>"/>
            <aui:input name="title" label="标题" type="text" value="<%= title%>"/>
            <aui:select name="chart_theme" label="主题" value="<%= chartTheme%>">
                <aui:option value="vintage" label="vintage"/>
                <aui:option value="dark" label="dark"/>
                <aui:option value="macarons" label="macarons"/>
                <aui:option value="infographic" label="inforaphic"/>
                <aui:option value="shine" label="shine"/>
                <aui:option value="roma" label="roma"/>
            </aui:select>
        </liferay-frontend:fieldset>
    </liferay-frontend:edit-form-body>

    <liferay-frontend:edit-form-footer>
        <aui:button type="submit"/>
        <aui:button type="cancel"/>
    </liferay-frontend:edit-form-footer>
</liferay-frontend:edit-form>