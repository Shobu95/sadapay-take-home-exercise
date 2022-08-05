package com.shobu95.sadapay_takehomeexercise.data.local

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.shobu95.sadapay_takehomeexercise.data.source.local.dao.GithubRepoDao
import com.shobu95.sadapay_takehomeexercise.data.source.local.database.GithubRepoDatabase
import com.shobu95.sadapay_takehomeexercise.data.source.local.entity.GithubRepoEntity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.notNullValue
import org.junit.*
import org.junit.Assert.assertEquals
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.robolectric.annotation.Config
import javax.inject.Inject

@HiltAndroidTest
@Config(application = HiltTestApplication::class)
@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class GithubRepoDatabaseTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var db: GithubRepoDatabase

    @Inject
    lateinit var dao: GithubRepoDao

    @Before
    fun init() {
        hiltRule.inject()
    }


    @Test
    fun `1- should initialize database`() {
        assertThat(db, notNullValue())
    }

    @Test
    fun `2- should initialize github repo dao`() {
        assertThat(dao, notNullValue())
    }

    @Test
    fun `3- should insert list of repos with 2 items`() = runTest {

        val githubRepo1 = GithubRepoEntity(
            id = 1,
            repoName = "Crebits",
            authorName = "SHobu95",
            description = "personal practice project",
            language = "Kotlin",
            starsCount = 5,
            avatar = "this is an avatar url"
        )

        val githubRepo2 = GithubRepoEntity(
            id = 2,
            repoName = "Crebits-Compose",
            authorName = "arish-barish",
            description = "personal practice project",
            language = "Java",
            starsCount = 12,
            avatar = "this is an avatar url"
        )
        val githubRepos = listOf(githubRepo1, githubRepo2)

        CoroutineScope(Dispatchers.IO).launch {
            dao.insertAll(githubRepos)
            val size = dao.getAll().toList().size
            assertEquals(size, 2)
        }

    }

    @Test
    fun `4- conflict policy-should update repo with same id`() {
        val githubRepo1 = GithubRepoEntity(
            id = 1,
            repoName = "Crebits",
            authorName = "SHobu95",
            description = "personal practice project",
            language = "Kotlin",
            starsCount = 5,
            avatar = "this is an avatar url"
        )

        val githubRepo2 = GithubRepoEntity(
            id = 1,
            repoName = "Crebits-Compose",
            authorName = "arish-barish",
            description = "personal practice project",
            language = "Java",
            starsCount = 12,
            avatar = "this is an avatar url"
        )

        val githubRepos = listOf(githubRepo1)
        val githubReposUpdated = listOf(githubRepo2)

        CoroutineScope(Dispatchers.IO).launch {
            dao.insertAll(githubRepos)
            dao.insertAll(githubReposUpdated)
            val repo: GithubRepoEntity = dao.getAll().first()[0]
            assertEquals(repo.authorName, "arish-barish")
            assertEquals(repo.id, 1)
            assertEquals(repo.starsCount, 12)
        }
    }

    @After
    fun `close db`() {
        db.close()
    }


}