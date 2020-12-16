package `in`.surajsau.trace.ui.profile

import `in`.surajsau.trace.domain.model.User

data class ProfileFragmentModel(
    val profileName: String,
    val profileImage: String,
    val profileOrganisation: String,
    val profileLocation: String
)

fun User.toProfileFragmentModel() = ProfileFragmentModel(
    profileName = this.name,
    profileImage = this.imageUrl,
    profileOrganisation = this.company,
    profileLocation = this.location
)
