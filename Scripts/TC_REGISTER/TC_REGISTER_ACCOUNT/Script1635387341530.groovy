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

WebUI.navigateToUrl(GlobalVariable.BASE_URL)

WebUI.maximizeWindow()

if (TYPE == 'POSITIVE') {
	def RANDOM_NUMBER = CustomKeywords.'randomgenarator.random.getRandomNumber'()
	def EMAIL_ACCOUNT = CustomKeywords.'randomgenarator.random.getEmail'('brick', 'qa.com')
	
	WebUI.comment(EMAIL_ACCOUNT)
	
	GlobalVariable.EMAIL_ALREADY_EXIST = EMAIL_ACCOUNT
	
	WebUI.setText(findTestObject('OR_REGISTER/FIELD_FIRST_NAME'), FIRST_NAME + RANDOM_NUMBER, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.setText(findTestObject('OR_REGISTER/FIELD_LAST_NAME'), LAST_NAME , FailureHandling.STOP_ON_FAILURE)
	
	WebUI.setText(findTestObject('Object Repository/OR_REGISTER/FIELD_EMAIL'), EMAIL_ACCOUNT, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.click(findTestObject('Object Repository/OR_COUNTRY/COUNTRY'), FailureHandling.STOP_ON_FAILURE)
	
	WebUI.click(findTestObject(OBJECT_COUNTRY), FailureHandling.STOP_ON_FAILURE)
	
	WebUI.click(findTestObject('Object Repository/OR_REGISTER/FIELD_PHONE_NUMBER'), FailureHandling.STOP_ON_FAILURE)
	
	WebUI.sendKeys(findTestObject('Object Repository/OR_REGISTER/FIELD_PHONE_NUMBER'), PHONE_NUMBER + RANDOM_NUMBER, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.setText(findTestObject('Object Repository/OR_REGISTER/FIELD_ADDRESS'), ADDRESS , FailureHandling.STOP_ON_FAILURE)
	
	WebUI.setEncryptedText(findTestObject('Object Repository/OR_REGISTER/FIELD_PASSWORD'), PASSWORD, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.setEncryptedText(findTestObject('Object Repository/OR_REGISTER/FIELD_CONFIRM_PASSWORD'), CONFIRM_PASSWORD, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.click(findTestObject('Object Repository/OR_REGISTER/BUTTON_REGISTER'), FailureHandling.STOP_ON_FAILURE)
	
	WebUI.delay(5)
	
	WebUI.verifyElementText(findTestObject(OBJECT_REPO), VERIFY_TEXT)
	
	WebUI.delay(2)
	
	WebUI.closeBrowser()
	
}else if (TYPE == 'NEGATIVE') {
	
	WebUI.setText(findTestObject('OR_REGISTER/FIELD_FIRST_NAME'), FIRST_NAME , FailureHandling.STOP_ON_FAILURE)
	
	WebUI.setText(findTestObject('OR_REGISTER/FIELD_LAST_NAME'), LAST_NAME , FailureHandling.STOP_ON_FAILURE)
	
	if (FIRST_NAME == 'VALID_EMAIL') {
		WebUI.setText(findTestObject('Object Repository/OR_REGISTER/FIELD_EMAIL'), EMAIL, FailureHandling.STOP_ON_FAILURE)
	}else {
		WebUI.setText(findTestObject('Object Repository/OR_REGISTER/FIELD_EMAIL'), GlobalVariable.EMAIL_ALREADY_EXIST, FailureHandling.STOP_ON_FAILURE)
	}
	
	WebUI.setText(findTestObject('Object Repository/OR_REGISTER/FIELD_PHONE_NUMBER'), PHONE_NUMBER , FailureHandling.STOP_ON_FAILURE)
	
	WebUI.setText(findTestObject('Object Repository/OR_REGISTER/FIELD_ADDRESS'), ADDRESS , FailureHandling.STOP_ON_FAILURE)
	
	WebUI.setEncryptedText(findTestObject('Object Repository/OR_REGISTER/FIELD_PASSWORD'), PASSWORD, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.setEncryptedText(findTestObject('Object Repository/OR_REGISTER/FIELD_CONFIRM_PASSWORD'), CONFIRM_PASSWORD, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.click(findTestObject('Object Repository/OR_REGISTER/BUTTON_REGISTER'), FailureHandling.STOP_ON_FAILURE)
	
	WebUI.delay(5)
	
	WebUI.verifyElementText(findTestObject(OBJECT_REPO), VERIFY_TEXT)
	
	WebUI.delay(2)
	
	WebUI.closeBrowser()
	
}else if (TYPE == 'LINK') {
	
	WebUI.click(findTestObject('OR_REGISTER/LINK_LOGIN'), FailureHandling.STOP_ON_FAILURE)
	
	def URL = WebUI.getUrl()
	
	WebUI.verifyMatch('https://brick-qa-assignment.herokuapp.com/login', URL, false, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.closeBrowser()
	
}else {
	WebUI.comment('Not Coverage')
}