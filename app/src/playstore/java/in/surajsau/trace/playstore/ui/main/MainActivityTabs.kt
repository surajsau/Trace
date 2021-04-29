package `in`.surajsau.trace.playstore.ui.main

import `in`.surajsau.trace.R
import java.io.Serializable

sealed class MainActivityTabs(val tabs: List<MainActivityTab>, val searchCardTextRes: Int, val colorRes: Int) : Serializable {

    object GameTabs : MainActivityTabs(
        tabs = listOf(GamesForYou, GamesTop, GamesKids, GamesPremium, GamesCategories, GamesEditorChoice),
        searchCardTextRes = R.string.search_games,
        colorRes = R.color.tab_games
    )

    object AppsTabs : MainActivityTabs(
        tabs = listOf(AppsForYou, AppsTop, AppsKids, AppsCategories, AppsEditorChoice),
        searchCardTextRes = R.string.search_apps,
        colorRes = R.color.tab_apps
    )

    object MoviesTabs : MainActivityTabs(
        tabs = listOf(MoviesForYou, MoviesTop, MoviesNewReleases, MoviesGenres, MoviesStudios),
        searchCardTextRes = R.string.search_movies,
        colorRes = R.color.tab_movies
    )

    object BooksTabs : MainActivityTabs(
        tabs = listOf(EBooks, AudioBooks, Comics, BooksGenre, BooksTop, BooksNewReleases, BooksTopFree),
        searchCardTextRes = R.string.search_books,
        colorRes = R.color.tab_books
    )
}

sealed class MainActivityTab(val title: String) : Serializable

object GamesForYou : MainActivityTab("For you")
object GamesTop : MainActivityTab("Top charts")
object GamesKids : MainActivityTab("Kids")
object GamesPremium : MainActivityTab("Premium")
object GamesCategories : MainActivityTab("Categories")
object GamesEditorChoice : MainActivityTab("Editor's choice")

object AppsForYou : MainActivityTab("For you")
object AppsTop : MainActivityTab("Top charts")
object AppsKids : MainActivityTab("Kids")
object AppsCategories : MainActivityTab("Categories")
object AppsEditorChoice : MainActivityTab("Editor's choice")

object MoviesForYou : MainActivityTab("For you")
object MoviesTop : MainActivityTab("Top selling")
object MoviesNewReleases : MainActivityTab("New releases")
object MoviesGenres : MainActivityTab("Genres")
object MoviesStudios : MainActivityTab("Studios")

object EBooks : MainActivityTab("Ebooks")
object AudioBooks : MainActivityTab("Audiobooks")
object Comics : MainActivityTab("Comics")
object BooksGenre : MainActivityTab("Genres")
object BooksTop : MainActivityTab("Top selling")
object BooksTopFree : MainActivityTab("Top free")
object BooksNewReleases : MainActivityTab("New releases")
