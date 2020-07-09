import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParse {

    public static ArrayList<Student> readStudentFromXmlFile(File file) throws ParserConfigurationException, IOException, SAXException {
        // Khởi tạo đối tượng Document chứa thông tin của tập tin XML từ file:
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        // Truy xuất phần tử gốc:
        Element students = document.getDocumentElement();
        // Sử dụng các phương thức có sẵn để đọc nội dung tệp tin theo định dạng
        ArrayList<Student> studentArrayList = new ArrayList<>();
        // Lấy ListStudent trong Student Root
        NodeList listStudent = students.getElementsByTagName("student");
        // Duyệt qua từng phần tử của list;
        for(int i =0; i < listStudent.getLength(); i++){
            Node node = listStudent.item(i); // Lây phần tử thứ i của listStudent
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

    private static Document createDocumentFromList(List<Student> studentList) throws ParserConfigurationException {
        // Khởi tạo đối tượng Document
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        // Tạo phần tử gốc
        Element students = document.createElement("students");
        document.appendChild(students);
        // Ghi các student items vào students
        for(Student st : studentList){
            Element student = document.createElement("student");
            student.setAttribute("id", st.getId());
            //Các thẻ con của student: name, code, age
            Element name = document.createElement("name");
            name.appendChild(document.createTextNode(st.getName()));
            student.appendChild(name);
            Element code = document.createElement("code");
            code.appendChild(document.createTextNode(String.valueOf(st.getCode())));
            student.appendChild(code);
            Element age = document.createElement("age");
            age.appendChild(document.createTextNode(String.valueOf(st.getAge())));
            student.appendChild(age);

            students.appendChild(student);
        }
        return document;
    }

    private static void writeFileXml(Document document, String fileOutName) throws TransformerException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File(fileOutName));
        transformer.transform(source, result);
    }

    public static void createXmlFileFromListStudent(List<Student> students, String fileOutName) throws ParserConfigurationException, TransformerException {
        Document document = createDocumentFromList(students);
        writeFileXml(document, fileOutName);
    }

    public static void main(String[] args) {
        List<Student> students = null;
        try {
             students = readStudentFromXmlFile(new File("students.xml"));
            System.out.println(students);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        try {
            createXmlFileFromListStudent(students, "outStudent.xml");
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }

        // ví dụ chỉnh sửa nội dung tệp  outstudent.xml
        // sửa id của student id="1" thành "one" và thêm cho student này 1 thẻ email là: "one@domain.com"
        // sửa name của student id="2" thành "Harry" và xóa thẻ code của student này
        String fileName = "outStudent.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        File f = new File(fileName);
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(f);

            NodeList listStudent = document.getDocumentElement().getChildNodes();
            for(int i =0 ; i < listStudent.getLength(); i++){
                Node node = listStudent.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element student = (Element)node;
                    // sửa id của student id="1" thành "one" và thêm cho student này 1 thẻ email là: "one@domain.com"
                    if(student.getAttribute("id").equals("1")){
                        student.setAttribute("id", "one");
                        Element email = document.createElement("email");
                        email.appendChild(document.createTextNode("one@domain.com"));
                        student.appendChild(email);
                    }
                    // sửa name của student id="2" thành "Harry" và xóa thẻ code của student này
                    else if(student.getAttribute("id").equals("2")){
                        Node name = student.getElementsByTagName("name").item(0);
                        name.setTextContent("Harry");
                        Node code = student.getElementsByTagName("code").item(0);
                        student.removeChild(code);
                    }
                }
            }

            // Ghi lại vào file
            writeFileXml(document, "outStudentEdit.xml");

        } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
