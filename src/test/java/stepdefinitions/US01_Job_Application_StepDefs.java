package stepdefinitions;

import driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.JobApplicationPage;

public class US01_Job_Application_StepDefs {

    JobApplicationPage jobApplicationPage = new JobApplicationPage(Driver.getPage());

    @Given("the applicant is on the home page")
    public void the_applicant_is_on_the_home_page() {
        jobApplicationPage.navigateToUrl();

    }
    @When("the applicant clicks the Jobs button")
    public void the_applicant_clicks_the_jobs_button() {
        jobApplicationPage.clickJobs();
    }
    @When("the applicant selects the {string}")
    public void the_applicant_selects_the(String department) {
        jobApplicationPage.selectDepartment(department);
    }
    @When("the applicant selects a {string}")
    public void the_applicant_selects_a(String position) {
        jobApplicationPage.selectPosition(position);
    }
    @When("the applicant scrolls down the job details")
    public void the_applicant_scrolls_down_the_job_details() {
        jobApplicationPage.scrollDown();
    }
    @When("the applicant clicks the Apply button")
    public void the_applicant_clicks_the_apply_button() {
        jobApplicationPage.clickApply();
    }

    @And("the applicant uploads their {string}")
    public void the_applicant_uploads_their(String resume) {
        jobApplicationPage.uploadResume(resume);
    }

    @When("the applicant enters {string}, {string}, and {string}")
    public void the_applicant_enters_and(String fullName, String email, String phoneNumber) {
        jobApplicationPage.fillInfo(fullName, email, phoneNumber);

    }
    @When("the applicant checks the Legal Agreements")
    public void the_applicant_checks_the_legal_agreements() {
        jobApplicationPage.checkLegalAgreements();
    }

    @When("the applicant clicks the Send button")
    public void the_applicant_clicks_the_send_button() {

    }
    @Then("the application should be sent and {string} should be displayed")
    public void the_application_should_be_sent_and_should_be_displayed(String string) {

    }


}
