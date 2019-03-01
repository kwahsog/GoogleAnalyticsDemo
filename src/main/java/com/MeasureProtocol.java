package com;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.servlet.ServletException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MeasureProtocol {

    public static void main(String[] args) throws IOException, ServletException {
        MeasureProtocol.doEvent();
        MeasureProtocol.doPageView();
    }

    public static void doPageView() throws IOException, ServletException {
        String trackingId = "UA-123-1";
        String clientId = "123";
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder();
        builder
                .setScheme("http")
                .setHost("www.google-analytics.com/")
                .setPath("/collect")
                .addParameter("v", "1") // API Version.
                .addParameter("tid", trackingId) // Tracking ID / Property ID.
                // Anonymous Client Identifier. Ideally, this should be a UUID that
                // is associated with particular user, device, or browser instance.
                .addParameter("cid", clientId)
                .addParameter("t", "pageview")
                .addParameter("dp", "/home");

        URI uri = null;
        try {
            uri = builder.build();
        } catch (URISyntaxException e) {
            throw new ServletException("Problem building URI", e);
        }
        HttpPost request = new HttpPost(uri);
        HttpResponse temp = client.execute(request);
        System.out.println("req procssed");
    }


    public static void doEvent() throws IOException, ServletException {
        String trackingId = "UA-123-1";
        String clientId = "123";
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder();
        builder
                .setScheme("http")
                .setHost("www.google-analytics.com/")
                .setPath("/collect")
                .addParameter("v", "1") // API Version.
                .addParameter("tid", trackingId) // Tracking ID / Property ID.
                .addParameter("cid", clientId)
                .addParameter("t", "event")
                .addParameter("ec", "login")
                .addParameter("ea", "success")
                .addParameter("ds", "app")
                ;
        URI uri = null;
        try {
            uri = builder.build();
        } catch (URISyntaxException e) {
            throw new ServletException("Problem building URI", e);
        }
        HttpPost request = new HttpPost(uri);
        HttpResponse temp = client.execute(request);
        //resp.getWriter().println("Event tracked.");

        HttpEntity httpEntity = temp.getEntity();
        String test = httpEntity.getContent().toString();

        System.out.println("req procssed");
    }
}
