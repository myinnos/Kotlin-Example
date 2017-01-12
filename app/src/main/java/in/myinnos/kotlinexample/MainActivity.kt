package `in`.myinnos.kotlinexample

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*


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

        // you can create awesome custom layout using blow alert dialog code
        /*
        alert {
            customView {
                verticalLayout {
                    textView {
                        text = name
                        textColor = ContextCompat.getColor(context, R.color.colorPrimaryDark)
                        textSize = 14F
                    }
                    textView {
                        text = phoneNumber
                        textColor = resources.getColor(R.color.colorPrimary)
                        textSize = 12F
                    }

                    positiveButton("AWESOME!") { toast("Thank you!") }
                }
            }
        }.show()*/

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
