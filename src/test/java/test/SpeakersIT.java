package test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

public class SpeakersIT {
    
    private Client client;
    private WebTarget tut;
    
    @Before
    public void initClinet() {
        this.client = ClientBuilder.newClient();
        this.tut = this.client.target("http://localhost:8080/testweb2/resources/speakers");
    }
    
    @Test
    public void smoke(){
        Response response = this.tut.request().get();
        assertThat(response.getStatus(), is(200));
        String result = response.readEntity(String.class);
        System.out.println("result = " + result);
    }
}
