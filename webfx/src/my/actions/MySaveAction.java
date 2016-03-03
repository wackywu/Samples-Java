package my.actions;

import com.stimulsoft.flex.StiSaveAction;
import com.stimulsoft.flex.utils.StiOperationResult;
import com.stimulsoft.flex.utils.StiSaveLoadFileReport;

/**
 * MySaveAction.
 * 
 * Copyright Stimulsoft
 * 
 */
public class MySaveAction extends StiSaveAction {

    @Override
    public StiOperationResult save(String report, String reportName, boolean newReportFlag) {
        System.out.println("must override this method to specify your own save report");
        return new StiSaveLoadFileReport().save(report, reportName, newReportFlag);
    }

}
