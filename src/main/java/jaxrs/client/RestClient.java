package jaxrs.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

/*
 *
 * https://hc.apache.org/httpcomponents-client-ga/quickstart.html
 */
public class RestClient {
    public static void main(String[] args) {
        new RestClient().get();
        new RestClient().post();
    }

    private void get() {
        System.out.println("===== HTTP GET Start =====");

        Client client = ClientBuilder.newBuilder().build();
        try {
            Response response =
                    client
                            .target("http://localhost:8080/add/1?x=3")
                            .request()
                            .get();

            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                System.out.println(response.readEntity(String.class));
            }

            response.close();
        } finally {
            client.close();
        }

        System.out.println("===== HTTP GET End =====");
    }

    private void post() {
        System.out.println("===== HTTP POST Start =====");

        StringBuilder builder = new StringBuilder();
        builder.append("POST Body");
        builder.append("\r\n");
        builder.append("Http Server!!");
        builder.append("\r\n");

        Client client = ClientBuilder.newBuilder().build();
        try {
            Response response =
                    client
                            .target("http://localhost:8080/post")
                            .request()
                            .post(Entity.text(builder.toString()));

            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                System.out.println(response.readEntity(String.class));
            }

            response.close();
        } finally {
            client.close();
        }

        System.out.println("===== HTTP POST End =====");
    }

}
