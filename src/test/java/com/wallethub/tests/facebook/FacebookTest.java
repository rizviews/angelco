package com.wallethub.tests.facebook;

import org.testng.annotations.Test;
import com.wallethub.tests.BaseTest;

import com.wallethub.pages.facebook.*;;

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
