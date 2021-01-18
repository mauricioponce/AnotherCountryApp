package cl.eme.countries.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import cl.eme.countries.MyViewModel
import cl.eme.countries.databinding.FragmentListingBinding

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

        return binding.root
    }
}