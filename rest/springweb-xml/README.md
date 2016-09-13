# Overview
This is an example of the Camel rest API in XML.
The XML is launched using Spring web --> servlet listener with a configured contextloader in web.xml


# Compatibility
The example is developped for Fuse v6.2 on EAP and generates an application as a WAR.


# App config
Contrary to CDI, Spring allows us to use the "jetty" ReST component. <br>
This allows the customization of the uri path and port number.


# Running the example
Once deployed the application listens to "GET localhost:9098/rest/test" and returns "Ok -- returned from the GET /rest/test".


