# [Kotlin Example](https://myinnos.github.io/Kotlin-Example/ "View Website - Kotlin Example")

Here is an example for who are all going to start learning Kotlin programming language to develop  Android application.

First check [this](https://play.google.com/store/apps/details?id=in.myinnos.fansfolio "Kotlin Example - Android") example APK to understand basic steps easily. I enjoyed alot while doing this tutorial, If your Java developer you can play with this. *Happy Coding!*

[![Get it on Google Play](https://raw.github.com/repat/README-template/master/googleplay.png)](https://play.google.com/store/apps/details?id=in.myinnos.fansfolio)

[Kotlin](https://kotlinlang.org/ "Kotlin") is very lightweight, its runtime library is under 400K minus the ProGuard minification. Also, installation is very simple. All you have to do is browse the plugin repository and get the official Kotlin plugin. You also had to install Kotlin Android Extensions as well, required for Android of course, but not until recently it has been merged with the Kotlin plugin and is now obsolete.


	Settings > Plugins > Browse Repositories > Search Kotlin and install

To configure Kotlin in your project, convert any source file to Kotlin first.


	Select a Java file > Hit Ctrl+Shift+A > “convert to kotlin” Hit enter
    
Take a look [here](https://kotlinlang.org/docs/tutorials/kotlin-android.html "Kotlin Tutorial - Android") for screenshorts and breif explanation.   

##### Android UI With Anko
[Anko](https://github.com/Kotlin/anko "Anko") is a library made in Kotlin that is a great utility for Android development. It consists of DSL wrappers and other nice extensions that make development easier. The prime value of Anko is that it allows you to embed UI layouts inside your source code, which makes it type-safe and allows programmatic transformation.

Just a brief example. Here is a "hello world" written with Anko:

```java
verticalLayout {
    val name = editText()
    button("Say Hello") {
        onClick { toast("Hello, ${name.text}!") }
    }
}
```
Started by letting Gradle know some dependencies, one set for the Support Library, another for the Kotlin runtime, and one more set for Anko obviously.

###### Reference those dependencies

	final SUPPORT_VERSION = '23.3.0'
	final ANKO_VERSION = '0.8.3'

	dependencies {
    compile fileTree(include: ['*.jar'], dir: 'libs')
    testCompile 'junit:junit:4.12'
    compile "com.android.support:appcompat-v7:${SUPPORT_VERSION}"
    compile "com.android.support:recyclerview-v7:${SUPPORT_VERSION}"
    compile "org.jetbrains.anko:anko-sdk15:${ANKO_VERSION}"
    compile "org.jetbrains.anko:anko-appcompat-v7:${ANKO_VERSION}"
    compile "org.jetbrains.anko:anko-recyclerview-v7:${ANKO_VERSION}"
    compile "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
	}

One thing to be noted here, the Anko base library, i.e., the anko-sdk* lib, you should add on the basis of your minimum SDK version and the rest of the other dependencies, you add on the basis of the Support Library that you wish to extend with Anko. For instance, add anko-design for design, which is from the Support Library.


## Example

##### *Comming soon ...* (Want to help me?, please let me know by opening a [new issue](https://github.com/myinnos/Kotlin-Example/issues/new)!)

## Contact
#### Prabhakar Thota
* Website: [myinnos.com](https://myinnos.in "Prabhakar Thota")
* e-mail: contact@myinnos.in
* Twitter: [@myinnos](https://twitter.com/myinnos "Prabhakar Thota on twitter")

