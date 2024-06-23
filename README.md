# Kotlin MVMM for Beginners

I assume that you created the project and set your .xml as you wanted.
---
---

At first, we must set the Data Binding 

What is Data Binding ?   =>   Basically, it is to send data to the design area. It provides ease for design and class management with less coding.

# Setting Data Binding


> Enable data binding in build.gradle.kts:
```
# in build.gradle.kts
 #android { ...
 buildFeatures{
        dataBinding = true
 }
 #...  }
```
> Change your xml file:
```
<layout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

# Your xml codes...
</layout>
```
> Set data binding for your activity: we provide the access.
```
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
    }
```

> Now, data binding is ready to use.     Then, How to access to design and visual objects 
```
   binding.<view's id>  
```

---

# EVENT HANDLE

> In your activity xml:
```
   # set the data and variable:
    <data>
        <variable name="MainActivityObject" type="com.example.kotlin_mvmm_beginner.MainActivity" />
    </data>
```
> In your Activity:
```
   # we should bind our objects:
    binding.mainActivityObject  = this
```


```
   # how to use:  for example button:
For this example, the function clickButtonAdd should be exists in MainActivity globally.
    <Button ...
        No Parameter: android:onClick="@{() ->  mainActivityObject.clickButtonAdd()}"
        With Parameter: android:onClick="@{() ->  mainActivityObject.clickButtonAdd(number1Text.getText().toString(),number2Text.getText().toString())}"
    ... />
```
---

# SEND DATA to the View Page(XML)

> Assume that you have a variable that: `<variable name="calculatedResult" type="String"/>`  
```
     <EditText ...
     android:text="@{calculatedResult}"
    ... />
```

> Now we don't need to use these ones: `binding.resultText.text = "0"`
```
     binding.calculatedResult = "0"
```

> We also can write our own codes on the View Page:   just for practicing
```
 android:textColor="@{Integer.parseInt(calculatedResult) > 50 ? @color/purple : @color/black }"
 android:visibility="@{Integer.parseInt(calculatedResult) > 1000000 ? View.INVISIBLE : View.VISIBLE }"
```

# VIEW MODEL

> Why ViewModel ?
- The main purpose of ViewModel is to organize data that will feed the interface.
- Additionally, it preserves data during page rotations (switching between portrait and landscape orientations).
- By separating interface (Activity) from data, we can create a more controlled structure.
- Within ViewModel, we can include operations to be performed on the page.
- In Activity, we transfer data to the interface.
- In ViewModel, tasks such as retrieving data from a database, performing mathematical operations on the interface, etc., can be done.
- We can use the LiveData structure to observe changes in data.

> Installation (build.gradle.kts):
```
# dependencies { ...
    implementation ("androidx.lifecycle:lifecycle-viewmodel:2.3.0")
    implementation ("androidx.activity:activity-ktx:1.2.0")
#...} 
```

## How to use ViewModel: 

> Create a new class that ..ActivityViewModel
<img width="441" alt="Screenshot 2024-06-23 at 22 57 20" src="https://github.com/akcaHalit/Kotlin-MVMM-Beginner/assets/103420587/1ff6c81c-b955-40b2-8d4d-c877f3f040b2">

> Transfer the data, operations: 
<img width="647" alt="Screenshot 2024-06-23 at 23 09 15" src="https://github.com/akcaHalit/Kotlin-MVMM-Beginner/assets/103420587/6f428d5d-0b44-4cc1-bf2d-d66c1b926ba1">


> Create and Bind: The variable(vievModel) that binds the Activity and its ViewModel:
```
# Create
    private val viewModel:MainActivityViewModel by viewModels()
# Bind
    binding.calculatedResult = viewModel.calculatedResult
```


# LIVE DATA

> Installation
```
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.8.2")
```

> Make your datas live:
```
   # In ViewModelActivity:
   var calculatedResult = MutableLiveData<String>()
   init {
        calculatedResult = MutableLiveData<String>("0")
    }
```
> Now, how to use your live datas in your ViewModel Activity:
```
  calculatedResult.value = result.toString()
```
> Now, how to use your live datas in your Activity:
```
  # observe your live datas
   viewModel.calculatedResult.observe(this,  { lambdaresult ->
      binding.calculatedResult = lambdaresult
   })
```
> And so, you can't use binding:         binding.calculatedResult = viewModel.calculatedResult
```
  fun clickButtonMultiply(number1Text: String, number2Text: String){
    viewModel.clickButtonMultiply(number1Text,number2Text)
    // before livedata: binding.calculatedResult = viewModel.calculatedResult     
  }
```




