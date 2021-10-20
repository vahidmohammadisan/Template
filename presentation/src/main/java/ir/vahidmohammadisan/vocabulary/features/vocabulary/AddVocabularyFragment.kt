package ir.vahidmohammadisan.vocabulary.features.vocabulary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ir.vahidmohammadisan.domain.model.Vocabs
import ir.vahidmohammadisan.vocabulary.databinding.FragmentAddVocabularyBinding
import ir.vahidmohammadisan.vocabulary.features.base.fragment.BaseFragment

@AndroidEntryPoint
class AddVocabularyFragment : BaseFragment<FragmentAddVocabularyBinding>() {

    private val viewModel by viewModels<VocabularyViewModel>()

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentAddVocabularyBinding
        get() = FragmentAddVocabularyBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding?.save?.setOnClickListener {
            viewModel.insertVocabulary(
                Vocabs(
                    _binding?.word?.text.toString(),
                    _binding?.type?.text.toString(),
                    _binding?.sOne?.text.toString(),
                    _binding?.sTwo?.text.toString(),
                    _binding?.sThree?.text.toString()
                )
            )
        }
    }
}