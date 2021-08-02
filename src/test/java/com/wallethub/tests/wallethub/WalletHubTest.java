package com.wallethub.tests.wallethub;

import com.wallethub.pages.wallethub.WalletHubInsurancePage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import com.wallethub.tests.BaseTest;

public class WalletHubTest extends BaseTest {

    WalletHubInsurancePage walletHubInsurancePage;

    @BeforeMethod
    public void Initialize() {
        walletHubInsurancePage = new WalletHubInsurancePage();
    }

    @Test
    public void shouldNavigateToInsurancePage() {
        walletHubInsurancePage.assertHeader();
    }

    @Test
    public void shouldHighlightReviewStarOnHover() {
        walletHubInsurancePage.assertReviewStarHighlightedOnHover();
    }

    @Test
    public void shouldSubmitReviewSuccessfully() {
        walletHubInsurancePage.assertReviewSubmittedSuccessfully();
    }
}
