package ir.vahidmohammadisan.vocabulary.features.vocabulary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ir.vahidmohammadisan.vocabulary.databinding.FragmentVocabularyBinding
import kotlinx.coroutines.flow.map

@AndroidEntryPoint
class VocabularyFragment : Fragment() {

    private val viewModel by viewModels<VocabularyViewModel>()
    private var _binding: FragmentVocabularyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVocabularyBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postponeEnterTransition()
        viewModel.insertVocabulary()
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        viewModel.vocabularyList.observe(viewLifecycleOwner, {
            it.map { item ->
                binding.recyclerView.adapter = VocabularyAdapter(item)
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
