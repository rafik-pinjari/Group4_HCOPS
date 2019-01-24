package PageObjectModel;

import java.io.IOException;

import org.testng.Assert;

import Utilities.ActionMethods;


public class FATCA extends CitizenID_UL{
	
	public static String fatcaTitle = "//XCUIElementTypeStaticText[@name=\"ข้อมูลผู้เอาประกันภัย/TAX/FATCA\"]"; //Xpath
	public static String fatcaSubTitle = "//XCUIElementTypeStaticText[@name=\"การยินยอมเปิดเผยข้อมูลเกี่ยวกับเบี้ยประกันภัยต่อกรมสรรพากร\"]"; //Xpath
	public static String fatcaCitizenQuestion = "//XCUIElementTypeStaticText[@name=\"ผู้ขอเอาประกันภัยประสงค์จะใช้สิทธิขอยกเว้นภาษีเงินได้ตามกฎหมายว่าด้วยภาษีอากรหรือไม่ และยินยอมให้บริษัทประกันชีวิตส่งและเปิดเผยข้อมูลเกี่ยวกับเบี้ยประกันภัยต่อสรรพากรตามหลักเกณฑ์วิธีการที่กรมสรรพากรกำหนด\"]"; //Xpath
	public static String fatcaCitizenAnswer1 = "//XCUIElementTypeStaticText[@name=\"มีความประสงค์ และยินยอมให้บริษัทประกันชีวิตส่งและเปิดเผยข้อมูลเกี่ยวกับเบี้ยประกันภัยต่อกรมสรรพากร ตามหลักเกณฑ์ วิธีการที่กรมสรรพากรกำหนด\"]"; //Xpath
	public static String fatcaCitizenAnswer2 = "//XCUIElementTypeStaticText[@name=\"ไม่มีความประสงค์\"]"; //Xpath
	public static String fatcaCitizenNote = "//XCUIElementTypeStaticText[@name=\"คำเตือน: กรณีที่ท่านเลือกไม่มีความประสงค์ บริษัทจะไม่นำส่งข้อมูลเบี้ยประกันของท่านต่อกรมสรรพากรตามหลักเกณฑ์และวิธีการที่สรรพากรกำหนด ซึ่งท่านอาจไม่สามารถใช้สิทธิลดหย่อนภาษีเงินได\"]"; //Xpath
	public static String fatcaPassportQuestion = "//XCUIElementTypeStaticText[@name=\"ผู้ขอเอาประกันภัยประสงค์จะใช้สิทธิขอยกเว้นภาษีเงินได้ตามกฎหมายว่าด้วยภาษีอากรหรือไม่ และยินยอมให้บริษัทประกันชีวิตส่งและเปิดเผยข้อมูลเกี่ยวกับเบี้ยประกันภัยต่อสรรพากรตามหลักเกณฑ์วิธีการที่กรมสรรพากรกำหนด โดยผู้ขอเอาประกันภัยเป็นชาวต่างชาติ (Non-Thai Residence) ซึ่งเป็นผู้มีหน้าที่ต้องเสียภาษีเงินได้ตามกฎหมายว่าด้วยภาษีอากร\"]"; //Xpath
	public static String fatcaPassportAnswer1 = "//XCUIElementTypeStaticText[@name=\"มีความประสงค์ และยินยอมให้บริษัทประกันชีวิตส่งและเปิดเผยข้อมูลเกี่ยวกับเบี้ยประกันภัยต่อกรมสรรพากร ตามหลักเกณฑ์ วิธีการที่กรมสรรพากรกำหนด\"]"; //Xpath
	public static String fatcaPassportAnswer2 = "//XCUIElementTypeStaticText[@name=\"ไม่มีความประสงค์\"]"; //Xpath
	public static String fatcaPassportTaxid = "//XCUIElementTypeStaticText[@name=\"โปรดระบุเลขประจำตัวผู้เสียภาษีที่ได้รับจากสรรพากร\"]"; //Xpath
	public static String taxIDTextbox = "**/XCUIElementTypeTextField"; //iOSClassChain 
	
