package tn.esprit.nascar.Controller

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tn.esprit.nascar.Model.News
import tn.esprit.nascar.R

class NewsViewAdapter(private val dataSource:List<News>) : RecyclerView.Adapter<NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val newsItem = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return NewsViewHolder(newsItem)
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.image.setImageResource(dataSource[position].imageId)
        holder.title.text = dataSource[position].title
        holder.description.text = dataSource[position].description
    }
}