# Kotlin MVMM for Beginners


> 1- At first, we created the project and set the activity_main.xml

> 2- We must set the Data Binding to use MVMM structure.
Basically, it is to send data to the design area. It provides ease for design and class management with less coding.

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

> Now, data binding is ready to use.

> Then, How to access to design and visual objects 
```
   binding.<view's id>  
```



