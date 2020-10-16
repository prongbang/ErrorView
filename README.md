# ErrorView for Android

## Installation

- Add the following repositories to your project/build.gradle file.

```
repositories {
   maven { url 'https://jitpack.io' }
}
```

- Add the following dependency to your project/app/build.gradle file.

```
dependencies {
    implementation 'com.github.prongbang::errorview:1.0.0'
}
```

## Used

- XML

```xml
<com.prongbang.widget.errorview.ErrorView
    android:id="@+id/cameraErrorView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:errorBackgroundColor="@color/gray"
    app:errorButtonText="ALLOW"
    app:errorIcon="@mipmap/ic_launcher_round"
    app:errorSubtitle="Allow camera permission to capture"
    app:errorTitle="CAMERA PERMISSION"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintTop_toTopOf="parent" />
```

- Kotlin

```kotlin
cameraErrorView.onButtonClickListener = {
    Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
}
```