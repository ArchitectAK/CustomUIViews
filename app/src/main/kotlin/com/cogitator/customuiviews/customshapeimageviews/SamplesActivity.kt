package com.cogitator.customuiviews.customshapeimageviews

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.cogitator.customuiviews.R
import com.meg7.widget.CustomShapeImageView
import com.meg7.widget.CustomShapeSquareImageView
import kotlinx.android.synthetic.main.activity_samples.*


/**
 * @author Ankit Kumar on 08/03/2019
 */
class SamplesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_samples)


        gridview.adapter = SvgImagesAdapter(this)
    }

    private inner class SvgImagesAdapter(private val mContext: Context) : BaseAdapter() {
        private val mSvgRawResourceIds = mutableListOf<Int>()

        init {

            mSvgRawResourceIds.add(R.raw.shape_star)
            mSvgRawResourceIds.add(R.raw.shape_heart)
            mSvgRawResourceIds.add(R.raw.shape_flower)
            mSvgRawResourceIds.add(R.raw.shape_star_2)
            mSvgRawResourceIds.add(R.raw.shape_star_3)
            mSvgRawResourceIds.add(R.raw.shape_circle_2)
            mSvgRawResourceIds.add(R.raw.shape_5)
        }

        override fun getCount(): Int {
            return mSvgRawResourceIds.size
        }

        override fun getItem(i: Int): Int? {
            return mSvgRawResourceIds.get(i)
        }

        override fun getItemId(i: Int): Long {
            return mSvgRawResourceIds.get(i).toLong()
        }

        override fun getView(i: Int, view: View, viewGroup: ViewGroup): CustomShapeSquareImageView? {
            return getItem(i)?.let {
                CustomShapeSquareImageView(
                    mContext,
                    R.drawable.sample,
                    CustomShapeImageView.Shape.SVG,
                    it
                )
            }// It is just a sample ;)
        }

    }
}