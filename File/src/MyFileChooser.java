import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileView;
import java.io.File;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
public class MyFileChooser extends JFileChooser
{
    private String extension;
    private String title;
    public MyFileChooser(String extension, String title)
    {
        super();
        this.extension = extension;
        this.title = title;
        addChoosableFileFilter(new FileNameExtensionFilter(String.format("(*.%1$s) Chỉ đọc file định dạng  %1$s thôi nhé", extension), extension));
        //setPreferredSize(new Dimension(450, 350));
    }

    @Override public String getDialogTitle()
    {
        return title;
    }

    @Override public File getSelectedFile()
    {
        File selectedFile = super.getSelectedFile();
        if(selectedFile != null)
        {
            String name = selectedFile.getName();
            if(!name.contains(".")) selectedFile = new File(selectedFile.getParentFile(), name + '.' + extension);
        }
        return selectedFile;
    }
}