package org.interledger.connector.persistence.entities;

public interface DataConstants {

  interface TableNames {
    String ACCOUNT_SETTINGS = "ACCOUNT_SETTINGS";
    String ACCESS_TOKENS = "ACCESS_TOKENS";
    String DELETED_ACCOUNT_SETTINGS = "DELETED_ACCOUNT_SETTINGS";
    String FX_RATE_OVERRIDES = "FX_RATE_OVERRIDES";
    String STATIC_ROUTES = "STATIC_ROUTES";
    String INVOICES = "INVOICES";
  }

  interface ColumnNames {
    // ACCOUNT_SETTINGS
    String ACCOUNT_ID = "ACCOUNT_ID";
    String ACCOUNT_RELATIONSHIP = "ACCOUNT_RELATIONSHIP";
    String SE_ACCOUNT_ID = "SE_ACCOUNT_ID";

    // ACCOUNT TOKEN
    String ACCOUNT_TOKEN_IDX_COLUMNS = "ACCOUNT_ID";

    // FX_RATE_OVERRIDES
    String ASSET_CODE_IDX_COLUMNS = "ASSET_CODE_FROM,ASSET_CODE_TO";

    // STATIC_ROUTES
    String ADDRESS_PREFIX = "ADDRESS_PREFIX";

    // INVOICE ID
    String INVOICE_IDX_COLUMN_NAMES = "INVOICE_ID";
  }

  interface IndexNames {
    // ACCOUNT_SETTINGS
    String ACCT_REL_IDX = "ACCT_REL_IDX";

    // ACCOUNT_SETTINGS
    String ACCESS_TOKENS_ACCT_ID_IDX = "ACCESS_TOKENS_ACCT_ID_IDX";

    // DELETED_ACCOUNT_SETTINGS
    String DELETED_ACCT_REL_IDX = "DELETED_ACCT_REL_IDX";

    // FX_RATE_OVERRIDES
    String FX_RATE_OVERRIDES_IDX = "FX_RATE_OVERRIDES_IDX";

    // STATIC_ROUTES
    String STATIC_ROUTES_IDX = "STATIC_ROUTES_PREFIX_IDX";

    // INVOICES
    String INVOICES_ID_IDX = "INVOICES_ID_IDX";
  }

  interface ConstraintNames {
    // ACCOUNT_SETTINGS
    String ACCOUNT_SETTINGS_SETTLEMENT_ENGINE = "ACCOUNT_SETTINGS(SE_ACCOUNT_ID)";
  }

}
