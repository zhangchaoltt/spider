package com.zhangchao.spider.util;

import com.zhangchao.spider.bean.Image;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangchao19 on 2015/10/29.
 */

public class SpiderUtil {

    private static Map<String, String> urls = new HashMap<String, String>();
    static {
        urls.put("qingxin", "http://www.doubanmeizi.com/category/qingxin");
        urls.put("meitui", "http://www.doubanmeizi.com/category/meitui");
    }
    public static List<Image> getPictures(String category, String pageNum) {
        List<Image> images = new ArrayList<Image>();
        try {
            String url = urls.get(category) + "/page/" + pageNum;
            Document doc = Jsoup.connect(url)
                                .timeout(3000)
                                .get();
            Elements elements = doc.getElementsByTag("img");
            Image image = null;
            for (Element element : elements) {
                image = new Image();
                String shortUrl = element.attr("src");
                Element parent = element.parent();
                String title = parent.attr("title");
                String href = parent.attr("href");
                Document parentDoc = Jsoup.connect(href)
                        .timeout(4000)
                        .get();
                Elements parentImgs = parentDoc.getElementsByTag("img");
                for (Element parentImg : parentImgs) {
                    if (parentImg.parent().attr("href") == null || "".equals(parentImg.parent().attr("href"))) {
                        String originUrl = parentImg.attr("src");
                        image.setOriginUrl(originUrl);
                        break;
                    }
                }
                if ((shortUrl != null || !"".equals(shortUrl)) && (title != null || !"".equals(title))) {
                    image.setShortUrl(shortUrl);
                    image.setTitle(title);
                    images.add(image);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return images;
    }
}
