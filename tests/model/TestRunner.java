package model;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String args[]) {
        Result result = JUnitCore.runClasses(ModelTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("passed = " + result.getRunCount() + "out of" + result.getRunCount());
        } else {
            System.out.println("failed = " + result.getFailureCount() + "out of" + result.getRunCount());
        }
    }
}