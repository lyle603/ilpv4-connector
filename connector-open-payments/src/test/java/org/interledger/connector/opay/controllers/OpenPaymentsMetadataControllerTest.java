package org.interledger.connector.opay.controllers;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.interledger.connector.opay.controllers.OpenPaymentsMetadataController;
import org.interledger.connector.opay.controllers.constants.PathConstants;
import org.interledger.connector.opay.model.OpenPaymentsMetadata;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = OpenPaymentsMetadataController.class)
public class OpenPaymentsMetadataControllerTest {
  @Autowired
  private MockMvc mvc;

  @Autowired
  private OpenPaymentsMetadata openPaymentsMetadata;

  @Before
  public void setUp() {
    initMocks(this);
  }

  @Test
  public void getOpenPaymentsMetadata() throws Exception {
    HttpHeaders headers = this.testJsonHeaders();

    this.mvc
      .perform(get(PathConstants.OPEN_PAYMENTS_METADATA)
        .headers(headers)
      )
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.issuer").value(openPaymentsMetadata.issuer().toString()))
      .andExpect(jsonPath("$.authorization_issuer").value(openPaymentsMetadata.authorizationIssuer().toString()))
      .andExpect(jsonPath("$.authorization_endpoint").value(openPaymentsMetadata.authorizationEndpoint().toString()))
      .andExpect(jsonPath("$.token_endpoint").value(openPaymentsMetadata.authorizationEndpoint().toString()))
      .andExpect(jsonPath("$.invoices_endpoint").value(openPaymentsMetadata.invoicesEndpoint().toString()))
      .andExpect(jsonPath("$.mandates_endpoint").value(openPaymentsMetadata.mandatesEndpoint().toString()))
      .andExpect(jsonPath("$.assets_supported[0].code").value(openPaymentsMetadata.assetsSupported().get(0).assetCode()))
      .andExpect(jsonPath("$.assets_supported[0].scale").value(openPaymentsMetadata.assetsSupported().get(0).assetScale()))
      .andExpect(jsonPath("$.assets_supported[1].code").value(openPaymentsMetadata.assetsSupported().get(1).assetCode()))
      .andExpect(jsonPath("$.assets_supported[1].scale").value(openPaymentsMetadata.assetsSupported().get(1).assetCode()));
  }
}
