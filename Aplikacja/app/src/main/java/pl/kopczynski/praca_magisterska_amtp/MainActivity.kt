package pl.kopczynski.praca_magisterska_amtp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.coroutines.NonCancellable.start
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var btnsignup: Button
    private lateinit var btngotologin: Button
    private lateinit var uname : EditText
    private lateinit var pword : EditText
    private lateinit var pword2 : EditText
    private lateinit var db: DBHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnsignup = findViewById(R.id.Przycisk_rejestracja)
        btngotologin = findViewById(R.id.Przycisk_mam_konto)

        uname = findViewById(R.id.username_register)
        pword = findViewById(R.id.password_register)
        pword2 = findViewById(R.id.password2_register)
        db = DBHelper(this)


        btngotologin.setOnClickListener(){
            val intent = Intent(this,LoginActivity::class.java)
            this.startActivity(intent)
        }
        btnsignup.setOnClickListener(){
            val unametext = uname.text.toString()
            val pwordtext = pword.text.toString()
            val pword2text = pword2.text.toString()
            val savedata = db.insertdata(unametext, pwordtext)

            if(TextUtils.isEmpty(unametext) || TextUtils.isEmpty(pwordtext)
                || TextUtils.isEmpty(pword2text)){
                Toast.makeText(this, "Dodaj nazwe użytkownika, " +
                        "hasło i potwierdzienie hasła", Toast.LENGTH_SHORT).show()
            }
            else{
                if(pwordtext.equals(pword2text)){
                    if(savedata==true){
                        Toast.makeText(this,"Rejestracja pomyślna", Toast.LENGTH_SHORT).show()
                        val intent = Intent(applicationContext,LoginActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this,"Użytkownik już istnieje", Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    Toast.makeText(this,"Hasła nie są takie same",Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}