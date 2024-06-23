# Kotlin MVMM for Beginners

*I assume that you created the project and set your .xml as you wanted.*
---
---

At first, we must set the Data Binding 
What is Data Binding ?   =>   Basically, it is to send data to the design area. It provides ease for design and class management with less coding.

<div style="text-align: center;">
   <h1 style=font-size: 24px;"> Setting Data Binding </h1>
</div>
<center>This text will be centered</center>


## At first, We must set the Data Binding to use MVMM structure.


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



