# Overview
This is an example of the Camel rest API in Java using CDI.
CDI is enabled thanks to the CDI-specific WELD servlet listner defined in the web.xml


# Compatibility
The example is developped for Fuse v6.2 on EAP and generates an application as a WAR.


# App config
Contrary to Spring, here we can't use the "jetty" ReST component and need to bind the rest endpoint to a Servlet. <br>
The Camel HTTP Servlet is used and defined in web.xml <br>
This doesn't allow any customization of the uri path and port number. <br>


# Running the example
Therefore the application is running under: localhost:8080/webapp-context-path/servlet-mapping/rest-endpoint <br>
It returns "Ok --returned by Rest CDI endpoint"




