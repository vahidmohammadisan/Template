package ir.vahidmohammadisan.vocabulary.features.vocabulary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import ir.vahidmohammadisan.domain.model.Vocabs
import ir.vahidmohammadisan.vocabulary.databinding.FragmentAddVocabularyBinding

@AndroidEntryPoint
class AddVocabularyFragment : BottomSheetDialogFragment() {

    private val viewModel by viewModels<VocabularyViewModel>()
    private var binding: FragmentAddVocabularyBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddVocabularyBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding!!.save.setOnClickListener {
            viewModel.insertVocabulary(
                Vocabs(
                    binding!!.word.text.toString(),
                    binding!!.type.text.toString(),
                    binding!!.sOne.text.toString(),
                    binding!!.sTwo.text.toString(),
                    binding!!.sThree.text.toString()
                )
            )
            dismiss()
        }
    }
}