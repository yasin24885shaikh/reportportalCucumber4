This repository to mimic reportportal issue


 [RxCachedThreadScheduler-3] ERROR com.epam.reportportal.service.Launch - [20] ReportPortal execution error
    com.epam.reportportal.exception.ReportPortalException: Report Portal returned error
    Status code: 400
    Status message: Bad Request
    Error Message: Test item status is ambiguous. There is no status provided from request and there are no descendants to check statistics for test item id '5de7e301f264de00018ab6d6'
    Error Type: AMBIGUOUS_TEST_ITEM_STATUS

        at com.epam.reportportal.service.ReportPortalErrorHandler.handleError(ReportPortalErrorHandler.java:57)
        at com.epam.reportportal.restendpoint.http.DefaultErrorHandler.handle(DefaultErrorHandler.java:56)
        at com.epam.reportportal.restendpoint.http.HttpClientRestEndpoint$1.call(HttpClientRestEndpoint.java:486)
        at com.epam.reportportal.restendpoint.http.HttpClientRestEndpoint$1.call(HttpClientRestEndpoint.java:455)
        at io.reactivex.internal.operators.maybe.MaybeFromCallable.subscribeActual(MaybeFromCallable.java:46)
        at io.reactivex.Maybe.subscribe(Maybe.java:3727)
        at io.reactivex.internal.operators.maybe.MaybeCache.subscribeActual(MaybeCache.java:77)
        at io.reactivex.Maybe.subscribe(Maybe.java:3727)
        at io.reactivex.internal.operators.maybe.MaybeSubscribeOn$SubscribeTask.run(MaybeSubscribeOn.java:54)
        at io.reactivex.Scheduler$DisposeTask.run(Scheduler.java:452)
        at io.reactivex.internal.schedulers.ScheduledRunnable.run(ScheduledRunnable.java:61)
        at io.reactivex.internal.schedulers.ScheduledRunnable.call(ScheduledRunnable.java:52)
        at java.util.concurrent.FutureTask.run(FutureTask.java:266)
        at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.access$201(ScheduledThreadPoolExecutor.java:180)
        at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:293)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
        at java.lang.Thread.run(Thread.java:748)

