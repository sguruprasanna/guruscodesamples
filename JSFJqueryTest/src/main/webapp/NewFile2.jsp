<%@page import="javax.faces.context.FacesContext"%> 
<%@page import="javax.faces.application.FacesMessage"%>	     
 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<link type="text/css" href="jquery-ui-1.10.3.custom/css/ui-lightness/jquery-ui-1.10.3.custom.min.css" rel="stylesheet" />
<script type="text/javascript" src="jquery-ui-1.10.3.custom/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="jquery-ui-1.10.3.custom/js/jquery-ui-1.10.3.custom.js"></script>

<script>        
$(function() {
var availableTags = ['Granada, NI', 'Appleton, WI', 'Deerfield Beach, FL', 'Cleveland, MS', 'Copiague, NY', 'New York, NY', 'Caldera, CR', 'Turrialba, CR', 'La Romana, DO', 'San Jose Pinula, GT', 'Villanueva, GT', 'Perth, Ontario', 'Anniston, AL', 'Ashdown, AR', 'Bradley, IL', 'Des Plaines, IL', 'Long Beach, CA', 'Oakland, CA', 'Summit, IL', 'St Louis, MO', 'Bufalo, HN', 'La Paz, SV', 'San Pedro de Macoris, DO', 'Gulfport, MS, US (Port)', 'Bridgetown, Barbados (Port)', 'Port Au Prince, Haiti (Port)', 'Bridgeview, IL', 'Hamilton, OH', 'Niles, IL', 'Belmont, NC', 'Buffalo, NY', 'Salisbury, NC', 'Chicago, IL (Rail)', 'Atlanta, GA (Rail Ramp - NS)', 'Perrysburg, OH', 'Gulfport, MS', 'Tupelo, MS', 'Ft Worth, TX', 'Chalchuapa, SV', 'Newburyport, MA', 'Cherry Hill, NJ', 'Jackson, TN', 'Port Everglades, FL', 'Alajuela, CR', 'El Paraiso, HN', 'Fort Payne, AL', 'Hillsville, VA', 'Sparta, NC', 'Quimistan, HN', 'Callahan, FL', 'Lakeland, FL', 'Sanford, FL', 'Adel, GA', 'Wrightsville, GA', 'Elgin, IL', 'Washington, MO', 'Greer, SC', 'Saddle Brook, NJ', 'Toms RIver, NJ', 'Trenton, NJ', 'Wood RIdge, NJ', 'Batavia, NY', 'Cornwall, NY', 'Fredonia, NY', 'Holland, NY', 'Johnstown, NY', 'Coral Gables, FL', 'Mahopac, NY', 'Milton, NY', 'Little Falls, NY', 'WIlliamsville, NY', 'Ashland, OH', 'Cadiz, OH', 'Delaware, OH', 'Fremont, OH', 'Graniteville, SC', 'Green Bay, WI', 'Logan Township, NJ', 'Slidell, LA', 'Adams, MA', 'Auburn, MA', 'Burlington, MA', 'Everett, MA', 'Lawrence, MA', 'Natick, MA', 'North Brookfield, MA', 'North Billerica, MA', 'Northhampton, MA', 'Reading, MA', 'Raynham, MA', 'Springfield, MA', 'Webster, MA', 'Curtis Bay, MD', 'Dundalk, MD', 'Glen Burnie, MD', 'Hampstead, MD', 'Hunt Valley, MD', 'Middle River, MD', 'Owings Mills, MD', 'Rockville, MD'];
	//var availableTags = [Granada, NI, Appleton, WI, Deerfield Beach, FL, Cleveland, MS, Copiague, NY, New York, NY, Caldera, CR, Turrialba, CR, La Romana, DO, San Jose Pinula, GT, Villanueva, GT, Perth, Ontario, Anniston, AL, Ashdown, AR, Bradley, IL, Des Plaines, IL, Long Beach, CA, Oakland, CA, Summit, IL, St Louis, MO, Bufalo, HN, La Paz, SV, San Pedro de Macoris, DO, Gulfport, MS, US (Port), Bridgetown, Barbados (Port), Port Au Prince, Haiti (Port), Bridgeview, IL, Hamilton, OH, Niles, IL, Belmont, NC, Buffalo, NY, Salisbury, NC, Chicago, IL (Rail), Atlanta, GA (Rail Ramp - NS), Perrysburg, OH, Gulfport, MS, Tupelo, MS, Ft Worth, TX, Chalchuapa, SV, Newburyport, MA, Cherry Hill, NJ, Jackson, TN, Port Everglades, FL, Alajuela, CR, El Paraiso, HN, Fort Payne, AL, Hillsville, VA, Sparta, NC, Quimistan, HN, Callahan, FL, Lakeland, FL, Sanford, FL, Adel, GA, Wrightsville, GA, Elgin, IL, Washington, MO, Greer, SC, Saddle Brook, NJ, Toms RIver, NJ, Trenton, NJ, Wood RIdge, NJ, Batavia, NY, Cornwall, NY, Fredonia, NY, Holland, NY, Johnstown, NY, Coral Gables, FL, Mahopac, NY, Milton, NY, Little Falls, NY, WIlliamsville, NY, Ashland, OH, Cadiz, OH, Delaware, OH, Fremont, OH, Graniteville, SC, Green Bay, WI, Logan Township, NJ, Slidell, LA, Adams, MA, Auburn, MA, Burlington, MA, Everett, MA, Lawrence, MA, Natick, MA, North Brookfield, MA, North Billerica, MA, Northhampton, MA, Reading, MA, Raynham, MA, Springfield, MA, Webster, MA, Curtis Bay, MD, Dundalk, MD, Glen Burnie, MD, Hampstead, MD, Hunt Valley, MD, Middle River, MD, Owings Mills, MD, Rockville, MD];

	$( "#watchListForm\\:tags" ).autocomplete({
	source: availableTags
	, minLength: 3});
});
</script>

<f:view>
 <h:form id="watchListForm">
    <div class="ui-widget">
		<label for="tags">Symbol: </label>
		<h:inputText id="tags" />
	</div>
 </h:form>
</f:view>
