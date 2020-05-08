import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
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

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://www.dropzonejs.com/')

def filePath1 = RunConfiguration.getProjectDir() + '/chibi1.JPG'

def filePath2 = RunConfiguration.getProjectDir() + '/chibi2.JPG'

def filePath3 = RunConfiguration.getProjectDir() + '/chibi3.JPG'

def filePath = filePath1 + '\n' + filePath2 + '\n' + filePath3

WebUI.uploadFileWithDragAndDrop(findTestObject('dropzonejs/dropzone'),filePath)

WebUI.uploadFileWithDragAndDrop(findTestObject('dropzonejs/dropzone'), filePath,FailureHandling.STOP_ON_FAILURE)

List<WebElement> elements = WebUiCommonHelper.findWebElements(findTestObject('dropzonejs/After Files Uploaded Div'), 
    GlobalVariable.timeout)

assert elements.size() == GlobalVariable.expectedSize

WebUI.closeBrowser()
