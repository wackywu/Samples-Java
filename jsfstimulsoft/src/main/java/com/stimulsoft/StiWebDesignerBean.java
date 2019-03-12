package com.stimulsoft;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.stimulsoft.report.StiCustomFunction;
import com.stimulsoft.report.StiReport;
import com.stimulsoft.report.StiSerializeManager;
import com.stimulsoft.report.dictionary.StiDataColumn;
import com.stimulsoft.report.dictionary.StiDataColumnsCollection;
import com.stimulsoft.report.dictionary.dataSources.StiDataTableSource;
import com.stimulsoft.report.dictionary.databases.StiXmlDatabase;
import com.stimulsoft.report.utils.data.StiDataColumnsUtil;
import com.stimulsoft.report.utils.data.StiSqlField;
import com.stimulsoft.report.utils.data.StiXmlTable;
import com.stimulsoft.report.utils.data.StiXmlTableFieldsRequest;
import com.stimulsoft.web.classes.StiRequestParams;
import com.stimulsoft.webdesigner.StiWebDesigerHandler;
import com.stimulsoft.webdesigner.StiWebDesignerOptions;

/**
 * Copyright Stimulsoft
 */

public class StiWebDesignerBean {
    StiWebDesignerOptions options;
    String designerID = "StimulsoftWebDesigner";

    /**
     * @return the handler
     */
    public StiWebDesigerHandler getHandler() {
        StiWebDesigerHandler handler = new StiWebDesigerHandler() {
            public StiReport getEditedReport(HttpServletRequest request) {
                try {
                    String reportPath = request.getSession().getServletContext().getRealPath("/reports/Master-Detail.mrt");
                    String xmlPath = request.getSession().getServletContext().getRealPath("/data/Demo.xml");
                    String xsdPath = request.getSession().getServletContext().getRealPath("/data/Demo.xsd");
                    StiReport report = StiSerializeManager.deserializeReport(new File(reportPath));
                    report.getDictionary().getDatabases().add(new StiXmlDatabase("Demo", xsdPath, xmlPath));
                    report.getCustomFunctions().add(new StiCustomFunction() {
                        public Object invoke(List<Object> args) {
                            return ((String) args.get(0)).substring(((Long) args.get(1)).intValue(), ((Long) args.get(2)).intValue());
                        }

                        @SuppressWarnings({ "rawtypes", "unchecked" })
                        public List<Class> getParametersList() {
                            return new ArrayList<Class>(Arrays.asList(String.class, Long.class, Long.class));
                        }

                        public String getFunctionName() {
                            return "subStr";
                        }
                    });
                    return report;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            public void onOpenReportTemplate(StiReport report, HttpServletRequest request) {
                String xmlPath = request.getSession().getServletContext().getRealPath("/data/Demo.xml");
                String xsdPath = request.getSession().getServletContext().getRealPath("/data/Demo.xsd");
                report.getDictionary().getDatabases().add(new StiXmlDatabase("Demo", xsdPath, xmlPath));
            }

            public void onNewReportTemplate(StiReport report, HttpServletRequest request) {
                String xmlPath = request.getSession().getServletContext().getRealPath("/data/Demo.xml");
                String xsdPath = request.getSession().getServletContext().getRealPath("/data/Demo.xsd");
                report.getDictionary().getDatabases().add(new StiXmlDatabase("Demo", xsdPath, xmlPath));
                try {
                    StiXmlTableFieldsRequest tables = StiDataColumnsUtil.parceXSDSchema(new FileInputStream(xsdPath));
                    for (StiXmlTable table : tables.getTables()) {
                        StiDataTableSource tableSource = new StiDataTableSource("Demo." + table.getName(), table.getName(), table.getName());
                        tableSource.setColumns(new StiDataColumnsCollection());
                        for (StiSqlField field : table.getColumns()) {
                            StiDataColumn column = new StiDataColumn(field.getName(), field.getName(), field.getSystemType());
                            tableSource.getColumns().add(column);
                        }
                        tableSource.setDictionary(report.getDictionary());
                        report.getDictionary().getDataSources().add(tableSource);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onSaveReportTemplate(StiReport report, String reportName, HttpServletRequest request) {
                try {
                    String savePath = request.getSession().getServletContext().getRealPath("/save/");
                    FileOutputStream fos = new FileOutputStream(savePath + reportName);
                    StiSerializeManager.serializeReport(report, fos);
                    fos.flush();
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

			@Override
			public void onSaveReportTemplate(StiReport report, StiRequestParams requestParams,
					HttpServletRequest request) {
				// TODO Auto-generated method stub
				
			}
        };
        return handler;
    }

    /**
     * @return the options
     */
    public StiWebDesignerOptions getOptions() {
        options = new StiWebDesignerOptions();
        return options;
    }

    /**
     * @return the designerID
     */
    public String getDesignerID() {
        return designerID;
    }
}
