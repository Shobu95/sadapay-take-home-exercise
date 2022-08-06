package com.shobu95.sadapay_takehomeexercise.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.shobu95.sadapay_takehomeexercise.core.di.GithubRepositoryImpl
import com.shobu95.sadapay_takehomeexercise.domain.model.GithubRepo
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.nullValue
import org.junit.Assert.assertNotNull
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
class GithubRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @GithubRepositoryImpl
    @Inject
    lateinit var repository: GithubRepoRepository

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun `1- repository instance should not be null`() {
        assertNotNull(repository)
    }

    @Test
    fun `2- repository should not have any data when getting first `() {
        var repoList: List<GithubRepo>? = null
        CoroutineScope(Dispatchers.IO).launch {
            repoList = repository.getAll().toList()[0]
        }
        assertThat(repoList, nullValue())

    }

}