package com.example.gx60.semiproject;

import android.net.Uri;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by GX60 on 01/06/2017.
 */
public class ProfileActivityTest {

    @Rule
    private ActivityTestRule<Profile> profileTest = new ActivityTestRule<Profile>(Profile.class);
    private Profile profile = null;

    @Before
    public void setUp() throws Exception
    {
        profile = profileTest.getActivity();
    }

    @Test
    public void testLaunch()
    {
        Uri testURI = profile.getImageUri();
        assertNull(testURI);
    }

    @After
    public void tearDown() throws Exception
    {
        profile = null;
    }
}