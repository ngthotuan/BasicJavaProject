import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JDomParser {

    public static ArrayList<Student> readStudentFromXmlFile(File file) throws JDOMException, IOException {

        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(file);
        Element rootElement = document.getRootElement();
        List<Element> listStudent = rootElement.getChildren();

        ArrayList<Student> studentArrayList = new ArrayList<>();
        for(Element e : listStudent){
            Student student = new Student();
            student.setId(e.getAttribute("id").getValue());
            student.setName(e.getChildText("name"));
            student.setCode(Integer.parseInt(e.getChildText("code")));
            student.setAge(Integer.parseInt(e.getChildText("age")));
            studentArrayList.add(student);
        }
        return studentArrayList;
    }

    public static void createXmlFileFromListStudent(List<Student> studentList, String fileOutName) throws IOException {
        //Root Element
        Element students = new Element("students");
        Document document = new Document(students);

        //
        for(Student st : studentList){
            Element student = new Element("student");
            student.setAttribute("id", st.getId());
            student.addContent(new Element("name").setText(st.getName()));
            student.addContent(new Element("code").setText(String.valueOf(st.getCode())));
            student.addContent(new Element("age").setText(String.valueOf(st.getAge())));
            students.addContent(student);
        }

        XMLOutputter xmlOutput = new XMLOutputter();
        xmlOutput.setFormat(Format.getPrettyFormat());
        xmlOutput.output(document, new BufferedWriter(new FileWriter(new File(fileOutName))));
    }
    
    
    public static void main(String[] args) {
        List<Student> listStudents = null;
        try {
            listStudents = readStudentFromXmlFile(new File("students.xml"));
            System.out.println(listStudents);
        } catch (JDOMException e) {
            System.err.println("Dinh dang file khong ho tro: "+ e.getMessage());
        } catch (IOException e) {
            System.err.println("Loi doc file: " + e.getMessage());
        }

        try {
            createXmlFileFromListStudent(listStudents, "outstudent.xml");
        } catch (IOException e) {
            System.err.println("Khong the tao file: " + e.getMessage());
        }

        // ví dụ chỉnh sửa nội dung tệp  outstudent.xml
        // sửa id của student id="1" thành "one" và thêm cho student này 1 thẻ email là: "one@domain.com"
        // sửa name của student id="2" thành "Harry" và xóa thẻ code của student này
        String fileName = "outstudent.xml";
        try {
            Document document = new SAXBuilder().build(new File(fileName));
            
            Element students = document.getRootElement();
            List<Element> studentList = students.getChildren();

            for(Element student : studentList){
                String id = student.getAttribute("id").getValue();
                if(id.equals("1")){
                    student.setAttribute("id", "one");
                    student.addContent(new Element("email").setText("name@domain.com"));
                }
                else if(id.equals("2")){
                    student.getChild("name").setText("Harry");
                    student.removeChild("code");
                }
            }

            XMLOutputter outXml = new XMLOutputter();
            outXml.setFormat(Format.getPrettyFormat());
            outXml.output(document, new FileOutputStream(fileName));
            
        } catch (JDOMException e) {
            System.err.println("Dinh dang file khong ho tro: "+ e.getMessage());
        } catch (IOException e) {
            System.err.println("Loi doc file: " + e.getMessage());
        }


    }
}
