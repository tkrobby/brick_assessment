package randomgenarator

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils

import internal.GlobalVariable

public class random {
	@Keyword
	public static getEmail(String suffix,String prefix){
		int randomNo = (int)(Math.random() * 100000);
		return suffix + randomNo + "@" + prefix;
	}
	@Keyword
	public static getRandomNumber() {
		String charset = '0123456789'
		Integer lengthFour = 4
		def UniqueNumber = RandomStringUtils.random(lengthFour, charset.toCharArray())
		return UniqueNumber;
	}
	@Keyword
	public String getRandomString() {
		String Alpabhat = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTU'
		Integer Length = 6
		def GenarateRandomTring = RandomStringUtils.random(Length, Alpabhat.toCharArray())
		return GenarateRandomTring;
	}
}
