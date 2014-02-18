<html>
	<head>
	  
	    <link rel="stylesheet" type="text/css" href="/styles/main.css"/>
	    
	    <script type="text/javascript" src="/scripts/jquery-1.9.1.min.js"></script>
	
	    <script src="http://widgets.twimg.com/j/2/widget.js"></script> 
	    
	    <title>ZooPeeker</title>
	
	</head>
    <body>
        <h1>ZooPeeker</h1>
        
        <hr/>
        
        <div id="status">
        	<#if connected>
        		Connected
        	<#else>
        		Disconnected
        	</#if>
        </div>
        
        <hr/>
        
        <div id="breadcrumbs">
        	<a href="/${node}">${node}</a><br/>
        </div>
        
        <hr/>
        
        <div id="nodes">
        
			<#assign keys = nodes?keys>
			<#list keys as key>
				<a href="${nodes[key]}">${key}</a><br/>
			</#list>            

        </div>
        
    </body>
</html>