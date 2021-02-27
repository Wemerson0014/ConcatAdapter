package com.estudo.concatadaptyer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.estudo.concatadaptyer.databinding.ItemProgrammingLanguagesBinding

class ProgrammingLanguagesAdapter : ListAdapter<ProgrammingLanguage, ProgrammingLanguagesAdapter.ProgrammingLanguageViewHolder>(
    DIFF_CALLBACK
) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProgrammingLanguageViewHolder {
        return ProgrammingLanguageViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ProgrammingLanguageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ProgrammingLanguage>() {
            override fun areItemsTheSame(
                oldItem: ProgrammingLanguage,
                newItem: ProgrammingLanguage
            ): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(
                oldItem: ProgrammingLanguage,
                newItem: ProgrammingLanguage
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    class ProgrammingLanguageViewHolder(
        private val itemBinding: ItemProgrammingLanguagesBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(programmingLanguage: ProgrammingLanguage) {
            itemBinding.run {
                imageLanguage.setImageResource(programmingLanguage.logo)
                textLanguageName.text = programmingLanguage.name
                textParadigm.text = programmingLanguage.paradigm
            }
        }

        companion object {
            fun create(parent: ViewGroup): ProgrammingLanguageViewHolder {
                val itemBinding = ItemProgrammingLanguagesBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)

                return ProgrammingLanguageViewHolder(itemBinding)
            }
        }
    }
}