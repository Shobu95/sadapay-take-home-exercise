package com.shobu95.sadapay_takehomeexercise.ui

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.shobu95.sadapay_takehomeexercise.domain.use_case.GithubReposUseCase
import com.shobu95.sadapay_takehomeexercise.ui.screen.GithubViewModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.robolectric.annotation.Config
import javax.inject.Inject

@HiltAndroidTest
@Config(application = HiltTestApplication::class)
@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class GithubViewModelTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var useCase: GithubReposUseCase
    lateinit var viewModel: GithubViewModel


    @Before
    fun init() {
        hiltRule.inject()
        viewModel = GithubViewModel(useCase)
    }

    @Test
    fun `1- useCase instance should be initialized`() {
        Assert.assertNotNull(viewModel)
    }


}