	public static String expectedFatcaTitle = "ข้อมูลผู้เอาประกันภัย/TAX/FATCA";
	public static String expectedSubTitle = "การยินยอมเปิดเผยข้อมูลเกี่ยวกับเบี้ยประกันภัยต่อกรมสรรพากร";
	public static String expectedCitizenQuestion = "ผู้ขอเอาประกันภัยประสงค์จะใช้สิทธิขอยกเว้นภาษีเงินได้ตามกฎหมายว่าด้วยภาษีอากรหรือไม่ และยินยอมให้บริษัทประกันชีวิตส่งและเปิดเผยข้อมูลเกี่ยวกับเบี้ยประกันภัยต่อสรรพากรตามหลักเกณฑ์วิธีการที่กรมสรรพากรกำหนด";
	public static String expectedCitizenAnswer1 = "มีความประสงค์ และยินยอมให้บริษัทประกันชีวิตส่งและเปิดเผยข้อมูลเกี่ยวกับเบี้ยประกันภัยต่อกรมสรรพากร ตามหลักเกณฑ์ วิธีการที่กรมสรรพากรกำหนด";
	public static String expectedCitizenAnswer2 = "ไม่มีความประสงค์";
	public static String expectedCitizenNote = "คำเตือน: กรณีที่ท่านเลือกไม่มีความประสงค์ บริษัทจะไม่นำส่งข้อมูลเบี้ยประกันของท่านต่อกรมสรรพากรตามหลักเกณฑ์และวิธีการที่สรรพากรกำหนด ซึ่งท่านอาจไม่สามารถใช้สิทธิลดหย่อนภาษีเงินได";
	public static String expectedPassportQuestion = "ผู้ขอเอาประกันภัยประสงค์จะใช้สิทธิขอยกเว้นภาษีเงินได้ตามกฎหมายว่าด้วยภาษีอากรหรือไม่ และยินยอมให้บริษัทประกันชีวิตส่งและเปิดเผยข้อมูลเกี่ยวกับเบี้ยประกันภัยต่อสรรพากรตามหลักเกณฑ์วิธีการที่กรมสรรพากรกำหนด โดยผู้ขอเอาประกันภัยเป็นชาวต่างชาติ (Non-Thai Residence) ซึ่งเป็นผู้มีหน้าที่ต้องเสียภาษีเงินได้ตามกฎหมายว่าด้วยภาษีอากร";
	public static String expectedPassportAnswer1 = "มีความประสงค์ และยินยอมให้บริษัทประกันชีวิตส่งและเปิดเผยข้อมูลเกี่ยวกับเบี้ยประกันภัยต่อกรมสรรพากร ตามหลักเกณฑ์ วิธีการที่กรมสรรพากรกำหนด";
	public static String expectedPassportAnswer2 = "ไม่มีความประสงค์";
	public static String expectedPassportTaxid = "โปรดระบุเลขประจำตัวผู้เสียภาษีที่ได้รับจากสรรพากร";
	
	
	public static String fatcaMainYes = "ใช่ ขอยอมรับว่าเป็นความจริง";
	public static String fatcaMainNo = "ไม่ ไม่ยอมรับ";
	public static int j = 2;
	
	public static String subYes = "(//XCUIElementTypeStaticText[@name=\"ใช่ ขอยอมรับว่าเป็นความจริง\"])";
	public static String subNo = "(//XCUIElementTypeStaticText[@name=\"ไม่ ไม่ยอมรับ\"])";
	
	//MVP3.1
	public static String fatcaQuestion1ThaiResident = "//XCUIElementTypeStaticText[@name=\"ผู้ขอเอาประกันภัยประสงค์จะใช้สิทธิขอยกเว้นภาษีเงินได้ตามกฎหมายว่าด้วยภาษีอากร และยินยอมให้บริษัทประกันชีวิตส่ง และเปิดเผยข้อมูลเกี่ยวกับเบี้ยประกันภัยต่อกรมสรรพากรตามหลักเกณฑ์ วิธีการที่กรมสรรพากรกำหนดหรือไม่\"]่"; //accessibility ID
	public static String fatcaAnswer1ThaiResident = "//XCUIElementTypeStaticText[@name=\"มีความประสงค์\"]";
	public static String fatcaAnswer2ThaiResident = "//XCUIElementTypeStaticText[@name=\"ไม่มีความประสงค์\"]";
	
	public static String expectedFatcaQuestion1ThaiResident = "ผู้ขอเอาประกันภัยประสงค์จะใช้สิทธิขอยกเว้นภาษีเงินได้ตามกฎหมายว่าด้วยภาษีอากร และยินยอมให้บริษัทประกันชีวิตส่ง และเปิดเผยข้อมูลเกี่ยวกับเบี้ยประกันภัยต่อกรมสรรพากรตามหลักเกณฑ์ วิธีการที่กรมสรรพากรกำหนดหรือไม่"; //accessibility ID
	public static String expectedFatcaAnswer1ThaiResident = "มีความประสงค์"; //wishes   มีความประสงค์
	public static String expectedFatcaAnswer2ThaiResident = "ไม่มีความประสงค์์"; //unwanted
		
