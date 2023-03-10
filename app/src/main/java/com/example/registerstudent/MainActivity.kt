package com.example.registerstudent

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.registerstudent.model.FormDat
import com.example.registerstudent.model.FormData
import com.example.registerstudent.model.ValidationResults

private fun Any.validateSemester(): Any {

}

private fun Any.validateAgreement(): Any {
    TODO("Not yet implemented")
}

private fun Any.validateYear(): Any {

}

private fun Any.validateStudentId(): Any {

}

class MainActivity(myForm: Any) : AppCompatActivity()
    lateinit var edtStudentId: EditText
    lateinit var spnYear: Spinner
    lateinit var spnSemester: Spinner
    lateinit var cbAgree: CheckBox
    lateinit var tvYear: TextView
    lateinit var tvSemester:

            private var count = 0;

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtStudentId = findViewById(R.id.edtStudentId)
        tvYear = findViewById(R.id.tvYear)
        spnYear = findViewById(R.id.spnsemester)
        tvSemester = findViewById(R.id.tvSemester)
        spnSemester = findViewById(R.id.spnSemester)
        cbAgree = findViewById(R.id.cbAgree)

    }

    override fun onResume() {
        super.onResume()
        btnSubmit.setOnClickListner(View.OnClickListener {
            val myForm = FormDat(
                edtStudentId.text.toString(),
                spnYear.selectedItem.toString(),
                spnSemester.selectedItem.toString(),
                cbAgree.isChecked
            )
        })
    }

    fun displayAlert(title: String, message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, which ->         // Do something when the "OK" button is clicked
        }
        val dialog = builder.create()
        dialog.show()
    }

    fun submit(v: View) {
        val myForm = FormData(
            edtStudentId.text.toString(),
            spnYear.selectedItem.toString(),
            spnSemester.selectedItem.toString(),
            cbAgree.isChecked
        )

    }

    val studentIdValidation = myForm.validateStudentId()
    val spnYearValidation = myForm.validateYear()
    val spnSemesterValidation = myForm.validateSemester()
    val cbAgreeValidation = myForm.validateAgreement()


    when(studentIdValidation){

        is ValidationResults.Valid -> {
        count++
    }
        is ValidationResults.Invalid -> {
        edtStudentId.error = studentIdValidation.errorMessage

    }
        is ValidationResults.Empty ->{
        edtStudentId.error = studentIdValidation.errorMessage
    }







