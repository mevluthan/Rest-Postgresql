package com.example.product;

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

import org.glassfish.jersey.client.ClientConfig;

public class KullaniciClientTest {
    private static String baseURI = "http://localhost:8080/api/kullanici";

    static WebTarget getWebTarget() {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);

        return client.target(baseURI);
    }

    static void testList() {
        WebTarget target = getWebTarget();

        String response = target.request().accept(MediaType.APPLICATION_JSON).get(String.class);

        System.out.println(response);
    }

    static void testGet() {
        WebTarget target = getWebTarget();
        String productId = "3";
        Kullanici product = target.path(productId)
                .request().accept(MediaType.APPLICATION_JSON)
                .get(Kullanici.class);

        System.out.println(product);
    }

    static void testAdd() {
        WebTarget target = getWebTarget();
        Kullanici product = new Kullanici(1,"mecnun", "balboa",987,"evet");
        Kullanici product1=new Kullanici(1,"Rucky", "Dragon",789,"hayir");
        Response response = target.request()
                .post(Entity.entity(product, MediaType.APPLICATION_JSON), Response.class);

        System.out.println(response.getLocation().toString());
    }

    private static void testUpdate() {
        WebTarget target = getWebTarget();
        Kullanici product = new Kullanici(1,"Aci", "Yok",789,"Rocky");;
        String productId = "4";
        Response response = target.path(productId).request()
                .put(Entity.entity(product, MediaType.APPLICATION_JSON), Response.class);
        System.out.println(response);
    }

    private static void testDelete() {
        WebTarget target = getWebTarget();
        String productId = "3";
        Response response = target.path(productId).request()
                .delete(Response.class);
        System.out.println(response);
    }

    public static void main(String[] args) {
        // call a test method: testList(), testAdd(), testGet()...
        testList();
        testAdd();
        testList();
        testAdd();
        testList();
    }

}