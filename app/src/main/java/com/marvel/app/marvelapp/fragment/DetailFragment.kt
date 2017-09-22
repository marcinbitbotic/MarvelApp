package com.marvel.app.marvelapp.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marvel.app.marvelapp.R
import com.marvel.app.marvelapp.extensions.inflate
import com.marvel.app.marvelapp.extensions.loadImg
import com.marvel.app.marvelapp.model.DataModel
import kotlinx.android.synthetic.main.frag_detail.*

/**
 * Created by Marcin Pogorzelski on 21/09/2017.
 */
class DetailFragment : Fragment() {

    companion object {

        private val ARG_ITEM = "data_model_key"

        fun newInstance(caught: DataModel): DetailFragment {
            val args: Bundle = Bundle()
            args.putParcelable(ARG_ITEM, caught)
            val fragment = DetailFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.frag_detail)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (getActivity() as AppCompatActivity).getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        (getActivity() as AppCompatActivity).getSupportActionBar()?.setDisplayShowHomeEnabled(true);

        val bundle: Bundle? = arguments

        bundle?.let {
            if (it.containsKey(ARG_ITEM)) {

                // val model = bundle.getParcelable<DataModel>(ARG_ITEM)
                val data = arguments.getParcelable<DataModel>(ARG_ITEM)
                img_thumbnail.loadImg(data.photo)
                description.text = data.power
                height.text = data.height
                name.text = data.name
                real_name.text = data.realName
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}