package net.angelco.task2.tests;

import net.angelco.task2.pages.WalletHubInsurancePage;

import java.beans.Transient;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class WalletHubTest {

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
}