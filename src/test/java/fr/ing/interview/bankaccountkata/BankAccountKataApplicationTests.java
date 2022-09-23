package fr.ing.interview.bankaccountkata;

import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class BankAccountKataApplicationTests {
    @Test
    public void testGetCustomersStatusOk() throws IOException {
        // Given
        HttpUriRequest request = new HttpGet("http://localhost:8080/api/customers");

        // When
        CloseableHttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        // Then
        assertThat(httpResponse.getStatusLine().getStatusCode()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void testGetHistoryStatusOk() throws IOException {
        // Given
        HttpUriRequest request = new HttpGet("http://localhost:8080/api/customers/accounts/2/transactions");

        // When
        CloseableHttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        // Then
        assertThat(httpResponse.getStatusLine().getStatusCode()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void testDepositStatusOk() throws URISyntaxException, IOException {
        // Given
        URIBuilder builder = new URIBuilder("http://localhost:8080/api/customers/deposit");
        builder.setParameter("accountId", "2")
                .setParameter("amount", "1");

        HttpPut request = new HttpPut(builder.build());
        request.setHeader(HttpHeaders.ACCEPT, "*/*");

        // When
        CloseableHttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        // Then
        assertThat(httpResponse.getStatusLine().getStatusCode()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void testWithdrawStatusOk() throws URISyntaxException, IOException {
        // Given
        URIBuilder builder = new URIBuilder("http://localhost:8080/api/customers/withdraw");
        builder.setParameter("accountId", "2")
                .setParameter("amount", "1");

        HttpPut request = new HttpPut(builder.build());
        request.setHeader(HttpHeaders.ACCEPT, "*/*");

        // When
        CloseableHttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        // Then
        assertThat(httpResponse.getStatusLine().getStatusCode()).isEqualTo(HttpStatus.OK.value());
    }
}
