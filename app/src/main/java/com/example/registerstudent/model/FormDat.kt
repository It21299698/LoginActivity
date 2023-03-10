package com.example.registerstudent.model

class FormDat( private var studentID:String, private var year:String,
private var semester:String,
private var agreement:Boolean,) {


    fun ValidateStudentID() {
        return
        if (studentID.isEmpty()) {
            ValidationResults.Empty("Student ID is empty")

        } else if (!studentID.startsWith("IT")) {
            ValidationResults.Invalid("Should be start with it")
        } else if (studentID.length != 10) {
            ValidationResults.Invalid("Student ID should be 10 charactors")
        } else {
            ValidationResults.Valid
        }


    }

    fun validateYear(): ValidationResults {
        return if (year.isEmpty()) {
            ValidationResults.Empty("Year is empty")
        } else {
            ValidationResults.Valid
        }
    }

    fun validateSemester(): ValidationResults {
        return if (semester.isEmpty()) {
            ValidationResults.Empty("Semester is empty")
        } else {
            ValidationResults.Valid
        }
    }

    fun validateAgreement(): ValidationResults {
        return if(!agreement){
            ValidationResults.Invalid("You must agree for the terms and conditions")
        }else{
            ValidationResults.Valid
        }
    }
    }


