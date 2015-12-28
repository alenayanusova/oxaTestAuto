package base.listeners;

import base.BaseTest;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class CustomTestListenerAdapter extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult tr) {
        BaseTest.makeScreenshot();
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        BaseTest.makeScreenshot();
    }
}