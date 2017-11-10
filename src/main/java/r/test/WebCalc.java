package r.test;

import javax.jws.WebService;

import javax.jws.WebMethod;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@WebService
public interface WebCalc {

	String Compute(String expr);

}