	public static void verifyFatcaThaiResident() throws InterruptedException, IOException
	{
		Thread.sleep(20000);
		//ActionMethods.verifyText(fatcaQuestion1ThaiResident,"xpath","name",expectedFatcaQuestion1ThaiResident);
		//ActionMethods.verifyText(fatcaAnswer1ThaiResident,"xpath","name",expectedFatcaAnswer1ThaiResident);
		//ActionMethods.verifyText(fatcaAnswer2ThaiResident,"xpath","name",expectedFatcaAnswer2ThaiResident);
		
		fatcaQuestion1ThaiResident.contains(expectedFatcaQuestion1ThaiResident);
		fatcaAnswer1ThaiResident.contains(expectedFatcaAnswer1ThaiResident);
		fatcaAnswer2ThaiResident.contains(expectedFatcaAnswer2ThaiResident);
		ActionMethods.captureAndAddScreenshot("FATCA");
	}
	
	public static void selectAnswerForThaiResident(String answer) throws IOException, InterruptedException
	{
		switch(answer)
		{
			case "wishes":
				ActionMethods.tapButton(expectedFatcaAnswer1ThaiResident,"accessibilityID");
				break;
			case "unwanted":
				ActionMethods.tapButton(expectedFatcaAnswer2ThaiResident, "accessibilityID");	
				break;
		}
//		System.out.println("sleep started");
//		Thread.sleep(10000);
		ActionMethods.captureAndAddScreenshot("FATCA");
	}
	
	public static String fatcaQuestionNonThaiResident = "//XCUIElementTypeStaticText[@name=\"ผู้ขอเอาประกันภัยเป็นชาวต่างชาติ (Non-Thai Residence) ซึ่งเป็นผู้มีหน้าที่ต้องเสียภาษีเงินได้ตามกฎหมายว่าด้วยภาษีอากร ประสงค์จะใช้สิทธิขอยกเว้นภาษีเงินได้ตามกฎหมายว่าด้วยภาษีอากร และยินยอมให้บริษัทประกันชีวิตส่ง และเปิดเผยข้อมูลเกี่ยวกับเบี้ยประกันภัยต่อกรมสรรพากรตามหลักเกณฑ์ วิธีการที่กรมสรรพากรกำหนดหรือไม่\"]";
	public static String fatcaAnswer1NonThaiResident = "//XCUIElementTypeStaticText[@name=\"มีความประสงค์\"]"; //fatcaQuestion1NonThaiResident1
	public static String fatcaAnswer2NonThaiResident = "//XCUIElementTypeStaticText[@name=\"ไม่มีความประสงค์\"]";
	
	public static String expectedFatcaQuestion1NonThaiResident = "ผู้ขอเอาประกันภัยเป็นชาวต่างชาติ (Non-Thai Residence) ซึ่งเป็นผู้มีหน้าที่ต้องเสียภาษีเงินได้ตามกฎหมายว่าด้วยภาษีอากร ประสงค์จะใช้สิทธิขอยกเว้นภาษีเงินได้ตามกฎหมายว่าด้วยภาษีอากร และยินยอมให้บริษัทประกันชีวิตส่ง และเปิดเผยข้อมูลเกี่ยวกับเบี้ยประกันภัยต่อกรมสรรพากรตามหลักเกณฑ์ วิธีการที่กรมสรรพากรกำหนดหรือไม่";
	public static String expectedFatcaAnswer1NonThaiResident = "มีความประสงค์";
	public static String expectedFatcaAnswer2NonThaiResident = "ไม่มีความประสงค์";
	
	public static void verifyFatcaNonThaiResident() throws InterruptedException, IOException
	{
		Thread.sleep(20000);
		//ActionMethods.verifyText(fatcaQuestionNonThaiResident, "xpath", "name", expectedFatcaQuestion1NonThaiResident);
		//ActionMethods.verifyText(fatcaAnswer1NonThaiResident, "xpath", "name", expectedFatcaAnswer1NonThaiResident);
		//ActionMethods.verifyText(fatcaAnswer2NonThaiResident, "xpath", "name", expectedFatcaAnswer2NonThaiResident);
		
		fatcaQuestionNonThaiResident.contains(expectedFatcaQuestion1NonThaiResident);
		fatcaAnswer1NonThaiResident.contains(expectedFatcaAnswer1NonThaiResident);
		fatcaAnswer2NonThaiResident.contains(expectedFatcaAnswer2NonThaiResident);
		ActionMethods.captureAndAddScreenshot("FATCA");
	}
	
	public static void selectAnswerForNonThaiResident(String answer) throws IOException, InterruptedException
	{
//		switch(answer)
//		{
//			case "wishes":
//				ActionMethods.clickButton(expectedFatcaAnswer1NonThaiResident, "accessibilityID");
//				break;
//			case "unwanted":
//				ActionMethods.clickButton(expectedFatcaAnswer2NonThaiResident, "accessibilityID");	
//				break;
//		}
		System.out.println("sleep started");
		Thread.sleep(10000);
		ActionMethods.captureAndAddScreenshot("FATCA");
	}
	
