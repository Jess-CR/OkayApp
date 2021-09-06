package org.bedu.okayapp
//ketzalli
//Datos que se usaran para Recyclerview y manejo del proceso

import java.io.Serializable

data class SexualEducationDC(
    var questions: String,
    var imageQ: Int,
    var options1: String,
    var options2: String,
    var options3: String,
    var resCorrecta: Int,
    var userResp: Int
) : Serializable
