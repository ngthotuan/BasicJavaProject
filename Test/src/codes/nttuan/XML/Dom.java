package codes.nttuan.XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Dom {
    public static void readStudent(String path) throws ParserConfigurationException, IOException, SAXException {
        File file = new File(path);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);

        Element root = document.getDocumentElement();
        NodeList studentList = root.getElementsByTagName("student");
        for(int i =0; i < studentList.getLength(); i++){
            Node student = studentList.item(i);
            if(student.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) student;
                System.out.println("element.getTagName() = " + element.getTagName());
                System.out.println(element.getAttribute("id"));
                System.out.println(((Element) student).getElementsByTagName("name").item(0).getTextContent());
            }
        }
    }

    public static void main(String[] args) {
        String path = "data/students.xml";

        try {
            readStudent(path);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}
