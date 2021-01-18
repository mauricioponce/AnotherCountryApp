package cl.eme.countries.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import cl.eme.countries.MyViewModel
import cl.eme.countries.databinding.FragmentDetailBinding
import timber.log.Timber

class DetailFragment: Fragment() {

    lateinit var binding: FragmentDetailBinding

    private val viewModel: MyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("onCreateView")

        binding = FragmentDetailBinding.inflate(layoutInflater)


        return binding.root
    }
}