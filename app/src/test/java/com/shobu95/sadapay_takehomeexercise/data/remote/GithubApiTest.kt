package com.shobu95.sadapay_takehomeexercise.data.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.shobu95.sadapay_takehomeexercise.data.source.remote.services.GithubRepoService
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.not
import org.hamcrest.Matchers.notNullValue
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.robolectric.annotation.Config
import javax.inject.Inject

@HiltAndroidTest
@Config(application = HiltTestApplication::class)
@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class GithubApiTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var hiltRule = HiltAndroidRule(this)


    @Inject
    lateinit var service: GithubRepoService

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun `1- github service instance should not be null`() {
        assertThat(service, notNullValue())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `2- api should return non-null response`() = runBlocking {
        val response = service.getTrendingRepos()
        assertThat(response, notNullValue())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `3- returned items in response should not be empty`() = runBlocking {
        val response = service.getTrendingRepos()
        assertThat(response.items.size, not(0))
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `4- first item of the returned response should have all values initialized`() =
        runBlocking {
            val response = service.getTrendingRepos()
            val githubRepoObj = response.items[0]
            assertThat(githubRepoObj.id, notNullValue())
            assertThat(githubRepoObj.repoName, notNullValue())
            assertThat(githubRepoObj.description, notNullValue())
            assertThat(githubRepoObj.language, notNullValue())
            assertThat(githubRepoObj.starCount, notNullValue())
            assertThat(githubRepoObj.owner.name, notNullValue())
            assertThat(githubRepoObj.owner.avatar, notNullValue())
        }

}