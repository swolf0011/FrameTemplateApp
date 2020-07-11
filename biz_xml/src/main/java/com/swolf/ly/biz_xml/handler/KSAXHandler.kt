package com.swolf.ly.biz_xml.handler

import com.swolf.ly.biz_xml.entity.KPage
import org.xml.sax.Attributes
import org.xml.sax.helpers.DefaultHandler

class KSAXHandler() : DefaultHandler() {
    private var set =  hashSetOf<KPage>()//无序的
    private var tagName = ""
    private lateinit var page:KPage
    fun getSet():Set<KPage>{
        return set
    }

    override fun startDocument() {
        super.startDocument()
    }

    override fun endDocument() {
        super.endDocument()
    }

    override fun startElement(
        uri: String,
        localName: String,
        qName: String,
        attributes: Attributes
    ) {

        if("A".equals(localName)){
            var href = attributes.getValue("HREF")
            this.page = KPage(href,"")
            tagName = localName
        }else{
            tagName = ""
        }
    }

    override fun endElement(uri: String?, localName: String?, qName: String?) {
        if("A".equals(localName)){
            set.add(page)
        }
    }

    override fun characters(ch: CharArray, start: Int, length: Int) {
        var value = String(ch,start,length)
        if(page!=null){
            page.name = value
        }
    }
}