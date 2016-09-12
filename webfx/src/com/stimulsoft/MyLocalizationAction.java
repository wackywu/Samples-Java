package com.stimulsoft;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.stimulsoft.base.exception.StiException;
import com.stimulsoft.base.localization.StiLocalizationInfo;
import com.stimulsoft.base.utils.StiXmlMarshalUtil;
import com.stimulsoft.flex.StiLocalizationAction;
import com.stimulsoft.lib.io.StiFileUtil;

/**
 * MyLocalizationAction.
 * 
 * Copyright Stimulsoft
 * 
 */
public class MyLocalizationAction extends StiLocalizationAction {

    @Override
    public List<StiLocalizationInfo> getLocalizations() throws StiException, FileNotFoundException {
        List<StiLocalizationInfo> list = new ArrayList<StiLocalizationInfo>();
        File localizationDir = getLocalizationDir();
        if (localizationDir.exists()) {
            Iterator<File> iterateLocalization = StiFileUtil.iterateFiles(localizationDir, new String[] { "xml" }, false);
            for (; iterateLocalization.hasNext();) {
                File fileLoc = iterateLocalization.next();
                InputStream is = new BufferedInputStream(new FileInputStream(fileLoc));
                StiLocalizationInfo localization = StiXmlMarshalUtil.unmarshal(is, StiLocalizationInfo.class);
                localization.setKey(fileLoc.getName());
                list.add(localization);
            }
        }
        return list;
    }

    @Override
    protected File getLocalizationDir() {
        return new File("Localization");
    }

    @Override
    public InputStream getLocalization(String key) throws StiException, FileNotFoundException {
        File file = new File(getLocalizationDir(), key);
        return new BufferedInputStream(new FileInputStream(file));
    }

}
