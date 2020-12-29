package `in`.surajsau.trace.nintendo.ui.main

enum class TabItem(val title: String) {
    ALL_GAMES("すべて"),
    DISCOUNTED_GAMES("On sale"),
    RANKED_GAMES("Ranked games");

    companion object {
        fun tabAt(position: Int) = values()[position]
    }
}
