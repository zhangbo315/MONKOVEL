package com.monke.monkeybook.model.impl;

import com.monke.monkeybook.model.IWebContentModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.TextNode;

import java.util.List;

public class ContentPpxsModelImpl implements IWebContentModel{
    public static final String TAG = "http://www.ppxs.net";

    public static ContentPpxsModelImpl getInstance() {
        return new ContentPpxsModelImpl();
    }

    private ContentPpxsModelImpl() {

    }
    @Override
    public String analyBookcontent(String s, String realUrl) throws Exception {
        Document doc = Jsoup.parse(s);
        List<TextNode> contentEs = doc.getElementById("booktext").textNodes();
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < contentEs.size(); i++) {
            String temp = contentEs.get(i).text().trim();
            temp = temp.replaceAll(" ","").replaceAll(" ","");
            if (temp.length() > 0) {
                content.append("\u3000\u3000" + temp);
                if (i < contentEs.size() - 1) {
                    content.append("\r\n");
                }
            }
        }
        return content.toString();
    }
}
