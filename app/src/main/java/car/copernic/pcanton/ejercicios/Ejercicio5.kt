package car.copernic.pcanton.ejercicios


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*


class Ejercicio5 : AppCompatActivity(), TextToSpeech.OnInitListener {

    lateinit var txTextoAVoz: EditText
    lateinit var btParla: Button
    lateinit var tts: TextToSpeech
    lateinit var tvMissatges: TextView
    lateinit var boton1: Button
    lateinit var boton2: Button
    lateinit var boton3: Button
    lateinit var boton4: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio5)

        txTextoAVoz = findViewById(R.id.txTextoAVoz);
        tvMissatges = findViewById(R.id.tvMissatges);
        btParla = findViewById(R.id.btParla)
        boton1 = findViewById(R.id.button1)
        boton2 = findViewById(R.id.button2)
        boton3 = findViewById(R.id.button3)
        boton4 = findViewById(R.id.button4)

        btParla.isEnabled = false
        boton1.isEnabled = false
        boton2.isEnabled = false
        boton3.isEnabled = false
        boton4.isEnabled = false

        txTextoAVoz.setText("hola, que tal, como estamos")

        tts = TextToSpeech(this, this)

        val speechListener = object : UtteranceProgressListener() {
            override fun onStart(p: String?) {
                btParla.post {
                    if( p != null ) tvMissatges.text = "Iniciat: $p"
                    else tvMissatges.text = "Iniciat"
                    btParla.isEnabled = false
                    boton1.isEnabled = false
                    boton2.isEnabled = false
                    boton3.isEnabled = false
                    boton4.isEnabled = false                }
                boton1.post {
                    if( p != null ) tvMissatges.text = "Iniciat: $p"
                    else tvMissatges.text = "Iniciat"
                    btParla.isEnabled = false
                    boton1.isEnabled = false
                    boton2.isEnabled = false
                    boton3.isEnabled = false
                    boton4.isEnabled = false
                }
                boton2.post {
                    if( p != null ) tvMissatges.text = "Iniciat: $p"
                    else tvMissatges.text = "Iniciat"
                    btParla.isEnabled = false
                    boton1.isEnabled = false
                    boton2.isEnabled = false
                    boton3.isEnabled = false
                    boton4.isEnabled = false
                }
                boton3.post {
                    if( p != null ) tvMissatges.text = "Iniciat: $p"
                    else tvMissatges.text = "Iniciat"
                    btParla.isEnabled = false
                    boton1.isEnabled = false
                    boton2.isEnabled = false
                    boton3.isEnabled = false
                    boton4.isEnabled = false
                }
                boton4.post {
                    if( p != null ) tvMissatges.text = "Iniciat: $p"
                    else tvMissatges.text = "Iniciat"
                    btParla.isEnabled = false
                    boton1.isEnabled = false
                    boton2.isEnabled = false
                    boton3.isEnabled = false
                    boton4.isEnabled = false
                }
            }

            override fun onDone(p: String?) {
                btParla.post {
                    if( p != null ) tvMissatges.text = "Fet: $p"
                    else tvMissatges.text = "Fet"
                    btParla.isEnabled = true
                    boton1.isEnabled = true
                    boton2.isEnabled = true
                    boton3.isEnabled = true
                    boton4.isEnabled = true
                }
                boton1.post {
                    if( p != null ) tvMissatges.text = "Fet: $p"
                    else tvMissatges.text = "Fet"
                    btParla.isEnabled = true
                    boton1.isEnabled = true
                    boton2.isEnabled = true
                    boton3.isEnabled = true
                    boton4.isEnabled = true
                }
                boton2.post {
                    if( p != null ) tvMissatges.text = "Fet: $p"
                    else tvMissatges.text = "Fet"
                    btParla.isEnabled = true
                    boton1.isEnabled = true
                    boton2.isEnabled = true
                    boton3.isEnabled = true
                    boton4.isEnabled = true
                }
                boton3.post {
                    if( p != null ) tvMissatges.text = "Fet: $p"
                    else tvMissatges.text = "Fet"
                    btParla.isEnabled = true
                    boton1.isEnabled = true
                    boton2.isEnabled = true
                    boton3.isEnabled = true
                    boton4.isEnabled = true
                }
                boton4.post {
                    if( p != null ) tvMissatges.text = "Fet: $p"
                    else tvMissatges.text = "Fet"
                    btParla.isEnabled = true
                    boton1.isEnabled = true
                    boton2.isEnabled = true
                    boton3.isEnabled = true
                    boton4.isEnabled = true
                }
            }

            override fun onError(p: String?) {
                btParla.post {
                    if (p != null) tvMissatges.text = "Error: $p"
                    else tvMissatges.text = "Error"
                    btParla.isEnabled = true
                }
            }
        }
        tts.setOnUtteranceProgressListener(speechListener)

        btParla.setOnClickListener {
            btParla.isEnabled = false
            val text = txTextoAVoz.text.toString()

            parlar(text)
        }
        boton1.setOnClickListener {
            btParla.isEnabled = false
            val text = "boton1"

            parlar(text)
        }
        boton2.setOnClickListener {
            btParla.isEnabled = false
            val text = "boton2"

            parlar(text)
        }
        boton3.setOnClickListener {
            btParla.isEnabled = false
            val text:String = "boton3"

            parlar(text)
        }
        boton4.setOnClickListener {
            btParla.isEnabled = false
            val text:String = "boton4"
            parlar(text)
        }
    }

    private fun parlar(text: String) {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    public override fun onDestroy() {
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts!!.setLanguage(Locale.getDefault())
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS","The Language specified is not supported!")
            } else {
                btParla.isEnabled = true
                boton1.isEnabled = true
                boton2.isEnabled = true
                boton3.isEnabled = true
                boton4.isEnabled = true
            }
        } else {
            Log.e("TTS", "Initilization Failed!")
        }
    }
}



