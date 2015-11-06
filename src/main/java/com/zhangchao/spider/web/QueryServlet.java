package com.zhangchao.spider.web;

import com.alibaba.fastjson.JSONArray;
import com.zhangchao.spider.bean.Image;
import com.zhangchao.spider.util.SpiderUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhangchao19 on 2015/10/29.
 */
public class QueryServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        String pageNum = req.getParameter("pageNum");
        String category = req.getParameter("category");
        List<Image> images = SpiderUtil.getPictures(category, pageNum);
        String imageStr = JSONArray.toJSONString(images, true);
        resp.setContentType("text/html;charset=utf-8");
        try {
            resp.getWriter().print(imageStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
