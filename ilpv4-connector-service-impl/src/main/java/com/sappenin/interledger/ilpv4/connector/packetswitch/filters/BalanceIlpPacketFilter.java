package com.sappenin.interledger.ilpv4.connector.packetswitch.filters;

import org.interledger.core.InterledgerAddress;
import org.interledger.core.InterledgerPreparePacket;
import org.interledger.core.InterledgerResponsePacket;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;


/**
 * An implementation of {@link SendDataFilter} for handling balances between two accounts/plugins in an ILP connector.
 */
public class BalanceIlpPacketFilter implements SendDataFilter {

  @Override
  public CompletableFuture<Optional<InterledgerResponsePacket>> doFilter(
    final InterledgerAddress sourceAccountAddress,
    final InterledgerPreparePacket sourcePreparePacket,
    final SendDataFilterChain filterChain
  ) {

    // For now, this is just a pass-through.
    // TODO: Implement Balance tracking logic.

    // Call the next filter in the chain...
    return filterChain.doFilter(sourceAccountAddress, sourcePreparePacket);
  }
}