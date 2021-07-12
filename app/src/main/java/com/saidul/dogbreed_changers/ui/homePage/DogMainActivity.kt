package com.saidul.dogbreed_changers.ui.homePage

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.fragment.app.FragmentTransaction
import com.saidul.dogbreed_changers.R
import com.saidul.dogbreed_changers.data.model.BreedsItem
import com.saidul.dogbreed_changers.ui.DogPageViewModel
import com.saidul.dogbreed_changers.ui.homePage.adapter.CustomDropDownAdapter
import com.saidul.dogbreed_changers.ui.homePage.fragment.DogListFragment
import com.sundarban.pickndrop.base.MVVMBaseActivity
import kotlinx.android.synthetic.main.activity_dog_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DogMainActivity : MVVMBaseActivity(), AdapterView.OnItemClickListener,
    AdapterView.OnItemSelectedListener {
    val myViewModel: DogPageViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        if (savedInstanceState == null) {
            val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
            ft.replace(R.id.fragment_placeholder, DogListFragment())
            ft.commit()
        }

        setupCommonViewModel(myViewModel)
        setupCommonUIState()
        initiOwnViewState()

        myViewModel.breeds()

    }

    private fun initiOwnViewState() {
        myViewModel.mBreeds.observe(this, {
            setupDogBreedDropdown(it)
        })

    }

    private fun setupDogBreedDropdown(it: List<BreedsItem>) {
        val customDropDownAdapter = CustomDropDownAdapter(applicationContext, it)
        spinner.adapter = customDropDownAdapter
        spinner.setOnItemSelectedListener(this)


    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        myViewModel.onItemClick(myViewModel.mBreeds.value?.get(position))
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {


    }
}