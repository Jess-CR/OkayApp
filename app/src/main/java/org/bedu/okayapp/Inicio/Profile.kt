package org.bedu.okayapp.Inicio

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import org.bedu.okayapp.R
import com.google.firebase.auth.FirebaseAuth
import org.bedu.okayapp.changePassword
import org.bedu.okayapp.databinding.ActivityProfileBinding

class Profile : AppCompatActivity() {

    private lateinit var profile_button: Button
    private lateinit var profile_imageView: ImageView
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        profile_button = findViewById(R.id.profile_button)
        profile_imageView = findViewById(R.id.profile_imageView)
        auth= FirebaseAuth.getInstance()
        profile_button.isEnabled = false

        //se solicita autorización por parte del usuario para que otorgue permisos del uso de cámara
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),111)
        }
        else
            profile_button.isEnabled = true

        profile_button.setOnClickListener {
            var i = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(i,101)
        }

        updateUI()
    }

    fun contraseñas(view: View){
        startActivity(Intent(this,changePassword::class.java))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==101)
        {
            // para guardar la imagen, se debe colocar el nombre de la carpeta en lugar de pic
            var pic = data?.getParcelableExtra<Bitmap>("data")
            profile_imageView.setImageBitmap(pic)
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 111 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            profile_button.isEnabled = true
        }
    }

    private fun updateUI(){
        val user = auth.currentUser
        if(user != null){
            binding.profileTxtViewUserName.text = user.email
            //binding.profileTxtViewUserName.text = user.displayName
        }
    }

}