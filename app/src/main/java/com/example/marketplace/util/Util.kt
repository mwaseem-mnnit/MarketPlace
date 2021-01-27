package com.example.marketplace.util

import java.text.SimpleDateFormat

/* 
 *   created by mohdwaseem
 *   created on 26/1/21  
 *   Time: 5:43 PM
 *   To change this template use File | Settings | File and Code Templates.
*/

fun convertEpochToDate(epoch: Long): String {
    return SimpleDateFormat.getDateInstance().format(epoch)
}