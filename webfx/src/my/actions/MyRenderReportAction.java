package my.actions;

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
        System.out.println("must override this method to specify your own render report");
        // StiXmlDatabase xmlDatabase = new StiXmlDatabase("Demo", "d:/Demo.xsd", "d:/Demo.xml");
        // report.getDictionary().getDatabases().clear();
        // report.getDictionary().getDatabases().add(xmlDatabase);
        // Add custom function
        report.getCustomFunctions().add(new StiCustomFunction() {
            public Object invoke(List<Object> args) {
                return ((String) args.get(0)).substring((Integer) args.get(1),
                        (Integer) args.get(2));
            }

            @SuppressWarnings({ "rawtypes", "unchecked" })
            public List<Class> getParametersList() {
                return new ArrayList<Class>(Arrays.asList(String.class, Integer.class,
                        Integer.class));
            }

            public String getFunctionName() {
                return "subStr";
            }
        });
        return super.render(report);
    }

}
