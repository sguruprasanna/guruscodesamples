<%@page import="javax.faces.context.FacesContext"%> 
<%@page import="javax.faces.application.FacesMessage"%>	     
 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<script type="text/JavaScript">
</script>

<f:view>
	<h:form >
		<h:outputLabel value="Value of description is : " />
		<h:outputText id="out" value="#{locationCodeBean.description}"/>
	</h:form>

</f:view>
