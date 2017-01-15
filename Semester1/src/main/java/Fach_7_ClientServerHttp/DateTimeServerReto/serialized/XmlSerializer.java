package Fach_7_ClientServerHttp.DateTimeServerReto.serialized;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;

public class XmlSerializer {

    public String serialize(Object obj) throws IOException {
        XmlMapper mapper = new XmlMapper();
        String serialized = mapper.writeValueAsString(obj);
        System.out.println("Serialized: " +serialized.toString());
        //Files.write(Paths.get(fileName), serialized.getBytes(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
        return serialized;
    }

//    public <T> T deserialize(String fileName, TypeReference<T> ref) throws IOException {
//        XmlMapper mapper = new XmlMapper();
//        return mapper.readValue(new File(fileName), ref);
//    }
}