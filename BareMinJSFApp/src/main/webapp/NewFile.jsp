<%@page import="javax.faces.context.FacesContext"%> 
<%@page import="javax.faces.application.FacesMessage"%>	     
 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<link type="text/css" href="jquery-ui-1.10.3.custom/css/ui-lightness/jquery-ui-1.10.3.custom.min.css" rel="stylesheet" />
<script type="text/javascript" src="jquery-ui-1.10.3.custom/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="jquery-ui-1.10.3.custom/js/jquery-ui-1.10.3.custom.js"></script>


<script type="text/JavaScript">        
		$(document).ready(function() {
		    $("#jsfJQueryForm\\:tags").autocomplete({
		        width: 300,
		        max: 10,
		        delay: 100,
		        minLength: 1,
		        autoFocus: true,
		        cacheLength: 1,
		        scroll: true,
		        highlight: false,
		        source: function(request, response) {
		            $.ajax({
		                url: "http://localhost:8080/JSFJQuery/test",
		                dataType: "json",
		                data: request,
		                success: function( data, textStatus, jqXHR) {
		                    console.log( data);
		                    var items = data;
		                    response(items);
		                },
		                error: function(jqXHR, textStatus, errorThrown){
		                     console.log( textStatus);
		                }
		            });
		        }
		 
		    });
		});
		
</script>

<f:view>

<h:form id="jsfJQueryForm">
	
	<h:outputLabel value="Total number of Locations: " />
	<h:outputText id="out" value="#{locationCodeBean.size}"/>

	    <div class="ui-widget">
				<label for="tags">Location: </label>
			<h:inputText id="tags" />		
	
		</div>
</h:form>

</f:view>
