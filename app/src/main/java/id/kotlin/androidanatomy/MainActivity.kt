package id.kotlin.androidanatomy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import id.kotlin.androidanatomy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        supportFragmentManager.beginTransaction().add(binding.fragmentContainer.id, HomeFragment(), "home")

        binding.navigationView.setNavigationItemSelectedListener {
            when (it.itemId)
            {
                R.id.nav_home -> {
                    supportFragmentManager.beginTransaction().replace(binding.fragmentContainer.id, HomeFragment(), "home")
                    binding.drawer.closeDrawer(GravityCompat.START)
                }
                R.id.nav_message -> {
                    supportFragmentManager.beginTransaction().replace(binding.fragmentContainer.id, MessageFragment(), "message")
                    binding.drawer.closeDrawer(GravityCompat.START)
                }
            }
            true
        }

    }
}