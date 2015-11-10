package com.impetus.BDD;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions( monochrome = true,features = "src/test/resources/ServiceAggregator_Registration.feature", glue ="com.impetus.BDD.step")
public class BddTestRunner {

}