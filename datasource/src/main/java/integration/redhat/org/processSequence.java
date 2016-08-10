package integration.redhat.org;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class processSequence implements Processor {

	private static final Logger LOG = LoggerFactory.getLogger(processSequence.class);
	
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub

		LOG.info("JAVA :: enter class processSequence");
		
		Message message = exchange.getIn();
		
		/* COMPUTING NEXT TRANSACTION ID */
		ArrayList sql_cursor = (ArrayList)message.getBody();
		if (sql_cursor == null)
			throw new SQLException("Error geeting SQL Sequence");
		Map map = (Map)sql_cursor.get(0);
		BigInteger sequence = (BigInteger)map.get("auto_increment");

		if (sequence == null) {
			throw new Exception("Error processing Sequence");
		}
		message.setHeader("sequence", sequence.intValue());
		LOG.info("database sequence = " + sequence);
	}

}
