## Kotlin MVVM for Beginners 🚀

Assuming you have created your project and set up your XML as desired.

---

### Setting Up Data Binding 🔗

#### What is Data Binding?
Data Binding allows you to bind UI components in your layouts to data sources in your app using a declarative format rather than programmatically. This reduces boilerplate code and makes the code more maintainable.

#### Enabling Data Binding 🛠️
In `build.gradle.kts`:
```kotlin
android {
    ...
    buildFeatures {
        dataBinding = true
    }
    ...
}
```

In your XML layout:
```xml
<layout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <!-- Your XML code -->
</layout>
```

In your activity:
```kotlin
private lateinit var binding: ActivityMainBinding

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
}
```

Now you can access views through `binding.<view_id>`. 🎉

---

### Event Handling 🔄

In your activity's XML:
```xml
<data>
    <variable
        name="mainActivityObject"
        type="com.example.kotlin_mvvm_beginner.MainActivity" />
</data>
```

In your activity:
```kotlin
binding.mainActivityObject = this
```

Example for a button click:
```xml
<Button
    ...
    android:onClick="@{() -> mainActivityObject.clickButtonAdd()}"
    ... />
```

---

### Sending Data to the View (XML) 📤

If you have a variable:
```xml
<variable
    name="calculatedResult"
    type="String" />
```

Bind it to a view:
```xml
<EditText
    ...
    android:text="@{calculatedResult}"
    ... />
```

Update the variable in your code:
```kotlin
binding.calculatedResult = "0"
```

You can also use expressions in your XML:
```xml
android:textColor="@{Integer.parseInt(calculatedResult) > 50 ? @color/purple : @color/black}"
android:visibility="@{Integer.parseInt(calculatedResult) > 1000000 ? View.INVISIBLE : View.VISIBLE}"
```

---

### ViewModel 🧠

#### Why Use ViewModel?
- Organizes data for the interface.
- Preserves data during configuration changes.
- Separates UI logic from data management.
- Allows operations to be performed within ViewModel.

#### Setting Up ViewModel 🚀

In `build.gradle.kts`:
```kotlin
dependencies {
    ...
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.3.0")
    implementation("androidx.activity:activity-ktx:1.2.0")
    ...
}
```

Create a ViewModel class:
```kotlin
class MainActivityViewModel : ViewModel() {
    // ViewModel logic
}
```

In your activity:
```kotlin
private val viewModel: MainActivityViewModel by viewModels()
binding.calculatedResult = viewModel.calculatedResult
```

---

### LiveData 📡

#### Setting Up LiveData

In `build.gradle.kts`:
```kotlin
dependencies {
    ...
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.2")
    ...
}
```

In your ViewModel:
```kotlin
class MainActivityViewModel : ViewModel() {
    val calculatedResult = MutableLiveData<String>().apply { value = "0" }
}
```

Observe LiveData in your activity:
```kotlin
viewModel.calculatedResult.observe(this, { result ->
    binding.calculatedResult = result
})
```

Handle button clicks in your activity:
```kotlin
fun clickButtonMultiply(number1Text: String, number2Text: String) {
    viewModel.clickButtonMultiply(number1Text, number2Text)
}
```

This structure will help beginners to set up and understand Kotlin MVVM architecture effectively. 🚀
