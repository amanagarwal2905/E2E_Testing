package Utility;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener {

	public void onTestFailure(ITestResult Result) {
		// TODO Auto-generated method stub                
		System.out.println("Test Failed: Movie Details Didn't Match - "+ Result.getName());
	}
	public void onTestSkipped(ITestResult Result) {
		// TODO Auto-generated method stub                
		System.out.println("Test Skipped :" + Result.getName());
	}
	public void onTestSuccess(ITestResult Result) {
		// TODO Auto-generated method stub        
		System.out.println("Test Success :"+ Result.getName());
	}
}