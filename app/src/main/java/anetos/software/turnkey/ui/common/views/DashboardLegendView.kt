package anetos.software.turnkey.ui.common.views

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import anetos.software.turnkey.R

/***
 *  Custom view to handle Dashboard Legend details
 *
 *  Created by Jaydeep Bhayani on 19/04/2020
 */
class DashboardLegendView(context: Context, attrs: AttributeSet)  : ConstraintLayout(context, attrs) {

    /*init {
        inflate(context, R.layout.view_dashboard_legend, this)

        val dashboardLegendIcon: ImageView = findViewById(R.id.icon)
        val dashboardLegendTitle: TextView = findViewById(R.id.title)
        val dashboardLegendSubTitle: TextView = findViewById(R.id.subTitle)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.DashboardLegendView)
        val drawableResId =
            attributes.getResourceId(R.styleable.DashboardLegendView_icon, R.drawable.icon_directory)

        if (Build.VERSION.SDK_INT >= 21) {
            dashboardLegendIcon.setImageDrawable(attributes.getDrawable(R.styleable.DashboardLegendView_icon))
        } else {
            dashboardLegendIcon.setImageResource(drawableResId)
        }

        //    VectorDrawableCompat.create(resources, drawableResId, null)
        // AppCompatResources.getDrawable(context, drawableResId)

        dashboardLegendIcon.setImageResource(drawableResId)

        //   dashboardLegendIcon.setImageDrawable(attributes.getDrawable(R.styleable.DashboardLegendView_icon))
        dashboardLegendIcon.visibility =
            if (attributes.getInt(R.styleable.DashboardLegendView_iconVisibility, 0) == 2) {
                View.GONE
            } else {
                View.VISIBLE
            }

        dashboardLegendTitle.text = attributes.getString(R.styleable.DashboardLegendView_title)
        dashboardLegendSubTitle.apply {
            text = String.format(
                context.getString(R.string.ahir),
                attributes.getString(R.styleable.DashboardLegendView_subTitle)
            )
            visibility = if (text != "( null )") {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
        attributes.recycle()
    }*/
}