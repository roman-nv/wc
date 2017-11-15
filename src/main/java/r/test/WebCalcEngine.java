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
        String result="";
        float a,c;


        boolean b = Pattern.matches("^[0-9]+[+-/*]{1}[0-9]+$", expr);
        log.info("Evaluating string [" + expr + "]");
		if (expr.length() < 3) {
			result = "Input string must contain at least 3 chars";

        }
		else if (!b) {
			result = "Input string contains wrong symbols. Only digits and + - / * allowed";
	    }
		else {

	        String patternString = "[+-/*]{1}";
	        Pattern pattern = Pattern.compile(patternString);
	        String[] split = pattern.split(expr);

	        a = Float.parseFloat(split[0]);
            c = Float.parseFloat(split[1]);
/*
	        for(String element : split){
	            result += element;
	        }
*/
	        if (expr.indexOf('+') != -1) {
	            result = Float.toString(a+c);
	        }
	        else if (expr.indexOf('-') != -1) {
	        	result = Float.toString(a-c);
	        }
	        else if (expr.indexOf('/') != -1) {
	        	result = Float.toString(a/c);
	        }
	        else {
	        	result = Float.toString(a*c);

	        }
		}
		log.info("Evaluation complete!");
		return result;

    }
}