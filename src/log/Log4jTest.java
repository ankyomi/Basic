package log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Log4jTest {
	private static final Log log = LogFactory.getLog(Log4jTest.class);

	public static void main(String[] args) {
		log.info("i am info");
		log.debug("i am debug");
		log.error("i am errorsdsssf");

	}
}
