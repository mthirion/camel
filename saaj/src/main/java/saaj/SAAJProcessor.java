package saaj;

import java.util.Map;

import javax.activation.DataHandler;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.cxf.helpers.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SAAJProcessor implements Processor {

	private static final Logger LOG = LoggerFactory.getLogger(SAAJProcessor.class);
	
	public void process(Exchange exchange) throws Exception {
		
		Message m = exchange.getIn();
		
				
		/* GET ATTACHMENT */
		Map<String, DataHandler> map = m.getAttachments();
		if (map.size() <1)
			throw new Exception("Missing attachment");
		
		String attachmentName = map.keySet().iterator().next();
		DataHandler data = map.get(attachmentName);
		String attachmentContent = IOUtils.toString(data.getInputStream(), "UTF-8");
		if (attachmentContent == null || attachmentContent.isEmpty())
			throw new Exception("Empty attachment");

		LOG.info("attachment name : " + attachmentName);
		
		LOG.info("attachment content");
		LOG.info("------------------");
		String[] nolist = attachmentContent.split("\n");
		for (int i=0;i<nolist.length;i++)
			LOG.info("["+(i+1)+"]   : " + nolist[i]);
		
		
	}

}
