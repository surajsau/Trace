package `in`.surajsau.trace.ui.profile

import `in`.surajsau.trace.domain.model.User

data class ProfileFragmentModel(
    val profileName: String,
    val profileHandle: String,
    val profileImage: String,
    val profileOrganisation: String,
    val profileLocation: String,
    val repositoryCount: Int
)

fun User.toProfileFragmentModel() = ProfileFragmentModel(
    profileName = this.name,
    profileHandle = this.handle,
    profileImage = this.imageUrl,
    profileOrganisation = this.company ?: "",
    profileLocation = this.location ?: "",
    repositoryCount = this.totalPrivateRepos + this.publicRepos,
)
