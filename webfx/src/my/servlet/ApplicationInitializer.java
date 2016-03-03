package my.servlet;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import my.actions.MyLoadAction;
import my.actions.MyLoadDataAction;
import my.actions.MyLocalizationAction;
import my.actions.MyMailAction;
import my.actions.MyRenderReportAction;
import my.actions.MySaveAction;

import com.stimulsoft.base.exception.StiException;
import com.stimulsoft.flex.StiFlexConfig;

/**
 * Application initialization.
 */
public class ApplicationInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(final ServletContextEvent event) {
        try {
            // configuration application
            StiFlexConfig stiConfig = initConfig();
            // Setup custom properties
            // stiConfig.getProperties().setProperty("Engine.Type", "Flex");
            // ---------------------------------------------------------
            // need to override the standard methods
            // another comment
            stiConfig.setLoadClass(MyLoadAction.class);
            stiConfig.setSaveClass(MySaveAction.class);
            stiConfig.setLoadDataClass(MyLoadDataAction.class);
            stiConfig.setMailAction(MyMailAction.class);
            stiConfig.setLocalizationAction(MyLocalizationAction.class);
            stiConfig.setRenderReportAction(MyRenderReportAction.class);
            // ---------------------------------------------------------
            // stiConfig.getProperties().getProperty("Engine.Type")
            StiFlexConfig.init(stiConfig);

            // set variable in servlet context attribute
            // Map<String, String> myVariableMap = new HashMap<String, String>();
            // myVariableMap.put("Variable1", "myVariableMap");
            // event.getServletContext().setAttribute("myMap", myVariableMap);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void contextDestroyed(final ServletContextEvent event) {
        // empty
    }

    public StiFlexConfig initConfig() throws StiException, IOException {
        // Properties properties = new Properties();
        // load your own Properties;
        // InputStream inStream = getClass().getResourceAsStream("RESOURCE_PATH");
        // properties.load(inStream);
        // return new StiFlexConfig(properties);
        return new StiFlexConfig();
    }

}
