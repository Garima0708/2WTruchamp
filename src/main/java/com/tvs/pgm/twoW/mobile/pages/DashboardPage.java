package com.tvs.pgm.twoW.mobile.pages;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class DashboardPage extends BasePage{

    private AndroidDriver driver;
    private WebDriverWait wait;
    protected ExtentTest test;
    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
    
    @AndroidFindBy(className = "android.widget.TextView")
    private WebElement allowNotificationAccessText;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private WebElement clickAllow;
//scan 
    @AndroidFindBy(accessibility = "Scan For Rewards")
    private WebElement scanForRewardsText;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_message")
    private WebElement cameraAccessPermissionText;
    

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private WebElement whileUsingTheAppText;

    @AndroidFindBy(accessibility = "Redeem")
    private WebElement redeemModule;
    
    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement enterAmountField;
    
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Redeem\"]")
    private WebElement redeemAmount;
    
    @AndroidFindBy(accessibility = "Enter OTP sent to")
    private WebElement verifyRedeemOtp;
    
    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement redeemOtpField;
    
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Submit\"]")
    private WebElement redeemOtpSubmitButton;
    
    @AndroidFindBy(accessibility = "Your transaction with reference ID MRNDEV0000654 has been initiated. You will receive a status update shortly. ")
    private WebElement transactionInitiatPopup;
    
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"OK\"]")
    private WebElement mrnNumberPopupOkText;

	/*
	 * @AndroidFindBy(xpath = "(//android.widget.ImageView)[1]") private WebElement
	 * redeemBackArrow;
	 */

    @AndroidFindBy(accessibility = "Find Parts")
    private WebElement findPartsModule;

    @AndroidFindBy(accessibility = "Get Started")
    private WebElement startForWhatsappBot;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View")
    private WebElement cancelFindPartsOnWhatsApp;
    
    @AndroidFindBy(accessibility = "Help")
    private WebElement help;
    
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Create Query / Request\"]")
    private WebElement createOrRequestQuery;
    
    @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
    private WebElement queryTitle;
    
    @AndroidFindBy(accessibility = "Select Category")
    private WebElement selectCategory;
    
    @AndroidFindBy(accessibility = "Support Related")
    private WebElement chooseCategory;
    
    @AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
    private WebElement addDescription;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Create Query / Request\"]")
    private WebElement createQuery;
    
    @AndroidFindBy(xpath = "//android.widget.ImageView")
    private WebElement backToDashboard;

    
    public DashboardPage(ExtentTest test) {
        super(); // Ensure BasePage initializes getDriver()
        this.test = test;
        this.driver = (AndroidDriver) getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // ✅ FIXED
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    public String getNotificationAccessText() {
        try {
            wait.until(ExpectedConditions.visibilityOf(allowNotificationAccessText));
            return allowNotificationAccessText.getText();
        } catch (Exception e) {
            log.error("❌ Failed to get Notification Access Text", e);
            // don’t swallow the exception as a boolean—let your test framework see the failure
            throw new NoSuchElementException(
                "Cannot locate notification‑access text element", e);
        }
    }

    public String getAllowButtonText() {
        try {
            wait.until(ExpectedConditions.visibilityOf(clickAllow));
            String text = clickAllow.getText();
            log.info("✅ Allow Button Text found: {}", text);
            return text;
        } catch (Exception e) {
            log.error("❌ Failed to get Allow Button Text", e);
            throw new NoSuchElementException("Allow button text could not be retrieved.", e);
        }
    }

    public void clickAllowButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(clickAllow));
            clickAllow.click();
            log.info("✅ Clicked on Allow button.");
        } catch (Exception e) {
            log.error("❌ Failed to click Allow button", e);
            throw new ElementClickInterceptedException("Could not click Allow button.", e);
        }
    }

    public String getScanForRewardsText() {
        try {
            wait.until(ExpectedConditions.visibilityOf(scanForRewardsText));
            String desc = scanForRewardsText.getAttribute("contentDescription");
            log.info("✅ Scan For Rewards Text found: {}", desc);
            return desc;
        } catch (Exception e) {
            log.error("❌ Failed to get Scan For Rewards Text", e);
            throw new NoSuchElementException("Could not retrieve Scan For Rewards text (contentDescription).", e);
        }
    }

    public void clickOnScanForRewards() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(scanForRewardsText));
            scanForRewardsText.click();
            log.info("✅ Clicked on Scan For Rewards.");
        } catch (Exception e) {
            log.error("❌ Failed to click Scan For Rewards", e);
            throw new ElementClickInterceptedException("Could not click on Scan For Rewards button.", e);
        }
    }

    public String getCameraAccessPermissionText() {
        try {
            wait.until(ExpectedConditions.visibilityOf(cameraAccessPermissionText));
            String text = cameraAccessPermissionText.getText();
            log.info("✅ Camera Access Permission Text found: {}", text);
            return text;
        } catch (Exception e) {
            log.error("❌ Failed to get Camera Access Permission Text", e);
            throw new NoSuchElementException("Could not retrieve Camera Access Permission text.", e);
        }
    }

    public String getWhileUsingTheAppText() {
        try {
            wait.until(ExpectedConditions.visibilityOf(whileUsingTheAppText));
            String text = whileUsingTheAppText.getText();
            log.info("✅ While Using The App Text found: {}", text);
            return text;
        } catch (Exception e) {
            log.error("❌ Failed to get While Using The App Text", e);
            throw new NoSuchElementException("Could not retrieve 'While Using the App' permission text.", e);
        }
    }

    public void clickOnWhileUsingTheAppPopUpText() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(whileUsingTheAppText));
            whileUsingTheAppText.click();
            log.info("✅ Clicked on 'While Using The App' popup.");
        } catch (Exception e) {
            log.error("❌ Failed to click 'While Using The App' popup", e);
            throw new NoSuchElementException("Could not click 'While Using The App' popup.", e);
        }
    }
    public String getRedeemText() {
        try {
            wait.until(ExpectedConditions.visibilityOf(redeemModule));
            String desc = redeemModule.getAttribute("contentDescription");
            log.info("✅ Redeem Text found: {}", desc);
            return desc;
        } catch (Exception e) {
            log.error("❌ Failed to get Redeem Text", e);
            throw new NoSuchElementException("Could not retrieve Redeem Text from UI.", e);
        }
    }

    public void clickOnRedeemText() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(redeemModule));
            redeemModule.click();
            log.info("✅ Clicked on Redeem Module.");
        } catch (Exception e) {
            log.error("❌ Failed to click Redeem Module", e);
            throw new NoSuchElementException("Could not click on Redeem Module.", e);
        }
    }

    public String getEnterAmountText() {
        try {
            wait.until(ExpectedConditions.visibilityOf(enterAmountField));
            String desc = enterAmountField.getAttribute("contentDescription");
            log.info("✅ Enter Amount Text found: {}", desc);
            return desc;
        } catch (Exception e) {
            log.error("❌ Failed to get Enter Amount Text", e);
            throw new NoSuchElementException("Could not retrieve Enter Amount Text.", e);
        }
    }

    public void clickAndEnterAmount() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(enterAmountField));
            enterAmountField.click();
            enterAmountField.clear();
            enterAmountField.sendKeys("4");
            driver.hideKeyboard();
            log.info("✅ Entered amount '3' successfully.");
        } catch (Exception e) {
            log.error("❌ Failed to enter amount", e);
            throw new NoSuchElementException("Could not enter amount in the field.", e);
        }
    }

    public String getRedeemAmountText() {
        try {
            wait.until(ExpectedConditions.visibilityOf(redeemAmount));
            String desc = redeemAmount.getAttribute("contentDescription");
            log.info("✅ Redeem Amount Text found: {}", desc);
            return desc;
        } catch (Exception e) {
            log.error("❌ Failed to get Redeem Amount Text", e);
            throw new NoSuchElementException("Could not retrieve Redeem Amount Text.", e);
        }
    }
    public void clickOnRedeemAmount() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(redeemAmount));
            redeemAmount.click();
            log.info("✅ Clicked on Redeem Amount.");
        } catch (Exception e) {
            log.error("❌ Failed to click Redeem Amount", e);
            throw new NoSuchElementException("Could not click on Redeem Amount.", e);
        }
    }

    public boolean isRedeemOtpScreenDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(verifyRedeemOtp));
            boolean displayed = verifyRedeemOtp.isDisplayed();
            log.info("✅ Redeem OTP screen displayed: {}", displayed);
            return displayed;
        } catch (Exception e) {
            log.warn("⚠️ Redeem OTP screen not displayed: {}", e.getMessage());
            return false;
        }
    }

    public void clickOtpField() {
        try {
            wait.until(ExpectedConditions.visibilityOf(redeemOtpField));
            redeemOtpField.click();
            log.info("✅ Clicked on Redeem OTP field.");
        } catch (Exception e) {
            log.error("❌ Failed to click Redeem OTP field", e);
            throw new NoSuchElementException("Could not click on Redeem OTP field.", e);
        }
    }
    public void enterRedeemOtp(String otp) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(redeemOtpField));
            redeemOtpField.click();
            redeemOtpField.clear();
            redeemOtpField.sendKeys(otp);
            log.info("✅ Entered Redeem OTP: {}", otp);
        } catch (Exception e) {
            log.error("❌ Failed to enter Redeem OTP", e);
            throw new NoSuchElementException("Could not enter Redeem OTP.", e);
        }
    }

    public boolean isSubmitButtonEnable() {
        try {
            wait.until(ExpectedConditions.visibilityOf(redeemOtpSubmitButton));
            boolean enabled = redeemOtpSubmitButton.isEnabled();
            log.info("✅ Redeem OTP Submit button enabled: {}", enabled);
            return enabled;
        } catch (Exception e) {
            log.warn("⚠️ Failed to check Redeem OTP Submit button state: {}", e.getMessage());
            return false;
        }
    }

    public void clickOnRedeemOtpSubmitButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(redeemOtpSubmitButton));
            redeemOtpSubmitButton.click();
            log.info("✅ Clicked on Redeem OTP Submit button.");
        } catch (Exception e) {
            log.error("❌ Failed to click Redeem OTP Submit button", e);
            throw new NoSuchElementException("Could not click Redeem OTP Submit button.", e);
        }
    }

    public String generateUniqueMRN() {
        try {
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
            String mrn = ("MRNDEV" + timestamp).substring(0, 20);
            log.info("🆔 Generated unique MRN: {}", mrn);
            return mrn;
        } catch (Exception e) {
            log.error("❌ Failed to generate unique MRN", e);
            return "MRNDEVDEFAULT00000";
        }
    }

    public String getTransactionInitiatPopupText(String mrn) {
        try {
            String message = String.format(
                "Your transaction with reference ID\n%s has been initiated.\nYou will receive a status update\nshortly",
                mrn
            );
            log.info("ℹ️ Transaction initiation popup text:\n{}", message);
            return message;
        } catch (Exception e) {
            log.error("❌ Failed to build Transaction Initiation Popup Text", e);
            return null;
        }
    }

    public void clickOnMrmNumberOkText() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(mrnNumberPopupOkText));
            mrnNumberPopupOkText.click();
            log.info("✅ Clicked on MRN number popup OK button.");
        } catch (Exception e) {
            log.error("❌ Failed to click MRN number popup OK button", e);
            throw new NoSuchElementException("Could not click MRN number popup OK button.", e);
        }
    }

    public String getFindPartsText() {
        try {
            wait.until(ExpectedConditions.visibilityOf(findPartsModule));
            String desc = findPartsModule.getAttribute("contentDescription");
            log.info("🔍 Find Parts Text found: {}", desc);
            return desc;
        } catch (Exception e) {
            log.error("❌ Failed to get Find Parts Text", e);
            return null;
        }
    }

    public void clickOnFindParts() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(findPartsModule));
            findPartsModule.click();
            log.info("✅ Clicked on Find Parts module.");
        } catch (Exception e) {
            log.error("❌ Failed to click Find Parts module", e);
            throw new NoSuchElementException("Could not click Find Parts module.", e);
        }
    }

    public String getStartForWhatsappBot() {
        try {
            wait.until(ExpectedConditions.visibilityOf(startForWhatsappBot));
            String text = startForWhatsappBot.getText();
            log.info("📨 Start For WhatsApp Bot Text found: {}", text);
            return text;
        } catch (Exception e) {
            log.error("❌ Failed to get Start For WhatsApp Bot Text", e);
            return null;
        }
    }

    public void clickOnStartForWhatsappBot() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(startForWhatsappBot));
            startForWhatsappBot.click();
            log.info("✅ Clicked on Start For WhatsApp Bot.");
        } catch (Exception e) {
            log.error("❌ Failed to click Start For WhatsApp Bot", e);
            throw new NoSuchElementException("Could not click Start For WhatsApp Bot.", e);
        }
    }

    public void clickOnCancelFindPartsOnWhatsApp() {
        try {
            wait.until(ExpectedConditions.visibilityOf(cancelFindPartsOnWhatsApp));
            wait.until(ExpectedConditions.elementToBeClickable(cancelFindPartsOnWhatsApp));
            cancelFindPartsOnWhatsApp.click();
            log.info("✅ Clicked on Cancel Find Parts on WhatsApp.");
        } catch (Exception e) {
            log.error("❌ Failed to click Cancel Find Parts on WhatsApp", e);
            throw new NoSuchElementException("Could not click Cancel Find Parts on WhatsApp.", e);
        }
    }

    public String getHelpText() {
        try {
            wait.until(ExpectedConditions.visibilityOf(help));
            String desc = help.getAttribute("contentDescription");
            log.info("🆘 Help Text found: {}", desc);
            return desc;
        } catch (Exception e) {
            log.error("❌ Failed to get Help Text", e);
            return null;
        }
    }

    public void clickOnHelp() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(help));
            help.click();
            log.info("✅ Clicked on Help.");
        } catch (Exception e) {
            log.error("❌ Failed to click Help", e);
            throw new NoSuchElementException("Could not click Help.", e);
        }
    }

    public String getCreateOrRequestQueryText() {
        try {
            wait.until(ExpectedConditions.visibilityOf(createOrRequestQuery));
            String desc = createOrRequestQuery.getAttribute("contentDescription");
            log.info("📨 Create Or Request Query Text found: {}", desc);
            return desc;
        } catch (Exception e) {
            log.error("❌ Failed to get Create Or Request Query Text", e);
            return null;
        }
    }

    public void clickOnCreateOrRequestQuery() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(createOrRequestQuery));
            createOrRequestQuery.click();
            log.info("📬 Clicked on Create Or Request Query.");
        } catch (Exception e) {
            log.error("❌ Failed to click Create Or Request Query", e);
            throw new NoSuchElementException("Could not click Create Or Request Query", e);
        }
    }

    public String getQueryTitleText() {
        try {
            wait.until(ExpectedConditions.visibilityOf(queryTitle));
            String desc = queryTitle.getAttribute("contentDescription");
            log.info("📝 Query Title Text found: {}", desc);
            return desc;
        } catch (Exception e) {
            log.error("❌ Failed to get Query Title Text", e);
            return null;
        }
    }

    public void clickOnAndAddQueryTitle() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(queryTitle));
            queryTitle.click();
            queryTitle.clear();
            queryTitle.sendKeys("Hi, Gari add here Automation Query Request Title : Hello support Team");
            log.info("✅ Added Query Title: Automation Query Request Title : hi");
        } catch (Exception e) {
            log.error("❌ Failed to add Query Title", e);
            throw new ElementNotInteractableException("Could not input query title", e);
        }
    }

    public String getSelectCategoryText() {
        try {
            wait.until(ExpectedConditions.visibilityOf(selectCategory));
            String desc = selectCategory.getAttribute("contentDescription");
            log.info("📄 Select Category Text found: {}", desc);
            return desc;
        } catch (Exception e) {
            log.error("❌ Failed to get Select Category Text", e);
            return null;
        }
    }

    public void clickOnSelectCategory() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(selectCategory));
            selectCategory.click();
            log.info("🖱️ Clicked on Select Category.");
        } catch (Exception e) {
            log.error("❌ Failed to click Select Category", e);
            throw new ElementClickInterceptedException("Unable to click Select Category", e);
        }
    }

    public String getChooseCategoryText() {
        try {
            wait.until(ExpectedConditions.visibilityOf(chooseCategory));
            String desc = chooseCategory.getAttribute("contentDescription");
            log.info("📑 Choose Category Text found: {}", desc);
            return desc;
        } catch (Exception e) {
            log.error("❌ Failed to get Choose Category Text", e);
            return null;
        }
    }

    public void clickOnChooseCategory() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(chooseCategory));
            chooseCategory.click();
            log.info("🖱️ Clicked on Choose Category.");
        } catch (Exception e) {
            log.error("❌ Failed to click Choose Category", e);
            throw new ElementClickInterceptedException("Unable to click Choose Category", e);
        }
    }
    public String getAddDescriptionText() {
        try {
            wait.until(ExpectedConditions.visibilityOf(addDescription));
            String desc = addDescription.getAttribute("contentDescription");
            log.info("📝 Add Description Text found: {}", desc);
            return desc;
        } catch (Exception e) {
            log.error("❌ Failed to get Add Description Text", e);
            return null;
        }
    }

    public void clickOnAndAddDescription() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(addDescription));
            addDescription.click();
            addDescription.clear();
            addDescription.sendKeys("Hi , Garima  add Automation Query Request Description : support");
            driver.hideKeyboard();
            log.info("✅ Added Description text.");
        } catch (Exception e) {
            log.error("❌ Failed to add Description", e);
            throw new RuntimeException("Unable to enter query description", e);
        }
    }
    public String getCreateQueryText() {
        try {
            WebElement element = scrollToElementByAccessibilityId("Create Query / Request");
            wait.until(ExpectedConditions.visibilityOf(element));
            String desc = element.getAttribute("contentDescription");
            log.info("✅ Create Query Text found: {}", desc);
            return desc;
        } catch (Exception e) {
            log.error("❌ Failed to get Create Query Text", e);
            return null;
        }
    }

    public void clickOnCreateQuery() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(createQuery));
            createQuery.click();
            log.info("✅ Clicked on Create Query.");
        } catch (Exception e) {
            log.error("❌ Failed to click Create Query", e);
            throw new ElementClickInterceptedException("Unable to click Create Query", e);
        }
    }
    
    
    public List<String[]> printAllQueryIdsAndStatuses() {
        List<String[]> queryData = new ArrayList<>();
        Set<String> seenContent = new HashSet<>();
        int scrollCount = 0;
        int maxScroll = 10;
        int previousSeenCount = 0;

        try {
            while (scrollCount < maxScroll) {
                List<WebElement> queries = driver.findElements(
                    By.xpath("//android.view.View[contains(@content-desc, '#')]"));

                for (WebElement query : queries) {
                    String content = query.getAttribute("content-desc");
                    if (content == null || seenContent.contains(content)) continue;

                    seenContent.add(content);
                    String[] lines = content.split("\n");

                    try {
                        String queryId = lines[0].trim(); // e.g., #101828
                        String title = lines.length > 2 ? lines[2].trim() : "Unknown";
                        String status = lines.length > 3 ? lines[3].trim() : "Unknown";

                        log.info("🧾 Query ID: {} | Title: {} | Status: {}", queryId, title, status);
                        queryData.add(new String[]{queryId, title, status});
                    } catch (Exception parseEx) {
                        log.warn("⚠️ Failed to parse query: {} - {}", content, parseEx.getMessage());
                    }
                }

                if (seenContent.size() == previousSeenCount) {
                    break; // No new items found, stop scrolling
                }

                previousSeenCount = seenContent.size();
                boolean scrolled = scrollDown(); // From BasePage
                if (!scrolled) break;

                scrollCount++;
            }
        } catch (Exception e) {
            log.error("❌ Failed to extract all queries", e);
        }

        return queryData;
    }
    public void backToDashboard() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(backToDashboard));
            backToDashboard.click();  // Fixed: was incorrectly using createQuery.click()
            log.info("✅ Returned back to Dashboard.");
        } catch (Exception e) {
            log.error("❌ Failed to go back to Dashboard", e);
            throw new RuntimeException("Navigation to dashboard failed", e);
        }
    }
    
}