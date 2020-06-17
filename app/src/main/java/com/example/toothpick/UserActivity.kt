package com.example.toothpick

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.toothpick.DI.Scopes
import kotlinx.android.synthetic.main.activity_user.*
import toothpick.Toothpick
import javax.inject.Inject

class UserActivity : AppCompatActivity() {

    @Inject
    lateinit var userRepository: UserRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        initButtons()
        val appScope = Toothpick.openScope(Scopes.APP)
        Toothpick.inject(this, appScope)
        if (savedInstanceState == null) {
            loadUser()
        }
    }

    private fun initButtons() {
        button_load.setOnClickListener {
            loadUser()
        }
        button_save.setOnClickListener {
            saveUser()
        }
    }

    private fun loadUser() {
        showUser(userRepository.getUser())
    }

    private fun showUser(user: User) {
        edit_text_name.setText(user.name)
        edit_text_email.setText(user.email)
    }

    private fun saveUser() {
        val user = User(
            edit_text_name.text.toString().trim(),
            edit_text_email.text.toString().trim()
        )
        userRepository.saveUser(user)
    }
}
