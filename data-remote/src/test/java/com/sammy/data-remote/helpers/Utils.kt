package com.sammy.`data-remote`.helpers

import com.google.common.io.Resources
import okhttp3.mockwebserver.RecordedRequest
import java.io.File

/**
 * Helper function which will load JSON from
 * the path specified
 *
 * @param path : Path of JSON file
 * @return json : JSON from file at given path
 */

internal fun getJson(path: String): String {
    val uri = Resources.getResource(path)
    val file = File(uri.path)
    return String(file.readBytes())
}