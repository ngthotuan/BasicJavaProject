import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class XPathParser {

    public static ArrayList<Student> readStudentsFromXmlFile(File file) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        //Tạo đối tượng document
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);

        //Tạo đối tượng XPath
        XPath xPath = XPathFactory.newInstance().newXPath();

        //Viết biểu thức expression
        String expression = "/students/student[age > 18]";

        //compile expression
        NodeList listStudent = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);

        ArrayList<Student> studentArrayList = new ArrayList<>();
        for(int i =0; i < listStudent.getLength(); i++){
            Node node = listStudent.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element student = (Element)node;
                Student st = new Student();
                // Lấy thuộc tính id của student thứ i
                st.setId(student.getAttribute("id"));
                // Lấy nội dung các thẻ trong student thứ i
                st.setName(student.getElementsByTagName("name").item(0).getTextContent());
                st.setCode(Integer.parseInt(student.getElementsByTagName("code").item(0).getTextContent()));
                st.setAge(Integer.parseInt(student.getElementsByTagName("age").item(0).getTextContent()));

                studentArrayList.add(st);
            }
        }
        return studentArrayList;
    }
    public static void main(String[] args) {
        List<Student> studentList = null;
        try {
            studentList = readStudentsFromXmlFile(new File("students.xml"));
            System.out.println(studentList);
        } catch (ParserConfigurationException | IOException | SAXException | XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}
