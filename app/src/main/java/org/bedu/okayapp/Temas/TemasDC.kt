package org.bedu.okayapp.Temas

import java.io.Serializable

data class TemasDC(
    var title:String,
    var imageId:Int,
    var percentage:Int
):Serializable