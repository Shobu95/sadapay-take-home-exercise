package com.shobu95.sadapay_takehomeexercise.ui

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.shobu95.sadapay_takehomeexercise.ui.screen.GithubActivity
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters


@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class GithubActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule(GithubActivity::class.java)

    @Test
    fun `1-should-have-TopAppBar-with-Trending-title`() {
        composeTestRule
            .onNodeWithText("Trending")
            .assertIsDisplayed()
    }

    @Test
    fun `2-should-have-dropdown-menu-button-on-TopAppBar`() {
        composeTestRule
            .onNodeWithContentDescription("3 dots dropdown menu")
            .assertIsDisplayed()
    }

    @Test
    fun `3-should-have-toggle-theme-option-in-dropdown`() {
        composeTestRule
            .onNodeWithContentDescription("3 dots dropdown menu")
            .performClick()

        composeTestRule
            .onNodeWithText("Toggle Theme")
            .assertIsDisplayed()
    }

    @Test
    fun `4-should-show-error-view-when-internet-is-down-and-no-data-in-db`() {
        composeTestRule
            .onNodeWithText("Something went wrong...")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("An alien is probably blocking your signal")
            .assertIsDisplayed()
    }

    @Test
    fun `5-should-show-repos-list`() {

        Thread.sleep(5000)

        composeTestRule
            .onNodeWithTag("repos_list")
            .assertIsDisplayed()
    }
}