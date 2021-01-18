package cl.eme.countries.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import cl.eme.countries.MyViewModel
import cl.eme.countries.R
import cl.eme.countries.databinding.FragmentListingBinding
import timber.log.Timber

class ListingFragment: Fragment() {
    private val viewModel: MyViewModel by activityViewModels()

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

            viewModel.selected(it)

            findNavController().navigate(R.id.action_listingFragment_to_detailFragment2)
        })

        return binding.root
    }
}