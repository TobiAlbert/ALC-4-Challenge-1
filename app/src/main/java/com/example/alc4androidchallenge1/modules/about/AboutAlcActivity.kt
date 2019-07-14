package com.example.alc4androidchallenge1.modules.about

import android.net.http.SslError
import android.os.Bundle
import android.view.View
import android.webkit.SslErrorHandler
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.webkit.WebViewClientCompat
import com.example.alc4androidchallenge1.R
import com.example.alc4androidchallenge1.shared.ANDELA_ABOUT_URL
import kotlinx.android.synthetic.main.activity_about_alc.*
import kotlinx.android.synthetic.main.toolbar.*

class AboutAlcActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_alc)

        setupUI()
    }

    private fun setupUI() {
        // setup toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.about_alc_text)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // setup web view
        webview.apply {
            webViewClient = createWebViewClient()
            settings.loadsImagesAutomatically = true
            settings.setAppCacheEnabled(true)
            settings.domStorageEnabled = true
            scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY

            showLoading(true)

            loadUrl(ANDELA_ABOUT_URL)
        }
    }

    override fun onBackPressed() {
        if (webview.canGoBack()) webview.goBack()
        else super.onBackPressed()
    }

    private fun createWebViewClient(): WebViewClient {
        return object : WebViewClientCompat() {

            override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
                AlertDialog.Builder(this@AboutAlcActivity)
                    .setTitle(R.string.title_ssl_error)
                    .setMessage(R.string.text_ssl_error)
                    .setPositiveButton(R.string.proceed) { dialogInterface, _ ->
                        handler?.proceed()
                        dialogInterface.dismiss()
                    }
                    .setNegativeButton(R.string.cancel) { dialogInterface, _ ->
                        dialogInterface.dismiss()

                        // hide loading indicator
                        showLoading(false)
                    }
                    .create()
                    .show()
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)

                // hide loading indicator
                showLoading(false)
            }
        }
    }

    private fun showLoading(isLoading: Boolean) {
        progressBar.visibility = when (isLoading) {
            true -> View.VISIBLE
            else -> View.GONE
        }
    }
}
