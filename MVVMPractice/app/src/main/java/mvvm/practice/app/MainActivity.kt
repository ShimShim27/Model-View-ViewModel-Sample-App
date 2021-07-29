package mvvm.practice.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    var wFragments = listOf(
        newWordedImageFrag(1),
        newWordedImageFrag(2),
        newWordedImageFrag(3),
        newWordedImageFrag(4),
        newWordedImageFrag(5),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        initialize()
        showFragmentList(wFragments[0])
    }



    private fun initialize(){
        supportFragmentManager.beginTransaction().apply {
            for (f in wFragments) add(R.id.listFrameLayout,f)
            commit()
        }



        findViewById<TabLayout>(R.id.tabLayout).addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                showFragmentList(wFragments[tab!!.position])
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }


    private fun newWordedImageFrag(fragmentNumber:Int):WordedImageListFragment{
       return WordedImageListFragment().apply {
            arguments = Bundle().also { it.putInt("fragmentNumber",fragmentNumber) }
        }
    }

    private fun showFragmentList(f:WordedImageListFragment){
        supportFragmentManager.beginTransaction().apply {
            wFragments.filter { it != f }.forEach{
                hide(it)
            }
            show(f)
            commit()
        }

    }
}