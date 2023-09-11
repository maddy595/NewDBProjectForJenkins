package com.db.testRunner;

import java.io.IOException;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
				 glue = {"com.db.stepdefinitions"},
						// "com.db.hooks"},
				 plugin = {"pretty", "html:target/test-output/report.html"},
				 tags = "@smoke"
				// tags="@Test10"
				// monochrome=true
				)
public class SmokeRunner extends AbstractDBTestNGRunner{
	
}
