package com.db.testRunner;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.db.stepdefinitions.DBCareerDefinitions;
import com.db.utils.ConfigReader;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
				 glue = {"com.db.stepdefinitions"},
						// "com.db.hooks"},
				 plugin = {"pretty", "html:target/test-output/report.html"},
				 //tags = "@sanity"
				 tags = "@Test2"
				// ,dryRun=true
				 //monochrome=true
				)
public class SanityRunner extends AbstractDBTestNGRunner{
	
	
}
