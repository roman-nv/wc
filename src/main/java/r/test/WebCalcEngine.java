package r.test;

import javax.jws.WebService;
import javax.jws.WebMethod;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

@WebService(endpointInterface = "r.test.WebCalc",
            serviceName = "WebCalc")
public class WebCalcEngine implements WebCalc {
	static Logger log = Logger.getLogger(WebCalcEngine.class.getName());

	public String Compute(String expr) {
        String result;

        boolean b = Pattern.matches("^[0-9]+[+-/*]{1}[0-9]+$", expr);
        log.info("Evaluating string [" + expr + "]");
		if (expr.length() < 3) {
			result = "Input string must contain at least 3 chars";

        }
		else if (!b) {
			result = "Input string contains wrong symbols. Only digits and + - / * allowed";
	    }
		else {
			result = "All checks passed...";

		}
		log.info("Evaluating complete!");

		return result + " input:" +expr;

    }
}