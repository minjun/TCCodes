
package client.ws;

import java.util.List;
import java.util.concurrent.Future;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HelloWs", targetNamespace = "http://ws/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HelloWs {


    /**
     * 
     * @param arg0
     * @return
     *     returns javax.xml.ws.Response<client.ws.SayHelloResponse>
     */
    @WebMethod(operationName = "sayHello")
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://ws/", className = "client.ws.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://ws/", className = "client.ws.SayHelloResponse")
    public Response<SayHelloResponse> sayHelloAsync(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "sayHello")
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://ws/", className = "client.ws.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://ws/", className = "client.ws.SayHelloResponse")
    public Future<?> sayHelloAsync(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<SayHelloResponse> asyncHandler);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://ws/", className = "client.ws.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://ws/", className = "client.ws.SayHelloResponse")
    @Action(input = "http://ws/HelloWs/sayHelloRequest", output = "http://ws/HelloWs/sayHelloResponse")
    public String sayHello(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @return
     *     returns javax.xml.ws.Response<client.ws.RtnMethodResponse>
     */
    @WebMethod(operationName = "rtnMethod")
    @RequestWrapper(localName = "rtnMethod", targetNamespace = "http://ws/", className = "client.ws.RtnMethod")
    @ResponseWrapper(localName = "rtnMethodResponse", targetNamespace = "http://ws/", className = "client.ws.RtnMethodResponse")
    public Response<RtnMethodResponse> rtnMethodAsync();

    /**
     * 
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "rtnMethod")
    @RequestWrapper(localName = "rtnMethod", targetNamespace = "http://ws/", className = "client.ws.RtnMethod")
    @ResponseWrapper(localName = "rtnMethodResponse", targetNamespace = "http://ws/", className = "client.ws.RtnMethodResponse")
    public Future<?> rtnMethodAsync(
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<RtnMethodResponse> asyncHandler);

    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "rtnMethod", targetNamespace = "http://ws/", className = "client.ws.RtnMethod")
    @ResponseWrapper(localName = "rtnMethodResponse", targetNamespace = "http://ws/", className = "client.ws.RtnMethodResponse")
    @Action(input = "http://ws/HelloWs/rtnMethodRequest", output = "http://ws/HelloWs/rtnMethodResponse")
    public List<String> rtnMethod();

}