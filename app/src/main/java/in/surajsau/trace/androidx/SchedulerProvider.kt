package `in`.surajsau.trace.androidx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

interface SchedulerProvider {
    val io: Scheduler
    val ui: Scheduler
}

class SchedulerProviderImpl @Inject constructor() : SchedulerProvider {

    override val io: Scheduler
        get() = AndroidSchedulers.mainThread()

    override val ui: Scheduler
        get() = Schedulers.io()
}