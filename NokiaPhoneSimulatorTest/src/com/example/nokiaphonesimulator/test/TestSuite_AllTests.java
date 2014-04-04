package com.example.nokiaphonesimulator.test;

import junit.framework.Test;
import android.test.suitebuilder.TestSuiteBuilder;

public class TestSuite_AllTests {
    public static Test suite () {
        return new TestSuiteBuilder(TestSuite_AllTests.class)
            .includeAllPackagesUnderHere()
            .build();
    }
}
