# Paparazzi & Robolectric compatibility

This project includes both Paparazzi and Robolectric in the :app:sample: module.
There is one test file for each library, `PaparazziTest` and `RobolectricTest`.

Run the tests with `./gradlew app:sample:testDebug` and they both pass.

This indicates that Paparazzi and Robolectric are compatible in the same module
without any changes, as long as they are not used in the same file.

Attempting to use either the `RobolectricTestRunner` or `AndroidJunit4` runner
results in this error:

```
java.lang.UnsupportedOperationException: class redefinition failed: attempted to change the schema (add/remove fields)
	at java.instrument/sun.instrument.InstrumentationImpl.retransformClasses0(Native Method)
	at java.instrument/sun.instrument.InstrumentationImpl.retransformClasses(InstrumentationImpl.java:169)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:568)
	at net.bytebuddy.utility.Invoker$Dispatcher.invoke(Unknown Source)
	at net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForNonStaticMethod.invoke(JavaDispatcher.java:1028)
	at net.bytebuddy.utility.dispatcher.JavaDispatcher$ProxiedInvocationHandler.invoke(JavaDispatcher.java:1158)
	at net.bytebuddy.dynamic.loading.$Proxy57.retransformClasses(Unknown Source)
	at net.bytebuddy.dynamic.loading.ClassReloadingStrategy$Strategy$2.apply(ClassReloadingStrategy.java:399)
	at net.bytebuddy.dynamic.loading.ClassReloadingStrategy.load(ClassReloadingStrategy.java:227)
	at net.bytebuddy.dynamic.TypeResolutionStrategy$Passive.initialize(TypeResolutionStrategy.java:101)
	at net.bytebuddy.dynamic.DynamicType$Default$Unloaded.load(DynamicType.java:6166)
	at app.cash.paparazzi.agent.InterceptorRegistrar$addMethodInterceptors$1.invoke(InterceptorRegistrar.kt:34)
	at app.cash.paparazzi.agent.InterceptorRegistrar$addMethodInterceptors$1.invoke(InterceptorRegistrar.kt:22)
	at app.cash.paparazzi.agent.InterceptorRegistrar.registerMethodInterceptors(InterceptorRegistrar.kt:39)
	at app.cash.paparazzi.agent.AgentTestRule$apply$1.evaluate(AgentTestRule.kt:15)
	at org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)
	at org.robolectric.RobolectricTestRunner$HelperTestRunner$1.evaluate(RobolectricTestRunner.java:589)
	at org.robolectric.internal.SandboxTestRunner$2.lambda$evaluate$2(SandboxTestRunner.java:290)
	at org.robolectric.internal.bytecode.Sandbox.lambda$runOnMainThread$0(Sandbox.java:99)
	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635)
	at java.base/java.lang.Thread.run(Thread.java:833)
```
