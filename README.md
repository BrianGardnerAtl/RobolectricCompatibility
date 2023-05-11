# Paparazzi & Robolectric compatibility

This project includes both Paparazzi and Robolectric in the :app:sample: module.
There is one test file for each library, `PaparazziTest` and `RobolectricTest`.

Run the tests with `./gradlew app:sample:testDebug` and they both pass.

This indicates that Paparazzi and Robolectric are compatible in the same module
without any changes, as long as they are not used in the same file.
