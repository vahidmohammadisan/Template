package ir.vahidmohammadisan.vocabulary.features.vocabulary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ir.vahidmohammadisan.domain.model.Vocabs
import ir.vahidmohammadisan.vocabulary.databinding.FragmentVocabularyBinding

@AndroidEntryPoint
class VocabularyFragment : Fragment() {

    private val viewModel by viewModels<VocabularyViewModel>()
    private var _binding: FragmentVocabularyBinding? = null
    private val binding get() = _binding!!
    private lateinit var list: List<Vocabs>

    private val vocabularyAdapter by lazy {
        VocabularyAdapter(list)
    }

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

        binding.recyclerView.layoutManager = LinearLayoutManager(activity)

        viewModel.vocabularyList.observe(viewLifecycleOwner, {
            list = it
            binding.recyclerView.adapter = vocabularyAdapter
            vocabularyAdapter.notifyDataSetChanged()
        })

        binding.btnAddVocabulary.setOnClickListener {
            val addVocabularyFragment = AddVocabularyFragment()
            addVocabularyFragment.show(requireActivity().supportFragmentManager, addVocabularyFragment.tag)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
