package com.stimulsoft.samples;

import java.awt.Dimension;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.stimulsoft.viewer.StiViewerFx;

import com.stimulsoft.base.exception.StiExceptionProvider;

public class TableReports extends JPanel {

    private static final Dimension FRAME_SIZE = new Dimension(800, 800);

    public TableReports(final JFrame parentFrame) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(FRAME_SIZE);
        JLabel label = new JLabel("Click on table below to display nessesary report");
        add(label);
        label.setAlignmentX(CENTER_ALIGNMENT);
        String[] columnNames = { "Report name", "Report date", "Report owner" };

        final Object[][] data = { { "Simple List 1", "10.01.2012", "John Smith" },
                { "Simple List 2", "13.11.2012", "Sue Black" },
                { "Simple List 3", "01.09.2012", "Joe Brown" } };
        final JTable table = new JTable(data, columnNames);
        table.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(table.getTableHeader());
        add(table);

        final StiViewerFx viewer = new StiViewerFx(parentFrame);
        add(viewer);

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    viewer.getStiViewModel().loadDocumentFile(
                            new File("Reports", data[selectedRow][0] + ".mdc"), true);
                }
            }
        });
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame frame = new JFrame();
                    frame.add(new TableReports(frame));
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
