package car.copernic.pcanton.ejercicios

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
class Ejercicio8 : AppCompatActivity() {
    lateinit var etEmail: EditText
    lateinit var etSubject: EditText
    lateinit var etMessage: EditText
    lateinit var send: Button
    lateinit var attachment: Button
    lateinit var tvAttachment: TextView
    lateinit var email: String
    lateinit var subject: String
    lateinit var message: String
    lateinit var uri: Uri
    private val pickFromGallery:Int = 101
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio8)
        title = "KotlinApp"
        etEmail = findViewById(R.id.etTo)
        etSubject = findViewById(R.id.etSubject)
        etMessage = findViewById(R.id.etMessage)
        attachment = findViewById(R.id.btAttachment)
        tvAttachment = findViewById(R.id.tvAttachment)
        send = findViewById(R.id.btSend)
        send.setOnClickListener { sendEmail() }
        attachment.setOnClickListener {
            openFolder()
        }
    }
    private fun openFolder() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        intent.putExtra("return-data", true)
        startActivityForResult(Intent.createChooser(intent, "Complete action using"), pickFromGallery)
    }
    private fun sendEmail() {
        try {
            email = etEmail.text.toString()
            subject = etSubject.text.toString()
            message = etMessage.text.toString()
            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.type = "plain/text"
            emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
            emailIntent.putExtra(Intent.EXTRA_STREAM, uri)
            emailIntent.putExtra(Intent.EXTRA_TEXT, message)
            this.startActivity(Intent.createChooser(emailIntent, "Sending email..."))
        }
        catch (t: Throwable) {
            Toast.makeText(this, "Request failed try again: $t", Toast.LENGTH_LONG).show()
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == pickFromGallery && resultCode == RESULT_OK) {
            if (data != null) {
                uri = data.data!!
            }
            tvAttachment.text = uri.lastPathSegment
            tvAttachment.visibility = View.VISIBLE
        }
    }
}