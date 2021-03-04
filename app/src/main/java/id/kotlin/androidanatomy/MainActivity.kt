package id.kotlin.androidanatomy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
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

        val drawerToggle = ActionBarDrawerToggle(this, binding.drawer, R.string.open, R.string.close)
        binding.drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            android.R.id.home ->{
                binding.drawer.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        if (binding.drawer.isDrawerOpen(GravityCompat.START))
        {
            binding.drawer.closeDrawer(GravityCompat.START)
        }else {
            super.onBackPressed()
        }
    }
}