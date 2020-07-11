package com.swolf.ly.biz_xml.out

import com.swolf.ly.biz_xml.entity.KPage
import java.io.File
import java.io.FileOutputStream

object KWriteXmlFile {

    fun write(set:Set<KPage>, path:String){
        var file = File(path)
        if (!file.exists()) {
            file.createNewFile();
        }
        var outputStream = FileOutputStream(file)
        outputStream.write("<!DOCTYPE NETSCAPE-Bookmark-file-1>\n".toByteArray())
        outputStream.write("<META HTTP-EQUIV=\"Content-Type\" CONTENT=\"text/html; charset=UTF-8\">\n".toByteArray())
        outputStream.write("<TITLE>Bookmarks</TITLE>\n".toByteArray())
        outputStream.write("<H1>Bookmarks</H1>\n".toByteArray())
        outputStream.write("<DL><p>\n".toByteArray())
        outputStream.write("<DT><H3 ADD_DATE=\"1527468909\" LAST_MODIFIED=\"1585304190\" PERSONAL_TOOLBAR_FOLDER=\"true\">收藏栏</H3>\n".toByteArray())
        outputStream.write("<DL><p>\n".toByteArray())

        for(page in set){
            outputStream.write("<DT><A HREF=\"".toByteArray())
            outputStream.write(page.href.toByteArray())
            outputStream.write("\"".toByteArray())
            outputStream.write(" ADD_DATE=\"1586235142\"".toByteArray())
            outputStream.write(" ICON=\"\">".toByteArray())
            outputStream.write(page.name.toByteArray())
            outputStream.write("</A>\n".toByteArray())
        }

        outputStream.write("</DL><p>\n".toByteArray())
        outputStream.write("</DL><p>\n".toByteArray())
    }
}