package ir.vahidmohammadisan.vocabulary.features.vocabulary

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.vahidmohammadisan.domain.model.Vocabs
import ir.vahidmohammadisan.vocabulary.R
import ir.vahidmohammadisan.vocabulary.databinding.AdapterVocabularyBinding

class VocabularyAdapter(
    private val vocabs: List<Vocabs>,
) : RecyclerView.Adapter<VocabularyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        AdapterVocabularyBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            root.removeAllViews()
            vocabs.forEach {
                holder.binding.word.text = it.word
            }
        }
    }

    override fun getItemViewType(position: Int) = R.layout.adapter_vocabulary

    override fun getItemCount() = vocabs.size

    class ViewHolder(val binding: AdapterVocabularyBinding) : RecyclerView.ViewHolder(binding.root)
}
