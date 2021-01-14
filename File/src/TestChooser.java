import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;


public class TestChooser extends JFrame implements ActionListener {

    public MyFileChooser chooser;
    public TestChooser()
    {
        super("Main Frame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        try{ UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch(Exception e){ System.out.println("Unable to load Windows look and feel");}
        setPreferredSize(new Dimension(300, 100));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13) );
        setLayout(new FlowLayout());
        JButton btn = new JButton("Open");
        btn.setActionCommand("myButton");
        btn.addActionListener(this);
        add(btn);
        JPanel panel = new JPanel();

        UIManager.put("FileChooser.saveButtonText", "saveButtonText");
        UIManager.put("FileChooser.openButtonText", "openButtonText");
        UIManager.put("FileChooser.cancelButtonText", "cancelButtonText");
        UIManager.put("FileChooser.updateButtonText", "updateButtonText");
        UIManager.put("FileChooser.helpButtonText", "helpButtonText");
        UIManager.put("FileChooser.saveButtonToolTipText", "saveButtonToolTipText");
        UIManager.put("FileChooser.openButtonToolTipText", "openButtonToolTipText");
        UIManager.put("FileChooser.cancelButtonToolTipText", "cancelButtonToolTipText");
        UIManager.put("FileChooser.updateButtonToolTipText", "updateButtonToolTipText");
        UIManager.put("FileChooser.helpButtonToolTipText", "helpButtonToolTipText");
        UIManager.put("FileChooser.listViewButtonToolTipText", "listViewButtonToolTipText");
        UIManager.put("FileChooser.lookInLabelText", "lookInLabelText");
        UIManager.put("FileChooser.newFolderToolTipText", "newFolderToolTipText");
        UIManager.put("FileChooser.fileNameLabelText", "fileNameLabelText");
        UIManager.put("FileChooser.filesOfTypeLabelText", "filesOfTypeLabelText");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "detailsViewButtonToolTipText");
        UIManager.put("FileChooser.upFolderToolTipText", "upFolderToolTipText");

        chooser = new MyFileChooser("csv", "Chọn File");
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setFileHidingEnabled(false);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("myButton"))
        {
            int status = chooser.showOpenDialog(null);
            // blah blah
            System.out.println(status);
        }
    }
    public static void main(String[] args)
    {
        new TestChooser();
    }
}
