package ir.vahidmohammadisan.vocabulary.features.vocabulary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ir.vahidmohammadisan.vocabulary.databinding.FragmentDetailsVocabularyBinding
import ir.vahidmohammadisan.vocabulary.features.base.fragment.BaseFragment

@AndroidEntryPoint
class VocabularyDetailsFragment : BaseFragment<FragmentDetailsVocabularyBinding>() {

    private val viewModel by viewModels<VocabularyViewModel>()

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailsVocabularyBinding
        get() = FragmentDetailsVocabularyBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}