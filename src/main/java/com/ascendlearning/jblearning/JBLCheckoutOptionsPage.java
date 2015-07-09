package com.ascendlearning.jblearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.DropDownHandler;
import com.ascendlearning.automation.ui.handlers.LinkHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.page.BasePage;

public class JBLCheckoutOptionsPage extends BasePage{

	protected JBLCheckoutOptionsPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}


	/**
	 * This method will do login with the given username and password
	 * @param customer
	 * @throws Exception
	 */
	public JBLCheckoutOptionsPage signInAsReturningUser(String userName, String password) throws Exception{
		enterUserName(userName);
		enterPassword(password);
		clickLoginButton();

		return this;

	}

	public JBLCheckoutOptionsPage enterUserName(String userName) throws Exception{

		TextHandler textHandler = new TextHandler(driver);
		textHandler.writeText(PropertiesRepository.getString("jblearning.checkout.signin.username"),userName);

		return this;
	}


	public JBLCheckoutOptionsPage enterPassword(String password) throws Exception{

		TextHandler textHandler = new TextHandler(driver);
		textHandler.writeText(PropertiesRepository.getString("jblearning.checkout.signin.password"),password);

		return this;
	}

	public void clickLoginButton() throws Exception{

		LinkHandler linkHandler =new LinkHandler(driver);
		linkHandler.selectLink(PropertiesRepository.getString("jblearning.checkout.signin.loginbtn"),PropertiesRepository.getString("jblearning.checkout.custinfo.billaddress"));

	}

	
	/**
	 * This method will enter the customer info for the given customer
	 * @param customer
	 * @throws Exception
	 */
	public JBLCheckoutOptionsPage enterCustomerInfoAndContinue(String customer) throws Exception{

		enterBillingAddress(customer);
		enterBillingCity(customer);
		selectBillingState(customer);
		//enterBillingZip(customer); TODO StaleElementException is thrown during execution
		enterBillingPhone(customer);
		enterShippingInstruction(customer);
		enterCardHolderName(customer);
		enterCreditCardNumber(customer);
		enterCreditCardCVV(customer);
		selectCardExpiryMonth(customer);
		selectCardExpiryYear(customer);
		clickContinueCustInfo();
		
		return this;

	}


	/**
	 * This method will click the continue button in the customerinfo page
	 * @param customer
	 * @throws Exception
	 */
	private void clickContinueCustInfo() throws Exception {
		
		LinkHandler linkHandler =new LinkHandler(driver);
		linkHandler.selectLink(PropertiesRepository.getString("jblearning.checkout.custinfo.continuebtn"),PropertiesRepository.getString("jblearning.checkout.review.completecheckout"));

	}

	/**
	 * This method will click the complete Checkout button
	 * @param customer
	 * @throws Exception
	 */
	public JBLCheckoutOptionsPage clickCompleteCheckOut() throws Exception {
		
		LinkHandler linkHandler =new LinkHandler(driver);
		linkHandler.selectLink(PropertiesRepository.getString("jblearning.checkout.review.completecheckout"),PropertiesRepository.getString("jblearning.checkout.orderconfirm.thanks"));
		
		return this;

	}

	/**
	 * This method will select card expiry month for given customer
	 * @param customer
	 * @throws Exception
	 */
	private void selectCardExpiryMonth(String customer) throws Exception {

		String visibleText = PropertiesRepository.getString(customer+".info.expmonth");
		DropDownHandler dropDownHandler = new DropDownHandler(driver);
		Select dropDown = dropDownHandler.getDropDown(PropertiesRepository.getString("jblearning.checkout.custinfo.cardexpmonth"));
		dropDownHandler.selectByVisibleText(dropDown, visibleText);

	}

	/**
	 * This method will select card expiry year for given customer
	 * @param customer
	 * @throws Exception
	 */
	private void selectCardExpiryYear(String customer) throws Exception {

		String visibleText = PropertiesRepository.getString(customer+".info.expyear");
		DropDownHandler dropDownHandler = new DropDownHandler(driver);
		Select dropDown = dropDownHandler.getDropDown(PropertiesRepository.getString("jblearning.checkout.custinfo.cardexpyear"));
		dropDownHandler.selectByVisibleText(dropDown, visibleText);

	}


	/**
	 * This method will enter the cvv for given customer
	 * @param customer
	 * @throws Exception
	 */
	private void enterCreditCardCVV(String customer) throws Exception {
		
		String creditCardCVV = PropertiesRepository.getString(customer+".info.creditcardcvv");
		TextHandler textHandler = new TextHandler(driver);
		textHandler.writeText(PropertiesRepository.getString("jblearning.checkout.custinfo.cardcvv"),creditCardCVV);

	}


	/**
	 * This method will enter the credit card number for given customer
	 * @param customer
	 * @throws Exception
	 */
	private void enterCreditCardNumber(String customer) throws Exception {
		String creditCardNumber = PropertiesRepository.getString(customer+".info.creditcardnumber");
		TextHandler textHandler = new TextHandler(driver);
		textHandler.writeText(PropertiesRepository.getString("jblearning.checkout.custinfo.cardnumber"),creditCardNumber);

	}


	/**
	 * This method will enter the card holder name for given customer
	 * @param customer
	 * @throws Exception
	 */
	private void enterCardHolderName(String customer) throws Exception {
		String cardHolderName = PropertiesRepository.getString(customer+".info.cardholdername");
		TextHandler textHandler = new TextHandler(driver);
		textHandler.writeText(PropertiesRepository.getString("jblearning.checkout.custinfo.cardholdername"),cardHolderName);

	}


	/**
	 * This method will enter the shipping instructions for given customer
	 * @param customer
	 * @throws Exception
	 */
	private void enterShippingInstruction(String customer) throws Exception {
		String shippingInstruction = PropertiesRepository.getString(customer+".info.shippinginstruction");
		TextHandler textHandler = new TextHandler(driver);
		textHandler.writeText(PropertiesRepository.getString("jblearning.checkout.custinfo.shipinstruction"),shippingInstruction);

	}


	/**
	 * This method will enter the billing phone number for given customer
	 * @param customer
	 * @throws Exception
	 */
	private void enterBillingPhone(String customer) throws Exception {
		String phone = PropertiesRepository.getString(customer+".info.phone");
		TextHandler textHandler = new TextHandler(driver);
		textHandler.writeText(PropertiesRepository.getString("jblearning.checkout.custinfo.billphone"),phone);

	}


	/**
	 * This method will enter the billing zip code for given customer
	 * @param customer
	 * @throws Exception
	 */
	private void enterBillingZip(String customer) throws Exception {
		String zip = PropertiesRepository.getString(customer+".info.zip");
		TextHandler textHandler = new TextHandler(driver);
		textHandler.writeText(PropertiesRepository.getString("jblearning.checkout.custinfo.billzip"),zip);

	}


	/**
	 * This method will select the billing state for given customer
	 * @param customer
	 * @throws Exception
	 */
	private void selectBillingState(String customer) throws Exception {
		String state = PropertiesRepository.getString(customer+".info.state");
		DropDownHandler dropDownHandler = new DropDownHandler(driver);
		Select dropDown = dropDownHandler.getDropDown(PropertiesRepository.getString("jblearning.checkout.custinfo.billstate"));
		dropDownHandler.selectByVisibleText(dropDown, state);

	}


	private void enterBillingCity(String customer) throws Exception {
		String city = PropertiesRepository.getString(customer+".info.city");
		TextHandler textHandler = new TextHandler(driver);
		textHandler.writeText(PropertiesRepository.getString("jblearning.checkout.custinfo.billcity"),city);

	}


	private void enterBillingAddress(String customer) throws Exception {
		String address = PropertiesRepository.getString(customer+".info.address");
		TextHandler textHandler = new TextHandler(driver);
		textHandler.writeText(PropertiesRepository.getString("jblearning.checkout.custinfo.billaddress"),address);

	}
	
	public String getCustNameFromOrderConfirmation() throws DriverException{
		
		TextHandler textHandler = new TextHandler(driver);
		return textHandler.getText(PropertiesRepository.getString("jblearning.checkout.orderconfirm.custname"));
	}



}
