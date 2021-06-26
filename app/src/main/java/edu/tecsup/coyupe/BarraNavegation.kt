package edu.tecsup.coyupe

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import edu.tecsup.coyupe.databinding.ActivityBarraNavegationBinding

class BarraNavegation : AppCompatActivity() {

    private lateinit var binding: ActivityBarraNavegationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBarraNavegationBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var homeFragment = HomeFragment()
        var locationFragment = LocationFragment()
        var shoppingFragment = ShoppingFragment()

        binding.bottomNavigationView.setOnNavigationItemReselectedListener{
            when(it.itemId){
                R.id.nav_home ->   {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainer,HomeFragment() )
                        commit()
                    }
                }

                R.id.nav_ubication ->{
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainer, LocationFragment())
                        commit()
                    }
                }

                R.id.nav_carrito ->{
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainer, ShoppingFragment())
                        commit()
                    }
                }
            }
        }

    }

    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.containerView, fragment)
            commit()
        }
    }
}