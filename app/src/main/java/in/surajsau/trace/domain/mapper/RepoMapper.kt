package `in`.surajsau.trace.domain.mapper

import `in`.surajsau.trace.data.model.Repo

fun Repo.mapToDomain() = `in`.surajsau.trace.domain.model.Repo(
    id = id,
    name = name,
    fullName = fullName,
    owner = owner.mapToDomain(),
    isPrivate = private,
    description = description,
    fork = fork
)
