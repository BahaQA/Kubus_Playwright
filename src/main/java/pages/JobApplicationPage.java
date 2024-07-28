package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utils.BrowserUtils;

import java.nio.file.Paths;

public class JobApplicationPage {

    private Page page;
    private final Locator JOBS;
    private final Locator DEVELOPMENT;
    private final Locator SDET;
    private final Locator APPLY;
    private final Locator UPLOAD_AREA;
    private final Locator FULLNAME;
    private final Locator EMAIL;
    private final Locator PHONE_NUMBER;
    private final Locator LEGAL_AGREEMENTS;
    private final Locator SEND;



    public JobApplicationPage(Page page) {
        this.page = page;
        JOBS = page.locator("a[class='sc-ir8rf5-0 dxAUvh']");
        DEVELOPMENT = page.locator("label[for='4-2']");
        SDET = page.getByText("Senior Software Developer in Test (SDET)");
        APPLY = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Apply"));
        UPLOAD_AREA = page.locator("input[type='file']");
        FULLNAME = page.locator("input[id='input-candidate.name-8']");
        EMAIL = page.locator("input[id='input-candidate.email-9']");
        PHONE_NUMBER = page.locator("input[type='tel']");
        LEGAL_AGREEMENTS = page.locator("div[class='sc-135emnz-0 cziVBn']");
        SEND = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("submit"));
    }

    public void navigateToUrl(){
        page.navigate(BrowserUtils.getProperty("url"));
        page.waitForTimeout(1000);
    }
    public void clickJobs(){
        JOBS.click();
        page.waitForTimeout(1000);
    }
    public void selectDepartment(String department) {
        switch (department) {
            case "All departments":
                //ALLDEPARTMENTS.click();
                break;
            case "Customer Success":
                // CUSTOMERSUCCESS.click();
                break;
            case "Development":
                DEVELOPMENT.click();
                break;
            case "Marketing":
                //MARKETING.click();
                break;
            case "Sales":
                //SALES.click();
                break;
        }
        page.waitForTimeout(1000);
    }


    public void selectPosition(String position){
        SDET.click();
        page.waitForTimeout(1000);
    }

    public void scrollDown(){
        String scrollScript = "let totalHeight = 0; " +
                "let distance = 1; " +
                "let timer = setInterval(() => { " +
                "    window.scrollBy(0, distance); " +
                "    totalHeight += distance; " +
                "    if (totalHeight >= document.body.scrollHeight) clearInterval(timer); " +
                "}, 1);"; // Adjust the interval as needed

        page.evaluate(scrollScript);
        page.waitForTimeout(1000);
    }
    public void clickApply(){
        APPLY.click();
        page.waitForTimeout(1000);
    }
    public void uploadResume(String resumePath){
        UPLOAD_AREA.setInputFiles(Paths.get(resumePath));
        page.waitForTimeout(1000);
    }

    public void fillInfo(String fullName, String email, String phoneNumber){
        FULLNAME.fill(fullName);
        EMAIL.fill(email);
        PHONE_NUMBER.fill("");
        PHONE_NUMBER.fill(phoneNumber);
        page.waitForTimeout(1000);
    }
    public void checkLegalAgreements(){
        LEGAL_AGREEMENTS.scrollIntoViewIfNeeded();
        LEGAL_AGREEMENTS.click();
        page.waitForTimeout(3000);
    }




}
