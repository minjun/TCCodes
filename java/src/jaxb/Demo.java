package jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Demo {
	public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Command.class, E911Payload.class);
 
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File file = new File("e911command.xml");
        Command message = (Command) unmarshaller.unmarshal(file);
        E911Payload payload = (E911Payload)message.getPayload();
        System.out.println(payload.getDetail().getAddress().getHno());
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
       // marshaller.marshal(message, System.out);

    }
}
