package com.hocs.test.glue;

import static org.junit.Assert.fail;

import com.hocs.test.pages.draft.Draft;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DraftResponseStepDefs {

    Draft draft;

    @When("^I select to reply by \"([^\"]*)\"$")
    public void iClickToAnswerBy(String method) {
        switch (method.toUpperCase()) {
            case "EMAIL":
                draft.clickEmailReplyRadioButton();
                break;
            case "PHONE":
                draft.clickPhoneReplyRadioButton();
                break;
            case "POST":
                draft.clickLetterReplyRadioButton();
                break;
            default:
                fail("Please enter EMAIL, PHONE or POST");
        }
    }

    @Then("^I can see the drafting deadline for a case$")
    public void iCanSeeTheDraftingDeadlineForACase() {
        draft.draftingDeadlineIsDisplayed();
    }

    @When("^a case has gone beyond the drafting deadline$")
    public void aCaseHasGoneBeyondTheDraftingDeadline() {

    }

    @And("^I enter call notes$")
    public void iEnterCallNotes() {
        draft.enterAllocationNoteField();
    }

    @And("^I do not enter call notes$")
    public void iDoNotEnterCallNotes() {
        draft.clearAllocationNoteField();
    }

    @Then("^an error message appears instructing me to add rejection reasons$")
    public void anErrorMessageAppearsInstructingMeToAddRejectionReasons() {
        draft.assertEnterRejectionReasonsError();
    }

    @When("^I finish drafting$")
    public void iFinishDrafting() {

    }

    @Then("^I see an error message instructing me to enter call notes$")
    public void iSeeAnErrorMessageInstructingMeToEnterCallNotes() {
        draft.assertEnterCallNotesError();
    }

    @Then("^I can see an error message instructing me to select either ‘online QA’ or ‘offline QA’$")
    public void iCanSeeAnErrorMessageInstructingMeToSelectEitherOnlineQAOrOfflineQA() {
        draft.assertEnterQaMethodError();
    }
}
