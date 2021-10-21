package ir.vahidmohammadisan.vocabulary.features.vocabulary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import ir.vahidmohammadisan.domain.model.Vocabs
import ir.vahidmohammadisan.vocabulary.R

internal class VocabularyAdapter(private var itemsList: List<Vocabs>) :
    RecyclerView.Adapter<VocabularyAdapter.MyViewHolder>() {
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var word: TextView = view.findViewById(R.id.word)
        var type: TextView = view.findViewById(R.id.type)
    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_vocabulary, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemsList[position]
        holder.word.text = item.word
        holder.type.text = item.type
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}