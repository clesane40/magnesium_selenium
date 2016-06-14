package com.riverbed.webdriver;

import org.testng.TestNG;;

public class MainOne {

    public static void main(String[] args) {
        TestNG testng = new TestNG();
         @SuppressWarnings("rawtypes")
		Class[] classes = new Class[]{screenshotonfail.class};
         testng.setTestClasses(classes);
         testng.run();

    }
}