package ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import java.util.List;
import java.util.ArrayList;

@WebService
public class HelloWs {
	@WebMethod
	public String sayHello(String name) {
		if (name == null) {
			return "Hello";
		}

		return "Hello, " + name + "!";
	}

	@WebMethod
	public List<String> rtnMethod() {
		List<String> testList = new ArrayList<String>();
		testList.add("abc");
		testList.add("efg");
		testList.add("111");
		return testList;
	}

}