import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.comment(TC_DESC)

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.BASE_URL+"/login")

WebUI.maximizeWindow()

if (TYPE == 'POSITIVE') {
	
	WebUI.setText(findTestObject('Object Repository/OR_LOGIN/FIELD_EMAIL'), GlobalVariable.EMAIL_ALREADY_EXIST, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.setEncryptedText(findTestObject('Object Repository/OR_LOGIN/FIELD_PASSWORD'), 'nwr9I1qT+J0GbQ++JlYjHw==', FailureHandling.STOP_ON_FAILURE)
	
	WebUI.click(findTestObject('Object Repository/OR_LOGIN/BUTTON_LOGIN'), FailureHandling.STOP_ON_FAILURE)
	
	WebUI.delay(2)
	
	WebUI.verifyElementText(findTestObject(OBJECT_REPO), VERIFY_TEXT)
	
	WebUI.closeBrowser()
	
}else if (TYPE == 'NEGATIVE') {
	
	WebUI.setText(findTestObject('Object Repository/OR_LOGIN/FIELD_EMAIL'), EMAIL, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.setEncryptedText(findTestObject('Object Repository/OR_LOGIN/FIELD_PASSWORD'), PASSWORD, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.click(findTestObject('Object Repository/OR_LOGIN/BUTTON_LOGIN'), FailureHandling.STOP_ON_FAILURE)
	
	WebUI.delay(2)
	
	if ( EMAIL == 'invalid@mail.com') {
		
		WebUI.verifyElementText(findTestObject(OBJECT_REPO), VERIFY_TEXT)
		
	}else {
		
		WebUI.verifyElementNotPresent(findTestObject(OBJECT_REPO), 2, FailureHandling.STOP_ON_FAILURE)
		
	}
	
	WebUI.closeBrowser()
	
}else if (TYPE == 'LINK') {
	
	WebUI.click(findTestObject(OBJECT_REPO), FailureHandling.STOP_ON_FAILURE)
	
	WebUI.delay(2)
	def URL = WebUI.getUrl()
	
	WebUI.verifyMatch(EXPECTED_URL, URL, false, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.closeBrowser()
	
}else {
	
	WebUI.comment('Not Coverage')
	
}