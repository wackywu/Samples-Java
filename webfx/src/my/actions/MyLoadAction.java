package my.actions;

import java.io.InputStream;

import com.stimulsoft.flex.StiLoadAction;
import com.stimulsoft.flex.StiResourceFlex;

/**
 * MyLoadAction.
 * 
 * Copyright Stimulsoft
 * 
 */
public class MyLoadAction extends StiLoadAction {

    @Override
    public InputStream load(String repotrName) {
        System.out.println("must override this method to specify your own load repotr");
        if (repotrName.contains("mrt")) {
            return new StiResourceFlex().getDemoMrt();
        } else {
            return new StiResourceFlex().getDemoMdc();
        }
    }

}
