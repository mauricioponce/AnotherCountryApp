package cl.eme.countries.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import cl.eme.countries.MyViewModel
import cl.eme.countries.R
import cl.eme.countries.databinding.FragmentListingBinding
import timber.log.Timber

class ListingFragment: Fragment() {
    private val viewModel: MyViewModel by viewModels()
    private lateinit var binding: FragmentListingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListingBinding.inflate(layoutInflater)

        val adapter = CountryAdapter()

        binding.rvCountries.layoutManager = LinearLayoutManager(context)
        binding.rvCountries.adapter = adapter

        viewModel.minimalCountries.observe(viewLifecycleOwner, {
            it?.let {
                adapter.update(it)
            }
        })

        adapter.selectedItem().observe(viewLifecycleOwner, {
            Timber.d("item seleccionado es $it")

            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_container, DetailFragment())?.commit()
        })

        return binding.root
    }
}