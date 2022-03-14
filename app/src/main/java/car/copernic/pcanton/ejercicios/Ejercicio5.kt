package car.copernic.pcanton.ejercicios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import android.widget.TextView
import android.widget.Button
import java.util.*

class Ejercicio5 : AppCompatActivity(), TextToSpeech.OnInitListener {

    lateinit var boton1: Button
    lateinit var boton2: Button
    lateinit var boton3: Button
    lateinit var boton4: Button
    lateinit var boton5: Button
    lateinit var TVmsg: TextView
    lateinit var tts: TextToSpeech

    lateinit var tvQD:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio5)

        boton1 = findViewById(R.id.boton1)
        boton2 = findViewById(R.id.boton2)
        boton3 = findViewById(R.id.boton3)
        boton4 = findViewById(R.id.boton4)
        boton5 = findViewById(R.id.boton6)
        TVmsg = findViewById(R.id.tvtexto)
        tvQD = findViewById(R.id.tvQD)

        tts = TextToSpeech(this, this)

        val speechListener = object : UtteranceProgressListener() {
            override fun onStart(p0: String?) {
                TVmsg.text = "Iniciat"
            }
            override fun onDone(p: String?) {
                boton1.isEnabled = true
                boton2.isEnabled = true
                boton3.isEnabled = true
                boton4.isEnabled = true
                boton5.isEnabled = true
                TVmsg.text = "Terminado"
            }
            override fun onError(p: String?) {
                TVmsg.text = "ERROR"
            }
        }
        tts.setOnUtteranceProgressListener(speechListener)

        boton1.setOnClickListener {
            boton1.isEnabled = false
            boton2.isEnabled = false
            boton3.isEnabled = false
            boton4.isEnabled = false
            boton5.isEnabled = false
            val texto="boton1"
            parlar(texto)

        }
        boton2.setOnClickListener {
            boton1.isEnabled = false
            boton2.isEnabled = false
            boton3.isEnabled = false
            boton4.isEnabled = false
            boton5.isEnabled = false
            val texto="boton2"
            parlar(texto)
        }
        boton3.setOnClickListener {
            boton1.isEnabled = false
            boton2.isEnabled = false
            boton3.isEnabled = false
            boton4.isEnabled = false
            boton5.isEnabled = false
            val texto="boton3"
            parlar(texto)
        }
        boton4.setOnClickListener {
            boton1.isEnabled = false
            boton2.isEnabled = false
            boton3.isEnabled = false
            boton4.isEnabled = false
            boton5.isEnabled = false
            val texto="boton4"
            parlar(texto)
        }
        boton5.setOnClickListener {
            boton1.isEnabled = false
            boton2.isEnabled = false
            boton3.isEnabled = false
            boton4.isEnabled = false
            boton5.isEnabled = false
            var texto:String=tvQD.text.toString()
            parlar(texto)
        }

    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts!!.setLanguage(Locale.getDefault())
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "The Language specified is not supported!")
            } else {
                boton1.isEnabled = true
                boton2.isEnabled = true
                boton3.isEnabled = true
                boton4.isEnabled = true
                boton5.isEnabled = true
            }
        } else {
            Log.e("TTS", "Initilization Failed!")
        }
    }
    public override fun onDestroy() {
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }
    private fun parlar(texto: String) {
        tts.speak(texto, TextToSpeech.QUEUE_FLUSH, null, "")
    }
}