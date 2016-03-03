package com.stimulsoft.samples;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.stimulsoft.base.exception.StiExceptionProvider;
import com.stimulsoft.viewer.StiViewerFx;

public class ViewerPopup extends JPanel {

    private static final Dimension FRAME_SIZE = new Dimension(800, 800);

    public ViewerPopup(final JFrame parentFrame) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        JButton button = new JButton("Show popup viewer");
        add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StiViewerFx viewerPanel = new StiViewerFx(parentFrame);
                JDialog popup = viewerPanel.createPopup(parentFrame, true);
                popup.setVisible(true);
            }
        });
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame frame = new JFrame();
                    frame.add(new ViewerPopup(frame));
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
