package com.stimulsoft.samples;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.stimulsoft.base.exception.StiExceptionProvider;
import com.stimulsoft.viewer.StiViewerFx;

public class Viewer extends JPanel {
    private static final Dimension FRAME_SIZE = new Dimension(800, 800);

    public Viewer(final JFrame parentFrame) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(FRAME_SIZE);
        final JButton button = new JButton("Add viewer");
        add(button);
        final JPanel mainPanel = this;
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StiViewerFx viewerPanel = new StiViewerFx(parentFrame);
                mainPanel.add(viewerPanel);
                SwingUtilities.updateComponentTreeUI(mainPanel);
                button.getParent().remove(button);
            }
        });
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame frame = new JFrame();
                    frame.add(new Viewer(frame));
                    frame.setSize(FRAME_SIZE);
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                } catch (Throwable e) {
                    StiExceptionProvider.show(e, null);
                }
            }
        });
    }
}