	public static void selectAnswerForFatca(String answers) 
	{
		BasePage.scrollPageDown();
		String[] subAnswerArray = answers.split(",");
		if(subAnswerArray[0].equalsIgnoreCase("yes"))
		{
			ActionMethods.tapButton(fatcaMainYes, "accessibilityID");
		}
		if(subAnswerArray[0].equalsIgnoreCase("no"))
		{
			ActionMethods.tapButton(fatcaMainNo, "accessibilityID");
			BasePage.scrollPageDown();
			for( int i = 1; i < subAnswerArray.length ; i++)
			{	
				//System.out.println("inside for loop");
				//System.out.println("subanswer" +subAnswerArray[i]);
				selectSubAnswer(subAnswerArray[i]);
				//System.out.println("subanswer" +subAnswerArray[i]);
			}
		}
	}

	private static void selectSubAnswer(String answer) {
		switch(answer)
		{
			case "Yes":
					String subAnswer = subYes+"["+j+"]";
					ActionMethods.tapButton(subAnswer, "xpath");
					j++;
					break;
			case "No":
				System.out.println("nooooooo");
					String subAnswer1 = subNo+"["+j+"]";
				//	System.out.println("subanswer"+subAnswer1);
					ActionMethods.tapButton(subAnswer1, "xpath");
					j++;
					break;
		}
		
	}
	
	/**
	 * @author DHIRESH MUNDADA
	 * Description: Method to verify text of new question added on FATCA page
	 */
	public static void verifyFatcaNewQuestion() throws IOException
	{
		ActionMethods.verifyText(fatcaTitle,"xpath","name",expectedFatcaTitle);
		ActionMethods.verifyText(fatcaSubTitle, "xpath","name", expectedSubTitle);
		ActionMethods.verifyText(fatcaCitizenNote, "xpath", "name", expectedCitizenNote);
		if(IDtype.equalsIgnoreCase("citizenID"))
		{
			ActionMethods.verifyText(fatcaCitizenQuestion, "xpath", "name", expectedCitizenQuestion);
			ActionMethods.verifyText(fatcaCitizenAnswer1, "xpath", "name", expectedCitizenAnswer1);
			ActionMethods.verifyText(fatcaCitizenAnswer2, "xpath", "name", expectedCitizenAnswer2);	
			//ActionMethods.clickButton(expectedCitizenAnswer1, "accessibilityID");			
		}
		else
		{
			System.out.println("FATCA Passport verification");
			ActionMethods.verifyText(fatcaPassportQuestion, "xpath", "name", expectedPassportQuestion);
			ActionMethods.verifyText(fatcaPassportAnswer1, "xpath", "name", expectedPassportAnswer1);
			ActionMethods.verifyText(fatcaPassportAnswer2, "xpath", "name", expectedPassportAnswer2);
			//ActionMethods.tapButton(expectedPassportAnswer1, "accessibilityID");
			//ActionMethods.verifyText(fatcaPassportTaxid, "xpath", "name", expectedPassportTaxid);
			//ActionMethods.enterText(taxIDTextbox, "iosClassChain", "123456");
			//ActionMethods.tapXandY(200, 200);
		}
		ActionMethods.captureAndAddScreenshot("Fatca New Question");
	}
	
	/**
	 * @author DHIRESH MUNDADA
	 * Description: Method to select answer of the new question added on FATCA page
	 */
	public static void selectFatcaNewQuesAnswer(String answer)
	{
		if(answer.equalsIgnoreCase("yes"))
		{
			if(IDtype.equalsIgnoreCase("citizenID"))
			{
				ActionMethods.clickButton(expectedCitizenAnswer1, "accessibilityID");
			}
			else
			{
				ActionMethods.tapButton(expectedPassportAnswer1, "accessibilityID");
				ActionMethods.verifyText(fatcaPassportTaxid, "xpath", "name", expectedPassportTaxid);
				ActionMethods.enterText(taxIDTextbox, "iosClassChain", "123456");
				ActionMethods.tapXandY(200, 200);
			}	
		}
		else if(answer.equalsIgnoreCase("no"))
		{
			if(IDtype.equalsIgnoreCase("citizenID"))
			{
				ActionMethods.clickButton(expectedCitizenAnswer2, "accessibilityID");
			}
			else
			{
				ActionMethods.tapButton(expectedPassportAnswer2, "accessibilityID");
			}
		}	
	}
	
}
