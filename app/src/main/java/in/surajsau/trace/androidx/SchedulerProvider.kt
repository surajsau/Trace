package `in`.surajsau.trace.androidx

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

interface SchedulerProvider {
    val io: Scheduler
    val ui: Scheduler
}

class SchedulerProviderImpl @Inject constructor() : SchedulerProvider {

    override val io: Scheduler
        get() = Schedulers.io()

    override val ui: Scheduler
        get() = AndroidSchedulers.mainThread()
}
