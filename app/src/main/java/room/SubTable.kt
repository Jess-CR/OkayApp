package room

import androidx.room.ColumnInfo


class SubTable {
    @ColumnInfo(name = "subcat")
    var subcat: String? = null

    @ColumnInfo(name = "category")
    var category: String? = null

    @ColumnInfo(name = "themeicon")
    var themeicon: String? = null

    @ColumnInfo(name = "icon")
    var icon: String? = null



    @ColumnInfo(name = "ok")
    var ok: Int? = null
}
