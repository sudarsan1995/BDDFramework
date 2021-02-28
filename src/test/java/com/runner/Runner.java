package com.runner;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= {"src/test/java/com/features/OrderProduct.feature"},
		glue= {"com/stepDefinition","com/hooks"},
		dryRun=false,
		monochrome=true,
		strict=true,
		plugin= {"pretty", 
				
		}
		)


public class Runner {

}
