package com.stimulsoft.samples;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.stimulsoft.viewer.StiViewerFx;

import com.stimulsoft.lib.io.StiFileUtil;

import com.stimulsoft.base.exception.StiException;
import com.stimulsoft.base.exception.StiExceptionProvider;
import com.stimulsoft.base.localization.StiLocalization;
import com.stimulsoft.base.localization.StiLocalizationInfo;
import com.stimulsoft.base.utils.StiXmlMarshalUtil;

public class Localization extends JPanel {

    private static final Dimension FRAME_SIZE = new Dimension(800, 600);

    public Localization(final JFrame parentFrame) throws FileNotFoundException, StiException {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(FRAME_SIZE);
        JPanel topPanel = new JPanel();
        topPanel.setMaximumSize(new Dimension(800, 25));
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        add(topPanel);
        final List<StiLocalizationInfo> localizations = getLocalizations();

        String[] items = getItem(localizations);
        final JComboBox languagesCombo = new JComboBox(items);
        topPanel.add(languagesCombo);
        JButton button = new JButton("Show localed viewer");
        topPanel.add(button);
        final JPanel mainPanel = this;

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (mainPanel.getComponentCount() == 2) {
                    mainPanel.remove(1);
                }
                String fileName = localizations.get(languagesCombo.getSelectedIndex())
                                               .getCultureName() + ".xml";
                setLocalization(fileName);
                StiViewerFx viewerPanel = new StiViewerFx(parentFrame);
                mainPanel.add(viewerPanel);
                SwingUtilities.updateComponentTreeUI(mainPanel);
            }
        });
    }

    private String[] getItem(List<StiLocalizationInfo> localizations) {
        String[] resul = new String[localizations.size()];
        for (int i = 0; i < localizations.size(); i++) {
            resul[i] = localizations.get(i).getDescription();
        }
        return resul;
    }

    public List<StiLocalizationInfo> getLocalizations() throws StiException, FileNotFoundException {
        List<StiLocalizationInfo> list = new ArrayList<StiLocalizationInfo>();
        File localizationDir = getLocalizationDir();
        if (localizationDir.exists()) {
            Iterator<File> iterateLocalization = StiFileUtil.iterateFiles(localizationDir,
                    new String[] { "xml" }, false);
            for (; iterateLocalization.hasNext();) {
                File fileLoc = iterateLocalization.next();
                InputStream is = new BufferedInputStream(new FileInputStream(fileLoc));
                StiLocalizationInfo localization = StiXmlMarshalUtil.unmarshal(is,
                        StiLocalizationInfo.class);
                localization.setKey(fileLoc.getName());
                list.add(localization);
            }
        }
        return list;
    }

    protected File getLocalizationDir() {
        return new File("Localization");
    }

    public void setLocalization(String fileName) {
        try {
            File file = new File(getLocalizationDir(), fileName);
            StiLocalization localization = StiLocalization.load(new BufferedInputStream(
                    new FileInputStream(file)));
            StiLocalization.setLocalization(localization);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame frame = new JFrame();
                    frame.add(new Localization(frame));
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
