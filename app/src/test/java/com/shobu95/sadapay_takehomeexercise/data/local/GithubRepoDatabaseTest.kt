package com.shobu95.sadapay_takehomeexercise.data.local

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.shobu95.sadapay_takehomeexercise.data.source.local.dao.GithubRepoDao
import com.shobu95.sadapay_takehomeexercise.data.source.local.database.GithubRepoDatabase
import com.shobu95.sadapay_takehomeexercise.data.source.local.entity.GithubRepoEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.notNullValue
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class GithubRepoDatabaseTest {

    lateinit var db: GithubRepoDatabase
    lateinit var dao: GithubRepoDao

    @Before
    fun `initialize database instance`() {

        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context,
            GithubRepoDatabase::class.java
        ).build()

        dao = db.githubRepoDao
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