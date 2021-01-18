package cl.eme.countries.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import cl.eme.countries.MyViewModel
import cl.eme.countries.databinding.FragmentDetailBinding
import coil.load
import timber.log.Timber

class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding

    private val viewModel: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("onCreateView")

        binding = FragmentDetailBinding.inflate(layoutInflater)

        viewModel.getDetail().observe(viewLifecycleOwner, {
            it?.let {
                binding.ivDetailFlag.load(it.flag)
                binding.tvDetailName.text = it.name
                binding.tvDetailRegion.text = it.region
                binding.tvPopulation.text = it.population.toString()
            }
        })

        return binding.root
    }
}