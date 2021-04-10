package `in`.surajsau.trace.playstore.ui.main

sealed class MainActivityTabs(val tabs: List<MainActivityTab>) {

    object GameTabs : MainActivityTabs(
        tabs = listOf(GamesForYou, GamesTop, GamesKids, GamesPremium, GamesCategories, GamesEditorChoice)
    )

    object AppsTabs : MainActivityTabs(
        tabs = listOf(AppsForYou, AppsTop, AppsKids, AppsCategories, AppsEditorChoice)
    )

    object MoviesTabs : MainActivityTabs(
        tabs = listOf(MoviesForYou, MoviesTop, MoviesNewReleases, MoviesGenres, MoviesStudios)
    )
}

sealed class MainActivityTab(val title: String)

object GamesForYou : MainActivityTab("For You")
object GamesTop : MainActivityTab("Top Charts")
object GamesKids : MainActivityTab("Kids")
object GamesPremium : MainActivityTab("Premium")
object GamesCategories : MainActivityTab("Categories")
object GamesEditorChoice : MainActivityTab("Editor's Choice")

object AppsForYou : MainActivityTab("For You")
object AppsTop : MainActivityTab("Top Charts")
object AppsKids : MainActivityTab("Kids")
object AppsCategories : MainActivityTab("Categories")
object AppsEditorChoice : MainActivityTab("Editor's Choice")

object MoviesForYou : MainActivityTab("For You")
object MoviesTop : MainActivityTab("Top Selling")
object MoviesNewReleases : MainActivityTab("New Releases")
object MoviesGenres : MainActivityTab("Genres")
object MoviesStudios : MainActivityTab("Studios")
