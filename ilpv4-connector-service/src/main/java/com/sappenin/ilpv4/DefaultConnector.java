package com.sappenin.ilpv4;

import com.sappenin.ilpv4.model.Account;
import com.sappenin.ilpv4.peer.PeerManager;
import com.sappenin.ilpv4.settings.ConnectorSettings;
import org.interledger.core.InterledgerFulfillPacket;
import org.interledger.core.InterledgerPreparePacket;
import org.interledger.core.InterledgerProtocolException;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.Objects;
import java.util.concurrent.Future;

/**
 * A default implementation of {@link Connector}.
 */
public class DefaultConnector implements Connector {

  private final ConnectorSettings connectorSettings;
  private final PeerManager peerManager;

  public DefaultConnector(final ConnectorSettings connectorSettings, final PeerManager peerManager) {
    this.connectorSettings = Objects.requireNonNull(connectorSettings);
    this.peerManager = Objects.requireNonNull(peerManager);
  }

  @PostConstruct
  private final void init() {
    // For each peer, add it to the PeerManager.
    connectorSettings.getPeers().stream()
      .map(ConnectorSettings.ConfiguredPeer::toPeer)
      .forEach(peerManager::add);
  }

  @Override
  public Future<InterledgerFulfillPacket> handleIncomingData(
    Account sourceAccount, InterledgerPreparePacket interledgerPreparePacket
  ) throws InterledgerProtocolException {

    throw new RuntimeException("Not yet implemented!");
  }

  @Override
  public Future<Void> handleIncomingMoney(BigInteger amount) {
    return null;
  }
}