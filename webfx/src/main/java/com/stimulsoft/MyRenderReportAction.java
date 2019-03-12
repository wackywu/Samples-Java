package com.stimulsoft;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.stimulsoft.base.exception.StiException;
import com.stimulsoft.flex.StiRenderReportAction;
import com.stimulsoft.report.StiCustomFunction;
import com.stimulsoft.report.StiReport;

/**
 * MyRenderReportAction.
 * 
 * Copyright Stimulsoft
 * 
 */
public class MyRenderReportAction extends StiRenderReportAction {

    @Override
    public StiReport render(StiReport report) throws IOException, StiException {
        // Add custom function
        report.getCustomFunctions().add(new StiCustomFunction() {
            public Object invoke(List<Object> args) {
                return ((String) args.get(0)).substring(((Long) args.get(1)).intValue(), ((Long) args.get(2)).intValue());
            }

            @SuppressWarnings({ "rawtypes" })
            public List<Class> getParametersList() {
                return new ArrayList<Class>(Arrays.asList(String.class, Long.class, Long.class));
            }

            public String getFunctionName() {
                return "subStr";
            }
        });
        return super.render(report);
    }

}
