package com.marvel.app.marvelapp.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marvel.app.marvelapp.MainActivity
import com.marvel.app.marvelapp.R
import com.marvel.app.marvelapp.adapter.CustomAdapter
import com.marvel.app.marvelapp.extensions.inflate
import com.marvel.app.marvelapp.extensions.showToast
import com.marvel.app.marvelapp.model.DataModel
import com.marvel.app.marvelapp.model.ResponseModel
import com.marvel.app.marvelapp.retrofit.MarvelAPI
import kotlinx.android.synthetic.main.frag_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Marcin Pogorzelski on 21/09/2017.
 */
class ListFragment : Fragment(), CustomAdapter.onViewSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.frag_list)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getActionBar()?.setDisplayHomeAsUpEnabled(false);
        getActionBar()?.setDisplayShowHomeEnabled(false);
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        list.apply {
            setHasFixedSize(true)
            val linearLayout = LinearLayoutManager(context)
            layoutManager = linearLayout
        }

        initAdapter()
        fetchData();
    }

    private fun getActionBar(): ActionBar? {
        return (getActivity() as AppCompatActivity).getSupportActionBar()
    }

    private fun fetchData() {

        showLoading()

        val apiService = MarvelAPI.create()
        val call = apiService.getHeros();


        call.enqueue(object : Callback<ResponseModel> {

            override fun onResponse(call: Call<ResponseModel>?, response: Response<ResponseModel>) {

                if (response.isSuccessful() ?: false) {
                    val response = response.body()
                    (list.adapter as CustomAdapter).addItems(response.superheroes)
                }

                hideLoading()
            }

            override fun onFailure(call: Call<ResponseModel>?, t: Throwable?) {
                context.showToast("Ha ocurrido un error")
                hideLoading()
            }
        });

    }

    private fun hideLoading() {
        progress.visibility = View.GONE
    }

    private fun showLoading() {
        progress.visibility = View.VISIBLE
    }

    override fun onItemSelected(item: DataModel) {
        context.showToast(item.name)
        (activity as MainActivity).changeFragment(DetailFragment.newInstance(item))
    }

    private fun initAdapter() {
        if (list.adapter == null) {
            list.adapter = CustomAdapter(this)
        }
    }

}