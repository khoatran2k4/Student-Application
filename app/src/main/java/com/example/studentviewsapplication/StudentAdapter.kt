package com.example.studentviewsapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView

class StudentAdapter(val studentList: MutableList<StudentModel>) : BaseAdapter() {
    override fun getCount() = studentList.size

    override fun getItem(position: Int) = studentList[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(parent?.context).inflate(
                R.layout.student_list_views,
                parent,
                false
            )
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val student = studentList[position]
        viewHolder.studentName.text = student.name
        viewHolder.studentId.text = "Id: ${student.id}"
        viewHolder.btn.setOnClickListener{
            studentList.removeAt(position)
            notifyDataSetChanged()
        }

        return view
    }

    private class ViewHolder(view: View) {
        val studentName: TextView = view.findViewById(R.id.name)
        val studentId: TextView = view.findViewById(R.id.id)
        val btn: Button = view.findViewById(R.id.button)
    }
}