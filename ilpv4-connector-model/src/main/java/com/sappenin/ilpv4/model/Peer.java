package com.sappenin.ilpv4.model;

import org.immutables.value.Value;

import java.util.List;

/**
 * An account tracks a balance between two Interledger peers.
 */
@Value.Immutable
public interface Peer {

  PeerId getPeerId();

  /**
   * The relationship between this account and the local node. When an Interledger node peers with another node through
   * an account, the source peer will establish a relationship that can have one of three types depending on how it fits
   * into the wider network hierarchy.
   *
   * @return An {@link PeerType}.
   */
  PeerType getRelationship();

  /**
   * All accounts associated with this Peer.
   *
   * @return
   */
  List<Account> getAccounts();
}