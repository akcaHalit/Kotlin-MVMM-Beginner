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

# SEND DATA to the View Page

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








