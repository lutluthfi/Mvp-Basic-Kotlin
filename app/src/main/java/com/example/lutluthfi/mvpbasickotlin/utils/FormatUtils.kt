package com.example.lutluthfi.mvpbasickotlin.utils

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

object FormatUtils {

    fun parseCurrencyToIDR(money: String?): String {
        val kursIndonesia = DecimalFormat.getCurrencyInstance() as DecimalFormat
        val format = DecimalFormatSymbols()
        format.currencySymbol = "Rp. "
        format.monetaryDecimalSeparator = ','
        format.groupingSeparator = '.'
        kursIndonesia.decimalFormatSymbols = format
        return kursIndonesia.format(money?.toInt())
    }
}