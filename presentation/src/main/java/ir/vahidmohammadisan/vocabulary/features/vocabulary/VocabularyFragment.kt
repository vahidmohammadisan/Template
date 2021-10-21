package ir.vahidmohammadisan.vocabulary.features.vocabulary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ir.vahidmohammadisan.domain.model.Vocabs
import ir.vahidmohammadisan.vocabulary.R
import ir.vahidmohammadisan.vocabulary.databinding.FragmentVocabularyBinding
import ir.vahidmohammadisan.vocabulary.features.base.fragment.BaseFragment

@AndroidEntryPoint
class VocabularyFragment : BaseFragment<FragmentVocabularyBinding>() {

    private val viewModel by viewModels<VocabularyViewModel>()
    private lateinit var list: List<Vocabs>

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentVocabularyBinding
        get() = FragmentVocabularyBinding::inflate

    private val vocabularyAdapter by lazy {
        VocabularyAdapter(list)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postponeEnterTransition()

        _binding?.recyclerView?.layoutManager = GridLayoutManager(activity, resources.getInteger(R.integer.media_columns))

        viewModel.vocabularyList.observe(viewLifecycleOwner, {
            list = it
            _binding?.recyclerView?.adapter = vocabularyAdapter
            vocabularyAdapter.notifyDataSetChanged()
        })

        _binding?.btnAddVocabulary?.setOnClickListener {
            findNavController().navigate(R.id.action_vocabularyFragment_to_addVocabularyFragment)
        }

    }
}
