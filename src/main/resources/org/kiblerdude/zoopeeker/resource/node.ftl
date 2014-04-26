<html>
	<head>
		<link rel="SHORTCUT ICON" href="/assets/zookeeper.ico"/>
	  
	    <link rel="stylesheet" type="text/css" href="/assets/zoopeeker.css"/>
	    
	    <title>ZooPeeker</title>
	
	</head>
    <body>
    	<div id="zoopeeker">
	    	<div id="top" class="separated">
	        	<h1>ZooPeeker</h1>
	        </div>

	        <div id="status" class="separated">
	        	<#if connected>
	        		<span class="status connected">Connected</span>
	        	<#else>
	        		<span class="status disconnected">Disconnected</span>
	        	</#if>
	        </div>
	        
	        <div id="breadcrumbs" class="separated">
	        	<span>/&nbsp;</span><a href="/">root</a>
	        	<#assign keys1 = breadcrumbs?keys>
	        	<#list keys1 as key>
	        	<span>/&nbsp;</span><span class="node"><a href="${breadcrumbs[key]}">${key}</a></span>
	        	</#list>
	        </div>	        

	        <div id="nodes" class="separated">
				<h3>Nodes</h3>
				<#assign keys2 = nodes?keys>
				<#list keys2 as key>
					<a href="${nodes[key]}"><div class="node">${key}</div></a>
				</#list>	
	        </div>
	        
	        <div id="data" class="separated">
	        	<h3>Data</h3>
	        	${data}
	        </div>
        </div>
    </body>
</html>