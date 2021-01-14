import javax.swing.*;
import java.awt.*;

public class Test {
    public static void main(String[] args) {
        JPanel panel = new JPanel();
        JButton c1 =  new JButton("c1");
        JButton c2 =  new JButton("c2");
        JButton c3 =  new JButton("c3");
        JButton c4 =  new JButton("Xin chào");

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.linkSize(c3, c4);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(c1)
                        .addComponent(c2)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(c3)
                                .addComponent(c4))
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(c1)
                                .addComponent(c2)
                                .addComponent(c3))
                        .addComponent(c4)
        );

        JFrame frame = new JFrame();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
