package com.stimulsoft;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.stimulsoft.base.exception.StiException;
import com.stimulsoft.flex.StiFlexConfig;

/**
 * Application initialization.
 */
public class ApplicationInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(final ServletContextEvent event) {
        try {
            /*com.stimulsoft.base.licenses.StiLicense.setKey("6vJhGtLLLz2GNviWmUTrhSqnOItdDwjBylQzQcAOiHmdTpNNLNYC5SmErlx8kalRj3Tpz3Q7n0KSIx5FeZwPIkl3Gm"
                    + "MUWe0X9q3lDh4/An8Eal8Cdu9+cxt4MA+TELz2m3Z5VBBjN1/XDAO+GQPJ5yw92sJSJNVdYMFKnjzHDAICPHlRZrUP"
                    + "+7byVoZqOYMMfas8oJiFavGjIbjlFG1BwhMNCKMa4H0f93ehhnZNBmH/lstCzBtojK/dwh5HtBSUV2nEIQ+kIz2m4m"
                    + "Cher2PuoD1lANnArhoBkfdb1y7UiNvMK34Fb2pZpCiUdGP3aBC40aZpqILVSUQ79A4nVghyrc0DHOdtcp677HSGoR8"
                    + "Qooezs9YJMJx8438LsQdzl1jhqkUc0W2euM5hbMf57RWjQHIJXyn6CmjBiXVNRDwKuikphRvZ4QKTaGpcxmsdDh0Aq"
                    + "Q/PllbHvFjk1LG5UwhcfKOJET9M6keMF8xoUa5asm/puYil6o9XZd/zbrqQm7rYpoOLo2XF4u+YjX0hHP1hFtUiOhU"
                    + "n0ekuMCv9GOr5JFqrJXEDoIKoHTr2TuGKRRP7wmz9qsU/Q+y8JP1o1a5TBqoBidVlVwSGEQnhcQUILgoGzB+RWCBgg"
                    + "K1VrkpT38izvy5Xjh6fpMAPc7hr5p6IaHfr5oSVS1OqyWGxR/vgrzxx2rrCjIM4eNIiAQ4Tcy/lbTyI3UwOyysWi+P"
                    + "+bX9lZ3NuzJix2CJb8EmbWHMIfhNAmLeP8EBqEoguFnaUjw46bNp4anPZgRVhQH+OauO9XMkaPfBMAXRk9ygM0v67s"
                    + "qGLayeJ23rqPWTBi60NpB6jydFNkyV7zZmbnrkJExCQmi+zP5mUWEzOTYVsUyKccDOqpZ829/8+8GfcvrnbhGgYK+/"
                    + "13wNfxmPz33DBAWzZjgC5pBFq72N8wRJq3qBHIcFA1WTxpgwa5coqEC3zCihz0lQeff+hde5JU+uXSOeIuTyi7MitK"
                    + "r1X1a7P5+13ApOYy0xmdtpWnpO9O3uw0qQGH5uZi0Ha+3abjKNrWR+dPI8Kb6ZGTuYt22Wf4rJzPuj1uxc5pqT8MOi"
                    + "+Lbkc8W+EGZ5VV5F2FAkAknhauv3q7Yg8cwPu3hH37rC/NTneH9z9eYAVtr+Yfcg6ljusEHM6dixwC+UCWzhh9Mg1c"
                    + "hdgy0pZ//g2IVYUw1ncW2yHwfB5T27/CDnpgjXXnB0Uzt69+A+DYlQXi3V3r7QE8O2pqnc6v0YysOp72seIjQcbKTc"
                    + "QyxlZWb17DNHnITQTHySzomqk77c0RKmqfqCuxjLmUG1peqRsCDyLV1jtZ9LyqPEKJhiIDezoXl5UOs4IiTeDCcUPK"
                    + "JtKVa2qoDw6evYvAS7GtHsDe714czHjj9F1bue25274Sht7S8pzKVNv0oC");*/

            // configuration application
            StiFlexConfig stiConfig = initConfig();
            // Setup custom properties
            stiConfig.getProperties().setProperty("Engine.Type", "Java");
            stiConfig.getProperties().setProperty("Appearance.DateFormat", "yyyy");
            stiConfig.getProperties().setProperty("Appearance.VariablesPanelColumns", "3");
            // stiConfig.getProperties().setProperty("Designer.Dictionary.AllowModifyConnections",
            // "False");
            // stiConfig.getProperties().setProperty("Designer.Dictionary.AllowModifyDataSources",
            // "False");
            // stiConfig.getProperties().setProperty("Viewer.Toolbar.ShowSendEMailButton", "True");
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
