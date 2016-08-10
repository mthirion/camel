# Overview
This example showcases the use of the SOAP with Attachment (SwA) with Camel.


# Compatibility
The example is developped for Fuse v6.2 on Karaf in Fabric mode.


# Detailed description

## Application
For the example, we imagine a simple mass-SMS application.
The application is a SOAP-based web service that accepts:
 - a request with a username (the sender ID) and the SMS message as text
 - an attached text file containing a line-separated list of phone numbers.

The application will simply return 'sucess' and will log the attachment filename and content in the Fuse container log file.
The processing of the attachment is done in the SaajProcessor Java bean.
The application listens to localhost:9090/attachment.

## CXF 
The Camel route uses CXF for the SOAP implementation.
A Payload dataformat is to be used when using attachment.
With the Message data format, both the soap envelopped and the attachment (which basically means the entire HTTP content) will be present in the Camel Message Body as a MIME part.
As this is not a valid XML, it's difficult to handle within the Camel route.

## WSDL
The CXF endpoint is defined by a wsdl (saaj.wsdl).
The wsdl defines the input SOAP request as a MIME type with multiple part (body + attachment).
To simplify the example, the XSD types are embedded into the WSDL.

## Testing
A SOAPUI project file is present in the src/main/test directory.
This has been tested with SOAPUI v5.2.1.
An example text file that can be used as an attachment is in src/main/resources


# Links
* [Fabric8 maven plugin](http://fabric8.io/gitbook/mavenPlugin.html)

