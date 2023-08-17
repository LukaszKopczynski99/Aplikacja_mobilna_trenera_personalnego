package pl.kopczynski.praca_magisterska_amtp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

private lateinit var loginbutton : Button
private lateinit var edituser: EditText
private lateinit var editpword: EditText
private lateinit var dbh:DBHelper


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginbutton = findViewById(R.id.Przycisk_logowanie)
        edituser = findViewById(R.id.username_login)
        editpword = findViewById(R.id.password_login)
        dbh = DBHelper(this)


        loginbutton.setOnClickListener(){
            val useredtx = edituser.text.toString()
            val passedtx = editpword.text.toString()

            if(TextUtils.isEmpty(useredtx)
                || TextUtils.isEmpty(passedtx)){
                Toast.makeText(this,"Podaj nazwę użytkownika" +
                        " i hasło", Toast.LENGTH_SHORT).show()
            }
            else
            {
                val checkuser = dbh.checkuserpass(useredtx,passedtx)
                if(checkuser==true){
                    Toast.makeText(this,"Logowanie pomyślne", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext,Wybor_mezczyzna_kobieta::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"Blędna nazwa użytkownika lub hasło",Toast.LENGTH_SHORT).show()
                }

            }

        }


    }
}