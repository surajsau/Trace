package `in`.surajsau.trace.domain.mapper

import `in`.surajsau.trace.data.model.Owner
import `in`.surajsau.trace.data.model.Repo
import `in`.surajsau.trace.domain.model.OwnerType

fun Repo.mapToDomain() = `in`.surajsau.trace.domain.model.Repo(
    id = id,
    name = name,
    fullName = fullName,
    owner = owner.mapToDomain(),
    isPrivate = private,
    description = description,
    isForked = fork,
    languages = emptyList(),
    watchCount = watchersCount,
    forkCount = forksCount,
    starCount = starGazersCount
)

fun Owner.mapToDomain() = `in`.surajsau.trace.domain.model.Owner(
    id = id,
    name = login,
    url = htmlUrl,
    imageUrl = avatarUrl,
    type = OwnerType.from(strValue = type)
)
