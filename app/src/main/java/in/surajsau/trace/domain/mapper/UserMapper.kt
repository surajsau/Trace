package `in`.surajsau.trace.domain.mapper

import `in`.surajsau.trace.data.model.User

fun User.mapToDomain() = `in`.surajsau.trace.domain.model.User(
    id = id,
    imageUrl = imageUrl,
    profileUrl = profileUrl,
    name = name,
    company = company,
    location = location,
    email = email,
    bio = bio,
    blog = blog,
    followers = followers,
    following = following,
    publicRepos = publicRepos,
    totalPrivateRepos = totalPrivateRepos,
    collaborators = collaborators
)
