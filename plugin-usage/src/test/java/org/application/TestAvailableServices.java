package org.application;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = Application.class)
@WebIntegrationTest(randomPort = true)
public class TestAvailableServices {

    @Value("${local.server.port}")
    private int localServerPort;

    private String localServer;
    private RestTemplate restTemplate;

    @Before
    public void init() {
        localServer = "http://localhost:" + localServerPort;
        // create a HttpClient that doesn't follow redirects. N.B. timeouts must be longer than application timeouts (for testing)
        CloseableHttpClient client = HttpClientBuilder.create().disableRedirectHandling().build();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(client);
        factory.setReadTimeout(60000);
        factory.setConnectTimeout(60000);
        factory.setConnectionRequestTimeout(60000);
        restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(factory);
    }

    @Test
    public void testUrls() {
        String response1 = restTemplate.getForObject(localServer + "/application", String.class);
        String response2 = restTemplate.getForObject(localServer + "/spring", String.class);
        assertThat(response1, is("ok"));
        assertThat(response2, is("ok"));
    }
}
