package com.stimulsoft;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

import com.stimulsoft.flex.StiLoadAction;
import com.stimulsoft.report.StiReport;
import com.stimulsoft.report.StiSerializeManager;
import com.stimulsoft.report.dictionary.databases.StiXmlDatabase;

/**
 * MyLoadAction.
 * 
 * Copyright Stimulsoft
 * 
 */
public class MyLoadAction extends StiLoadAction {

    @Override
    public InputStream load(String repotrName) {
        try {
            StiReport report = StiSerializeManager.deserializeReport(new File(repotrName));
            StiXmlDatabase xmlDatabase = new StiXmlDatabase("Demo", "/Data/Demo.xsd", "/Data/Demo.xml");
            report.getDictionary().getDatabases().add(xmlDatabase);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            StiSerializeManager.serializeReport(report, out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
