package `in`.surajsau.trace.domain.repository

import `in`.surajsau.trace.data.api.UserApi
import `in`.surajsau.trace.domain.mapper.mapToDomain
import `in`.surajsau.trace.domain.model.User
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

interface UserRepository {

    fun fetchUser(): Completable

    fun watchUser(): Observable<User>
}

class UserRepositoryImpl @Inject constructor(
    private val api: UserApi
) : UserRepository {

    private val user = BehaviorSubject.create<User>()

    override fun fetchUser(): Completable {
        return api.user()
            .doOnSuccess { user.onNext(it.mapToDomain()) }
            .toCompletable()
    }

    override fun watchUser(): Observable<User> = user
}
