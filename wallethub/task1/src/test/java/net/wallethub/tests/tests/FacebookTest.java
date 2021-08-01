package net.wallethub.tests.tests;

import net.wallethub.tests.pages.FacebookHomePage;
import org.testng.annotations.Test;
import org.testng.asserts.*;

import net.wallethub.tests.pages.FacebookHomePage;

/**
 * Unit test for simple App.
 */
public class FacebookTest extends BaseTest {

    @Test
    public void shouldPostAStatusMessage() {
        FacebookHomePage facebookHomePage = new FacebookHomePage();
        facebookHomePage.postStatus();

    }
}
