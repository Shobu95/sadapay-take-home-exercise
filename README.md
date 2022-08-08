# Sadapay - Take Home Coding Exercise

## Introduction
This test project contains all functionality that was requested in the document, along with some unit tests for each layer and UI tests for the activity that the project contains. More details are mentioned below.

### Developed Using
- Kotlin
- Jetpack Compose
- Hilt
- ViewModel
- Coroutines
- Room
- Retrofit
- Coil (Image Loading)
- Lottie-Compose (Lottie Animation)
- Accompanist (for swipe refresh)

### Test written for
- Data layer
  - Local data source
  - Remote data source
- Repository Layer
- UseCase Layer
- ViewModel
- Ui Tests for GithubActivity

### Testing Libraries Used
- Junit4
- Hamcrest (for readable assertions)
- Experimental Coroutines API
- Hilt-Testing library used for performing Dependency Injection in unit tests
- Compose UI testing
- Roboelectric


## Architecture
Application is built using Clean-MVVM and Modern Android Architecture, consisting of Repository layer, which uses local (Room DB) and remote (Retrofit) data sources, UseCase Layer containing business logic, ViewModel and finally a Composable UI. The ViewModel and UI communicate through state and events. UI send events to ViewModel and UI observes the state from the ViewModel.
Separate Data classes have been made for each layer and data source.
- Entity for Room DB (can be mapped to Domain Model)
- DTO for Retrofit (can be mapped to Entity/Database Model)
- Domain Model (normal data class used for displaying data)


## Things to note: 
- If the user uses swipe-refresh while the list is loaded and the API call fails, in this case the app will show the error view because the user has explicitly requested data from the remote data source. The data from the local source will not be shown. 
- If the internet or the API is down and the data is present in the local source, the data from the local source will be shown (with the cached images), unless the user refreshes it or clear the cache from settings.


## References:
**Modern Android Architecture**: https://developer.android.com/topic/architecture

**Repository Pattern:** https://developer.android.com/codelabs/basic-android-kotlin-training-repository-pattern#0

**Clean-MVVM:** https://www.youtube.com/watch?v=8YPXv7xKh2w&t=1322s **by Philipp Lackner**

**Shimmer**: https://www.section.io/engineering-education/creating-custom-animated-shimmer-effect-with-jetpack-compose/

**Swipe Refresh:** https://google.github.io/accompanist/swiperefresh/

**Testing:**

https://developer.android.com/training/data-storage/room/testing-db

https://developer.android.com/jetpack/compose/testing

https://developer.android.com/codelabs/jetpack-compose-testing









