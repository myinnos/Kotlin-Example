# [Kotlin Example](https://myinnos.github.io/Kotlin-Example/ "View Website - Kotlin Example")

Here is an example for who are all going to start learning Kotlin programming language to develop  Android application.

First check [this](https://play.google.com/store/apps/details?id=in.myinnos.kotlinexample "Kotlin Example - Android") example APK to understand basic steps easily. I enjoyed a lot while doing this tutorial, If your Java developer you can play with this. *Happy Coding!*

[![Get it on Google Play](https://s19.postimg.org/5wroedueb/ic_launcher.png)](https://play.google.com/store/apps/details?id=in.myinnos.kotlinexample)

[Kotlin](https://kotlinlang.org/ "Kotlin") is very lightweight, its run-time library is under 400K minus the ProGuard minification. Also, installation is very simple. All you have to do is browse the plugin repository and get the official Kotlin plugin. You also had to install Kotlin Android Extensions as well, required for Android of course, but not until recently it has been merged with the Kotlin plugin and is now obsolete.


	Settings > Plugins > Browse Repositories > Search Kotlin and install

To configure Kotlin in your project, convert any source file to Kotlin first.


	Select a Java file > Hit Ctrl+Shift+A > “convert to kotlin” Hit enter
    
Take a look [here](https://kotlinlang.org/docs/tutorials/kotlin-android.html "Kotlin Tutorial - Android") for screenshots and brief explanation.   

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
Started by letting Gradle know some dependencies, one set for the Support Library, another for the Kotlin run-time, and one more set for Anko obviously.

###### Reference those dependencies
```java
final SUPPORT_VERSION = '23.3.0'
final ANKO_VERSION = '0.8.3'

dependencies {
    compile fileTree(include: ['*.jar'], dir: 'libs')
    compile "com.android.support:appcompat-v7:${SUPPORT_VERSION}"
    compile "com.android.support:recyclerview-v7:${SUPPORT_VERSION}"
    compile "org.jetbrains.anko:anko-sdk15:${ANKO_VERSION}"
    compile "org.jetbrains.anko:anko-appcompat-v7:${ANKO_VERSION}"
    compile "org.jetbrains.anko:anko-recyclerview-v7:${ANKO_VERSION}"
    compile "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
}
```
One thing to be noted here, the Anko base library, i.e., the anko-sdk* lib, you should add on the basis of your minimum SDK version and the rest of the other dependencies, you add on the basis of the Support Library that you wish to extend with Anko. For instance, add anko-design for design, which is from the Support Library.


## Example

 ![Kotlin Example - Splashscreen](https://s19.postimg.org/6h6ph2nmr/Kotlin_Example_Splashscreen.png) ![Kotlin Example - MainScreen](https://s19.postimg.org/8j76vbllv/Kotlin_Example_Main_Screen.png) ![Kotlin Example - Menu](https://s19.postimg.org/4o3ssr2g3/Kotlin_Example_Menu.png) ![Kotlin Example - WebView](https://s19.postimg.org/ol9q1plb7/Kotlin_Example_Web_View.png)

#### SplashScreenActivity.kt

Splash screen is one of the friend for android developers will see most of the times this screen while developing interesting concepts. Here you can see how Splashscreen code looks interms of Kotlin.

*Note: Here i followed [this](https://www.bignerdranch.com/blog/splash-screens-the-right-way/ "Splash screens the right way") tutorial to create express splashscreen.*

```java
class : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Start main activity
        startActivity(Intent(this, MainActivity::class.java))

        // close this activity
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out)
        finish()
    }

}
```

###### Some Awesome methods/functions

##### Variable declaration. int/string/boolean

```java
var EMAIL_ID = "contact@myinnos.in"
```

##### To open Web URL

```java
browse(GIT_HUB_URL)
```

##### setText function

```java
tvHeader.text = HEADER_TEXT
```

##### Hint to Edit Text

```java
etName.hint = EDIT_TEXT_NAME_HINT
```

##### Toast 

```java
toast("Activity restarted!")
```

##### Email Intent  

```java
email(EMAIL_ID, "subject")
```

##### Share Intent 

```java
share("text")
```

##### Function declaration, function to get text length of edit text 

```java
fun checkTextLength(editText: EditText): Boolean {
        var length = editText.length()
        if (length > 0)
            return true
        else
            return false
}
```

##### onClick funtion

```java
btDone.onClick {
            hideKeyboard()
            if (!checkTextLength(etName) || !checkTextLength(etMobile))
                toast("Fields cannot be empty!")
            else
                onButtonClicks()
}
```

##### Dialog Aleart Box 

```java
fun openAlertDialog(name: String, phoneNumber: String) {

        val countries = listOf("Russia", "India", "USA", "Japan", "China")

        selector("Where are you from?", countries) { i ->
            alert("One more thing! You have entered this number " + phoneNumber, name + "! So you're living in ${countries[i]}, right?")            {
                customView {
                    verticalLayout {
                        positiveButton("AWESOME!") {
                            longToast("Thank you!")
                        }
                    }
                }

            }.show()
}
```

##### Initializing menu options 

```java
 override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu_main, menu)
        return true
    }

 override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.getItemId()
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_rate) {
            // opining browser intent
            browse(PLAY_STORE_URL)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
```

#### MainActivity.kt

Main screen, The wall where Android developer paint and repair. Here you can observe the code how plain and simple. Basically i started loving Kotlin while writing this class.  

*Note: I used [Google Custom Tabs](https://developer.chrome.com/multidevice/android/customtabs "Google Custom Tabs") library to understand how third party java libraries will work with Kotlin.*

```java
class MainActivity : AppCompatActivity() {

    var HEADER_TEXT = "You can try awesome example!"
    var EDIT_TEXT_NAME_HINT = "enter name"
    var EDIT_TEXT_NUMBER_HINT = "enter number"
    var EMAIL_ID = "contact@myinnos.in"
    var GIT_HUB_URL = "https://github.com/myinnos/Kotlin-Example"
    var GIT_HUB_WEB_URL = "https://myinnos.github.io/Kotlin-Example/";
    var PLAY_STORE_URL = "market://details?id=" + BuildConfig.APPLICATION_ID

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // setting header text
        tvHeader.text = HEADER_TEXT
        // setting hint for edit text
        etName.hint = EDIT_TEXT_NAME_HINT
        etMobile.hint = EDIT_TEXT_NUMBER_HINT

        // setting drawable image to image view
        imageView.resources.getDrawable(R.mipmap.ic_launcher)

        // onclick event for image view to restart activity (Intent function)
        imageView.onClick {
            startActivity<SplashScreenActivity>()
            finish()
            toast("Activity restarted!")
        }

        // onclick event for button
        btDone.onClick {
            hideKeyboard()
            if (!checkTextLength(etName) || !checkTextLength(etMobile))
                toast("Fields cannot be empty!")
            else
                onButtonClicks()
        }

        btGitHubLink.onClick {
            // opining browser intent
            browse(GIT_HUB_URL)
        }

        btTutorial.onClick {
            // google custom tabs
            val builder = CustomTabsIntent.Builder()
            builder.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary))
            val customTabsIntent = builder.build()
            customTabsIntent.launchUrl(this, Uri.parse(GIT_HUB_WEB_URL))
        }
    }

    // function to get text from edit text
    fun EditText.textValue(): String {
        return text.toString()
    }

    // function to get text length of edit text
    fun checkTextLength(editText: EditText): Boolean {

        var length = editText.length()

        if (length > 0)
            return true
        else
            return false
    }

    // function to hide keyboard
    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }

    }

    fun onButtonClicks() {
        //using function
        val phoneNumber = etMobile.textValue()
        // direct access
        val name = etName.text.toString()
        // calling alert dialog
        openAlertDialog(name, phoneNumber)
    }

    fun openAlertDialog(name: String, phoneNumber: String) {

        val countries = listOf("Russia", "India", "USA", "Japan", "China")

        selector("Where are you from?", countries) { i ->
            //toast("So you're living in ${countries[i]}, right?")
            alert("One more thing! You have entered this number " + phoneNumber, name + "! So you're living in ${countries[i]}, right?") {
                customView {
                    verticalLayout {
                        positiveButton("AWESOME!") {
                            longToast("Thank you!")
                        }
                    }
                }

            }.show()

        }
    }

    // Initializing menu options
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item!!.getItemId()

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_share) {
            // sharing intent
            share(getString(R.string.share_text) + BuildConfig.APPLICATION_ID,
                    getString(R.string.app_name))
            return true
        } else if (id == R.id.action_feedback) {
            // email intent
            email(EMAIL_ID, getString(R.string.app_name))
            return true
        } else if (id == R.id.action_rate) {
            // opining browser intent
            browse(PLAY_STORE_URL)
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
```

### Conclusion
Kotlin is overall a great language. It is much less verbose than Java, and has an excellent standard library that removes the need to use a lot of the libraries that make Java life bearable. Converting an app from Java to Kotlin is made much easier thanks to automated syntax conversion, and the result is almost always an improvement. If you’re an Android developer, you owe it to yourself to give it a try.

##### Any Queries? or Feedback, please let me know by opening a [new issue](https://github.com/myinnos/Kotlin-Example/issues/new)!

## Contact

### Prabhakar Thota
* :globe_with_meridians: Website: [myinnos.in](http://www.myinnos.in "Prabhakar Thota")
* :email: e-mail: contact@myinnos.in
* :mag_right: LinkedIn: [PrabhakarThota](https://www.linkedin.com/in/prabhakarthota "Prabhakar Thota on LinkedIn")
* :thumbsup: Twitter: [@myinnos](https://twitter.com/myinnos "Prabhakar Thota on twitter")

License
-------

    Copyright 2017 MyInnos

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
