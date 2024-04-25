package weatherapi;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines( "cucumber" )
@SelectPackages( "weatherapi" )
@ConfigurationParameter( key = PLUGIN_PROPERTY_NAME, value = "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" )
public class RunCucumberTest {
}

// allure serve ./target/allure-results